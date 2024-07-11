//package com.example.spring_security.controller;
//
//import com.example.spring_security.model.Doctor;
//import com.example.spring_security.service.DoctorService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//@AllArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
////@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//public class DoctorController {
//    private  final  DoctorService doctorService;
//
//
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/doctor/form")
//    public String showDoctorForm(Model model) {
//        model.addAttribute("doctor", new Doctor());
//        return "Doctor/doctorForm";
//    }
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/doctor/save")
//    public String saveDoctor(Doctor doctor) {
//        doctorService.saveDoctor(doctor);
//        return "redirect:/doctor/list";
//    }
//
//    @GetMapping("/doctor/list")
//    public String listDoctors(Model model) {
//        model.addAttribute("doctors", doctorService.getAllDoctors());
//        return "Doctor/doctorList";
//    }
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/doctor/delete/{id}")
//    public String deleteDoctorById(@PathVariable ("id") Long id) {
//        doctorService.deleteDoctor(id);
//        return "redirect:/doctor/list";
//
//    }
//}
package com.example.spring_security.controller;

import com.example.spring_security.model.Doctor;
import com.example.spring_security.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class DoctorController {
    private final DoctorService doctorService;

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
}
