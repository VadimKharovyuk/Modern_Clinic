package com.example.spring_security.controller;
import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.User;
import com.example.spring_security.service.DoctorService;
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
//@PreAuthorize("hasRole('ADMIN')")
public class DoctorController {
    private final DoctorService doctorService;
    private final UserService userService;

    @GetMapping("/doctor/form")
    public String showDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "Doctor/doctorForm";
    }

    @PostMapping("/doctor/save")
    public String saveDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctor/list";
    }

    @GetMapping("/doctor/list")
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "Doctor/doctorList";
    }

    @PostMapping("/doctor/delete/{id}")
    public String deleteDoctorById(@PathVariable("id") Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctor/list";
    }

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard() {
        return "Admin/adminDashboard";
    }

@PreAuthorize("hasRole('DOCTOR')")
@GetMapping("/doctor/account")
public String viewDoctorAccount(Model model, Principal principal) {
    User user = userService.findByUsername(principal.getName());
    Doctor doctor = doctorService.findByUser(user);
    model.addAttribute("doctor", doctor);
    return "Doctor/doctorAccount";
}

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/doctor/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "Doctor/edit";
    }

    @PostMapping("/doctor/update/{id}")
    public String updateDoctor(@PathVariable("id") Long id, @ModelAttribute("doctor") Doctor updatedDoctor) {
        Doctor doctor = doctorService.getDoctorById(id);
        // Update fields from updatedDoctor
        doctor.setName(updatedDoctor.getName());
        doctor.setSpecialization(updatedDoctor.getSpecialization());

        doctorService.saveDoctor(doctor);
        return "redirect:/doctor/list";
    }


    @GetMapping("/doctors/profile/{doctorId}")
    public String viewDoctorProfile(@PathVariable Long doctorId, Model model) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        model.addAttribute("doctor", doctor);
        return "Doctor/doctorFrofile";
    }


//    @GetMapping("/doctors/specializations")
//    public String getSpecializations(Model model) {
//        List<String> specializations = doctorService.getDistinctSpecializations();
//        model.addAttribute("specializations", specializations);
//        return "Doctor/doctor-specializations";
//    }

    @GetMapping("/doctors")
    public String getDoctorsBySpecialization(@RequestParam("specialization") String specialization, Model model) {
        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
        model.addAttribute("doctors", doctors);
        return "Doctor/doctor-list-specialization";
    }


}
