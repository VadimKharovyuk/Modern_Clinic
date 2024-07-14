package com.example.spring_security.controller;

import com.example.spring_security.model.Appointment;
import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.Patient;
import com.example.spring_security.model.User;
import com.example.spring_security.service.AppointmentService;
import com.example.spring_security.service.DoctorService;
import com.example.spring_security.service.PatientService;
import com.example.spring_security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class AppointmentController {

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final UserService userService;

    @GetMapping("/appointment/form")
    public String showAppointmentForm(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "Appointment/appointmentForm";
    }

    @PostMapping("/appointment/save")
    public String saveAppointment(@RequestParam Long doctorId,
                                  @RequestParam String appointmentDateTime,
                                  @RequestParam String reason,
                                  Authentication authentication) {
        // Получение текущего пользователя
        User currentUser = userService.findByUsername(authentication.getName());
        Patient patient = patientService.findByUser(currentUser);

        // Получение выбранного доктора
        Doctor doctor = doctorService.getDoctorById(doctorId);

        // Преобразование строки времени в LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(appointmentDateTime, formatter);
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), time);

        // Создание новой записи
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDateTime(dateTime);
        appointment.setReason(reason);

        appointmentService.saveAppointment(appointment);

        return "redirect:/patient/dashboard";
    }


    @GetMapping("/patient/{patientId}/appointments")
    public String getAppointmentsByPatient(@PathVariable Long patientId, Model model) {
        Patient patient = patientService.getPatientById(patientId);
        List<Appointment> appointments = appointmentService.getAppointmentsByPatient(patient);
        model.addAttribute("appointments", appointments);
        model.addAttribute("patient", patient); // Добавляем пациента в модель для использования в шаблоне
        return "Appointment/appointments"; // Имя HTML-шаблона для отображения
    }


    @PostMapping("/appointment/delete/{id}")
    public String deleteAppointmentById(@PathVariable Long id, HttpServletRequest request){
        appointmentService.deleteAppointment(id);

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
//        return "redirect:/patient/dashboard"; // Перенаправление на страницу списка записей пациента

    }

}

