package com.example.spring_security.service;

import com.example.spring_security.model.Contact;
import com.example.spring_security.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;


    public List<Contact> getAll(){
        return contactRepository.findAll();
    }
    public Contact contactSave(Contact contact){
       return contactRepository.save(contact);
    }
    public void deleteContackt(Long id){
        contactRepository.deleteById(id);
    }
}
