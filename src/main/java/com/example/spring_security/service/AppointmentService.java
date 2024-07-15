package com.example.spring_security.service;

import com.example.spring_security.model.Appointment;
import com.example.spring_security.model.Doctor;
import com.example.spring_security.model.Patient;
import com.example.spring_security.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final EmailService emailService;

    public List<Appointment> getAppointmentsByPatientAndDoctor(Patient patient, Doctor doctor) {
        return appointmentRepository.findByPatientAndDoctor(patient, doctor);
    }


    public List<Appointment> findByPatient(Patient patient) {
        return appointmentRepository.findByPatient(patient);
    }


    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow();
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> getAppointmentsByPatient(Patient patient) {
        return appointmentRepository.findByPatient(patient);
    }

public void createAndNotifyAppointment(Long doctorId, Patient patient, LocalDateTime dateTime, String reason, String recipientEmail) {
    // Получение выбранного доктора
    Doctor doctor = doctorService.getDoctorById(doctorId);

    // Создание новой записи
    Appointment appointment = new Appointment();
    appointment.setDoctor(doctor);
    appointment.setPatient(patient);
    appointment.setAppointmentDateTime(dateTime);
    appointment.setReason(reason);

    // Сохранение записи
    saveAppointment(appointment);

    // Формирование и отправка email
    String subject = "Подтверждение записи на прием";

    String message = String.format(
            "Уважаемый(ая) %s %s,\n\n" +
                    "Мы рады подтвердить вашу запись на прием в нашу клинику.\n\n" +
                    "Детали вашей записи:\n" +
                    "-------------------------------------\n" +
                    "Доктор: %s\n" +
                    "Специализация: %s\n" +
                    "Дата и время: %s\n" +
                    "Причина визита: %s\n" +
                    "-------------------------------------\n\n" +
                    "Пожалуйста, убедитесь, что вы прибудете за 10 минут до назначенного времени. В случае необходимости отмены или изменения записи, свяжитесь с нами по телефону или через наш сайт.\n\n" +
                    "Спасибо за выбор нашей клиники. Желаем вам крепкого здоровья!\n\n" +
                    "С уважением,\n" +
                    "Команда вашей клиники",
            patient.getFirstName(), patient.getLastName(), doctor.getName(), doctor.getSpecialization(),
            dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), reason
    );

    emailService.sendEmail(recipientEmail, subject, message);
}

}
