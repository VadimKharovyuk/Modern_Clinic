package com.example.spring_security.controller;
import com.example.spring_security.model.Appointment;
import com.example.spring_security.model.Diagnosis;
import com.example.spring_security.model.Patient;
import com.example.spring_security.model.User;
import com.example.spring_security.service.AppointmentService;
import com.example.spring_security.service.DiagnosisService;
import com.example.spring_security.service.PDF.PdfService;
import com.example.spring_security.service.PatientService;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;
@Controller
@AllArgsConstructor
public class PatientController {

    private final UserService userService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final DiagnosisService diagnosisService;
    private final PdfService pdfService;


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

    @GetMapping("/patients/{patientId}/diagnoses/pdf")
    public ResponseEntity<InputStreamResource> getDiagnosesPdf(@PathVariable Long patientId) {
        // Получаем список диагнозов для указанного пациента
        List<Diagnosis> diagnoses = diagnosisService.getDiagnosesByPatientId(patientId);

        // Генерируем PDF из списка диагнозов
        ByteArrayInputStream bis = pdfService.generateDiagnosisListPdf(diagnoses);

        // Настройка HTTP-ответа для возврата PDF
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=diagnoses.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
