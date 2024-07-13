package com.example.spring_security.controller;

import com.example.spring_security.model.Appointment;
import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.Patient;
import com.example.spring_security.model.User;
import com.example.spring_security.service.AppointmentService;
import com.example.spring_security.service.DoctorService;
import com.example.spring_security.service.PatientService;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@PreAuthorize("hasRole('USER')") // Предполагается, что пользователи с ролью USER имеют доступ к записи к доктору
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
                                  @RequestParam LocalDateTime appointmentDateTime,
                                  @RequestParam String reason,
                                  Authentication authentication) {
        // Получение текущего пациента
        User currentUser = userService.findByUsername(authentication.getName());
        Patient patient = patientService.findByUser(currentUser);

        // Получение выбранного доктора
        Doctor doctor = doctorService.getDoctorById(doctorId);

        // Создание новой записи
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDateTime(appointmentDateTime);
        appointment.setReason(reason);

        appointmentService.saveAppointment(appointment);

        return "redirect:/patient/dashboard";
    }
}
