package com.example.spring_security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {


    private final CustomUserDetailsService userDetailsService;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity
//            .authorizeHttpRequests((req -> req
//                    .requestMatchers("/login", "/", "/pic/**", "/forgot-password", "/register","/doctor/list").permitAll()
//                    .requestMatchers("/doctor/**").hasAnyRole("ADMIN")
//                    .requestMatchers("/patient/list").hasAnyRole("ADMIN")
//                    .requestMatchers("/doctor/account/**").hasRole("DOCTOR")
//
//                    .requestMatchers("/patient/dashboard").authenticated()
////                    .requestMatchers("/account/**").authenticated()
//
//                    .anyRequest().authenticated()
//            ))
//            .formLogin((form -> form
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/", true) // URL после успешного входа
//                    .permitAll()
////                    .failureUrl("/register") // URL после неудачного входа
//            ))
//            .logout((log -> log
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/login?logout=true")
//                    .permitAll()
//            ))
//
//            .csrf().disable(); // Отключение CSRF, если это необходимо
//
//    return httpSecurity.build();
//}
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .authorizeHttpRequests((req -> req
                    .requestMatchers("/login", "/", "/pic/**", "/forgot-password", "/register", "/doctor/list","/blocked","/categories/**","/doctors/profile/{doctorId}","/contact").permitAll()
                    .requestMatchers("/doctor/account/**").hasRole("DOCTOR")
                    .requestMatchers("/doctor/**").hasRole("ADMIN")
                    .requestMatchers("/patient/list").hasRole("ADMIN")
                    .requestMatchers("/block-user/**").hasRole("ADMIN")
                    .requestMatchers("/unblock-user/**").hasRole("ADMIN")
                    .requestMatchers("/userList").hasRole("ADMIN")
                    .requestMatchers("/patients/search").hasRole("ADMIN")

                    .requestMatchers("/change-password").authenticated()
                    .requestMatchers("/patient/dashboard").authenticated()
                    .anyRequest().authenticated()
            ))
            .formLogin((form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true) // URL после успешного входа

                    .permitAll()
            ))
            .logout((log -> log
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout=true")
                    .permitAll()
            ))
            .exceptionHandling((ex) -> ex
                    .accessDeniedPage("/access-denied") // Перенаправление на страницу для заблокированных пользователей

            )
            .csrf().disable(); // Отключение CSRF, если это необходимо
    return httpSecurity.build();
}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
