package com.example.spring_security.controller;

import com.example.spring_security.model.Appointment;
import com.example.spring_security.model.Patient;
import com.example.spring_security.model.User;
import com.example.spring_security.service.AppointmentService;
import com.example.spring_security.service.PatientPDFExporter;
import com.example.spring_security.service.PatientService;
import com.example.spring_security.service.UserService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private final UserService userService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;


    @GetMapping("/patient/dashboard/account")
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

//        return "Patient/patientDashboard";
        return "Patient/showPatientDashboard";
    }
    @GetMapping("/patient/dashboard")
    public String PatientDashboard(Model model, Authentication authentication) {
        // Получение текущего пользователя
        User user = userService.findByUsername(authentication.getName());

        // Получение информации о пациенте
        Patient patient = patientService.findByUser(user);

        // Добавление данных в модель
        model.addAttribute("user", user);
        model.addAttribute("patient", patient);

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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/patient/list")
    public String listPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "Patient/patientList";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/patient/{id}")
    public String viewPatient(@PathVariable("id") Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "Patient/patientDetail";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable ("id") Long id){
        patientService.deletePatient(id);
        return "redirect:/patient/list";


    }

    @GetMapping("/patient/appointments/{id}")
    public String viewPatientAppointments(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        List<Appointment> appointments = appointmentService.findByPatient(patient);
        model.addAttribute("patient", patient);
        model.addAttribute("appointments", appointments);
        return "Patient/patientAppointments";
    }





    // Метод для отображения формы обновления данных пациента

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "Patient/patientEditForm";
    }

    // Метод для сохранения изменений данных пациента
    @PostMapping("/update")
    public String updatePatient(@ModelAttribute("patient") Patient updatedPatient ,Authentication authentication) {
//         Получение текущего пользователя можно добавить, если нужно
         User currentUser = userService.findByUsername(authentication.getName());
         updatedPatient.setUser(currentUser);

        // Обновление данных пациента
        patientService.saveOrUpdatePatient(updatedPatient);
        return "redirect:/patient/dashboard";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/patients/search")
    public String showSearchForm() {
        return "Patient/search";
    }
    @PostMapping("/patients/search")
    public String searchPatients(@RequestParam("firstName") String firstName,
                                 Model model) {
        List<Patient> patients = patientService.findPatientByName(firstName);
        model.addAttribute("patients", patients);
        return "Patient/search";
    }

    @GetMapping("/patients/search-age")
    public String Search(){
        return "Patient/search-form.age";
    }
    @GetMapping("patients/age-range")
    public String getPatientsByAgeRange(@RequestParam int minAge, @RequestParam int maxAge, Model model) {
        List<Patient> patients = patientService.getPatientsByAgeRange(minAge, maxAge);
        model.addAttribute("patients", patients);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        return "Patient/Search_Patients";
    }





    @GetMapping("/patients/export/pdf/{id}")
    public void exportToPDF(@PathVariable("id") Long id, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=patient_" + id + ".pdf";
        response.setHeader(headerKey, headerValue);

        Patient patient = patientService.findById(id);
        PatientPDFExporter exporter = new PatientPDFExporter(List.of(patient));
        exporter.export(response);
    }
}
