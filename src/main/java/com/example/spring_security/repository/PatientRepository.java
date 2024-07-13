package com.example.spring_security.repository;

import com.example.spring_security.model.Patient;
import com.example.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByUser(User user);
    List<Patient> findByFirstNameContainingIgnoreCase(String firstName);

//    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth <= :maxDate")
//    List<Patient> findPatientsOlderThan(@Param("maxDate") LocalDate maxDate);
@Query("SELECT p FROM Patient p WHERE " +
        "YEAR(CURRENT_DATE) - YEAR(p.dateOfBirth) - " +
        "(CASE WHEN MONTH(CURRENT_DATE) < MONTH(p.dateOfBirth) " +
        "OR (MONTH(CURRENT_DATE) = MONTH(p.dateOfBirth) AND DAY(CURRENT_DATE) < DAY(p.dateOfBirth)) " +
        "THEN 1 ELSE 0 END) BETWEEN :minAge AND :maxAge")
List<Patient> findPatientsByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);
}
