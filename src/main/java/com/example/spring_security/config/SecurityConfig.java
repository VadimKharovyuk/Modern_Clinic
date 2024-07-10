package com.example.spring_security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
//                    .requestMatchers( "/login", "/", "/pic/**","/forgot-password","/register","/patient/dashboard").permitAll() // Разрешение на открытый доступ
//                    .requestMatchers("/account/**").authenticated() // Требование аутентификации
//                    .anyRequest().authenticated() // Любые другие запросы также требуют аутентификации
//            ))
//            .formLogin((form -> form
//                    .loginPage("/login") // Настройка страницы входа
//                    .permitAll() // Разрешить доступ к странице входа
//            ))
//            .logout((log -> log
//                    .logoutUrl("/logout") // URL для выхода из системы
//                    .logoutSuccessUrl("/login") // Перенаправление после успешного выхода
//                    .permitAll() // Разрешение на выход без аутентификации
//            )).csrf().disable(); // Отключение CSRF, если это необходимо
//
//    return httpSecurity.build();
//}
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .authorizeHttpRequests((req -> req
                    .requestMatchers("/login", "/", "/pic/**", "/forgot-password", "/register").permitAll()
                    .requestMatchers("/patient/dashboard").authenticated()
                    .requestMatchers("/account/**").authenticated()
                    .anyRequest().authenticated()
            ))
            .formLogin((form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/patient/dashboard", true) // URL после успешного входа
                    .permitAll()
                    .failureUrl("/login") // URL после неудачного входа
            ))
            .logout((log -> log
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout=true")
                    .permitAll()
            ))
            .csrf().disable(); // Отключение CSRF, если это необходимо

    return httpSecurity.build();
}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
