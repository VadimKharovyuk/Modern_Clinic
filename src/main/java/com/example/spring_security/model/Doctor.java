package com.example.spring_security.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String specialization;
    private String workingHours;
    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToMany(mappedBy = "doctors")
    private List<Category> categories;


    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

}
