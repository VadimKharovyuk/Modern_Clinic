package com.example.spring_security.controller;

import com.example.spring_security.model.Appointment;
import com.example.spring_security.model.Patient;
import com.example.spring_security.model.User;
import com.example.spring_security.service.AppointmentService;
import com.example.spring_security.service.PatientService;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private final UserService userService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @GetMapping("/patient/dashboard")
    public String showPatientDashboard(Model model, Authentication authentication) {
        // Получение текущего пользователя
        User user = userService.findByUsername(authentication.getName());

        // Получение информации о пациенте
        Patient patient = patientService.findByUser(user);

        // Получение записей к докторам для данного пациента
        List<Appointment> appointments = appointmentService.findByPatient(patient);

        // Добавление данных в модель
        model.addAttribute("user", user);
        model.addAttribute("patient", patient);
        model.addAttribute("appointments", appointments);

        return "Patient/patientDashboard";
    }

    @GetMapping("/patient/form")
    public String showForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "Patient/patientForm";
    }

    @PostMapping("/patient/save")
    public String savePatient(Patient patient, Authentication authentication) {
        // Получение текущего пользователя
        User currentUser = userService.findByUsername(authentication.getName());
        patient.setUser(currentUser);

        // Сохранение пациента
        patientService.saveOrUpdatePatient(patient);
        return "redirect:/patient/dashboard";
    }
}
