
package com.example.spring_security.service;

import com.example.spring_security.model.Category;
import com.example.spring_security.model.Doctor;
import com.example.spring_security.repository.CategoryRepository;
import com.example.spring_security.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final DoctorRepository doctorRepository;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @Cacheable(value = "getCategoryById", key = "#id")
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public void addDoctorToCategory(Long categoryId, Long doctorId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        category.getDoctors().add(doctor);
        categoryRepository.save(category);
    }
    public List<Doctor> getDoctorsForCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        return category.getDoctors();
    }


    public void removeDoctorFromCategory(Long categoryId, Long doctorId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);

        if (categoryOptional.isPresent() && doctorOptional.isPresent()) {
            Category category = categoryOptional.get();
            Doctor doctor = doctorOptional.get();

            // Удаляем доктора из категории
            category.getDoctors().remove(doctor);
            categoryRepository.save(category);
        } else {
            throw new EntityNotFoundException("Category or Doctor not found");
        }
    }
}
