package com.example.spring_security.controller;

import com.example.spring_security.model.Contact;
import com.example.spring_security.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    @GetMapping()
    public String getAll(Model model){
        model.addAttribute("contacts", contactService.getAll());
        return "Contact/contactList";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("contact",new Contact());
        return "Contact/contactForm";
    }
    @PostMapping("/save")
    public String save(Contact contact){
        contactService.contactSave(contact);
        return "redirect:/contact";

    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        contactService.deleteContackt(id);
        return "redirect:/contact";
    }

}
