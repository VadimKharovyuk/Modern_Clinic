package com.example.spring_security.controller;
import com.example.spring_security.model.Diagnosis;
import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.Patient;
import com.example.spring_security.service.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@AllArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisController.class);
    private final UserService userService;

    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/diagnosis/form")
    public String showDiagnosisForm(@RequestParam Long doctorId,
                                    @RequestParam Long patientId,
                                    Model model) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.getPatientById(patientId);
        model.addAttribute("doctor", doctor);
        model.addAttribute("patient", patient);
        model.addAttribute("diagnosis", new Diagnosis());
        return "Diagnosis/diagnosisForm";
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @PostMapping("/diagnosis/save")
    public String saveDiagnosis(@RequestParam Long doctorId,
                                @RequestParam Long patientId,
                                @RequestParam String description) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.getPatientById(patientId);

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDoctor(doctor);
        diagnosis.setPatient(patient);
        diagnosis.setDescription(description);

        diagnosisService.saveDiagnosis(diagnosis);
        return "redirect:/doctor/account";
    }

@PreAuthorize("hasRole('USER')")
@GetMapping("/patient/{patientId}/diagnoses")
public String getDiagnosesByPatient(@PathVariable Long patientId, Model model) {
    List<Diagnosis> diagnoses = diagnosisService.getDiagnosesByPatientId(patientId);
    model.addAttribute("diagnoses", diagnoses);
    model.addAttribute("patientId", patientId);
    return "Appointment/diagnosisList";
}






    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/diagnoses/list")
        public String getAllDiagnoses(Model model) {
            List<Diagnosis> diagnoses = diagnosisService.getAllDiagnoses();
            model.addAttribute("diagnoses", diagnoses);
            return "Diagnosis/diagnosisList";
        }

    @PreAuthorize("hasRole('DOCTOR')")
    @PostMapping("/diagnoses/delete/{id}")
    public String deleteDiagnosis(@PathVariable Long id) {
        diagnosisService.deleteDiagnosis(id);
        return "redirect:/diagnoses/list";
    }



}
