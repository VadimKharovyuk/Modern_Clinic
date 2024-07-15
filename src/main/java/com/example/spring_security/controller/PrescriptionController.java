package com.example.spring_security.controller;

import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.Patient;
import com.example.spring_security.model.Prescription;
import com.example.spring_security.service.DoctorService;
import com.example.spring_security.service.PatientService;
import com.example.spring_security.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@PreAuthorize("hasRole('DOCTOR')")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final DoctorService doctorService;
    private final PatientService patientService;

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
}
