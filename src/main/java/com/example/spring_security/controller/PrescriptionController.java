package com.example.spring_security.controller;

import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.Patient;
import com.example.spring_security.model.Prescription;
import com.example.spring_security.model.User;
import com.example.spring_security.service.DoctorService;
import com.example.spring_security.service.PatientService;
import com.example.spring_security.service.PrescriptionService;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@PreAuthorize("hasRole('DOCTOR')")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final UserService userService;

    @GetMapping("/prescriptions/form")
    public String showPrescriptionForm(@RequestParam Long doctorId,
                                       @RequestParam Long patientId,
                                       Model model) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.getPatientById(patientId);
        model.addAttribute("doctor", doctor);
        model.addAttribute("patient", patient);
        model.addAttribute("prescription", new Prescription());
        return "Prescription/prescriptionForm";
    }

    @PostMapping("/prescriptions/save")
    public String savePrescription(@RequestParam Long doctorId,
                                   @RequestParam Long patientId,
                                   @RequestParam String description,
                                   @RequestParam String treatmentTime) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.getPatientById(patientId);

        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setDescription(description);
        prescription.setTreatmentTime(treatmentTime);

        prescriptionService.savePrescription(prescription);
        return "redirect:/doctor/account";
    }

    @GetMapping("/prescriptions/list")
    public String listPrescriptionsForDoctor(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Doctor doctor = doctorService.findByUser(user);

        List<Prescription> prescriptions = prescriptionService.getAllPrescriptionsForDoctor(doctor);
        model.addAttribute("prescriptions", prescriptions);
        return "Prescription/prescriptionList";
    }
    @PostMapping("/prescriptions/delete/{id}")
    public String deleteByIdPrescriptions(@PathVariable Long id){
        prescriptionService.deletePrescription(id);
        return "redirect:/prescriptions/list";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/patient/{patientId}/prescriptions")
    public String getPrescriptionsByPatient(@PathVariable Long patientId, Model model) {
        Patient patient = patientService.getPatientById(patientId);
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptionsForPatient(patientId);
        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("patient", patient); // Добавляем пациента в модель для использования в шаблоне
        return "Appointment/prescriptionList"; // Имя HTML-шаблона для отображения списка рецептов
    }

}
