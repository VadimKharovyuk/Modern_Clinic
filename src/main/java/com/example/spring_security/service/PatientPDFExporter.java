//package com.example.spring_security.service;
//import com.example.spring_security.model.Patient;
//import com.lowagie.text.*;
//import com.lowagie.text.Font;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.awt.*;
//import java.io.IOException;
//import java.util.List;
//
//@AllArgsConstructor
//@Service
//public class PatientPDFExporter {
//    private List<Patient> listPatients;
//
//
//    private void writeTableHeader(PdfPTable table) {
//        PdfPCell cell = new PdfPCell();
//        cell.setBackgroundColor(Color.BLUE);
//        cell.setPadding(5);
//
//        Font font = FontFactory.getFont(FontFactory.HELVETICA);
//        font.setColor(Color.WHITE);
//
//        cell.setPhrase(new Phrase("ID", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Имя", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Фамилия", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Дата рождения", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Пол", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Адрес", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Телефон", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Вес (кг)", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Рост (см)", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Аллергии", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("Экстренный контакт", font));
//        table.addCell(cell);
//    }
//
//    private void writeTableData(PdfPTable table) {
//        for (Patient patient : listPatients) {
//            table.addCell(String.valueOf(patient.getId()));
//            table.addCell(patient.getFirstName());
//            table.addCell(patient.getLastName());
//            table.addCell(patient.getDateOfBirth().toString());
//            table.addCell(patient.getGender());
//            table.addCell(patient.getAddress());
//            table.addCell(patient.getPhoneNumber());
//            table.addCell(String.valueOf(patient.getWeight()));
//            table.addCell(String.valueOf(patient.getHeight()));
//            table.addCell(patient.getAllergies());
//            table.addCell(patient.getEmergencyContact());
//        }
//    }
//
//
//    public void export(HttpServletResponse response) throws DocumentException, IOException {
//        Document document = new Document(PageSize.A4);
//        PdfWriter.getInstance(document, response.getOutputStream());
//
//        document.open();
//        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//        font.setSize(18);
//        font.setColor(Color.BLUE);
//
//        Paragraph p = new Paragraph("Список пациентов", font);
//        p.setAlignment(Paragraph.ALIGN_CENTER);
//
//        document.add(p);
//
//        PdfPTable table = new PdfPTable(11);
//        table.setWidthPercentage(100f);
//        table.setWidths(new float[]{1.0f, 1.5f, 1.5f, 1.5f, 1.0f, 2.0f, 1.5f, 1.0f, 1.0f, 2.0f, 2.0f});
//        table.setSpacingBefore(10);
//
//        writeTableHeader(table);
//        writeTableData(table);
//
//        document.add(table);
//
//        document.close();
//    }
//}
package com.example.spring_security.service;

import com.example.spring_security.model.Patient;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class PatientPDFExporter {
    private List<Patient> listPatients;

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Имя", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Фамилия", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Дата рождения", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Пол", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Адрес", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Телефон", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Вес (кг)", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Рост (см)", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Аллергии", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Экстренный контакт", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Patient patient : listPatients) {
            table.addCell(String.valueOf(patient.getId()));
            table.addCell(patient.getFirstName());
            table.addCell(patient.getLastName());
            table.addCell(patient.getDateOfBirth().toString());
            table.addCell(patient.getGender());
            table.addCell(patient.getAddress());
            table.addCell(patient.getPhoneNumber());
            table.addCell(String.valueOf(patient.getWeight()));
            table.addCell(String.valueOf(patient.getHeight()));
            table.addCell(patient.getAllergies());
            table.addCell(patient.getEmergencyContact());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Список пациентов", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(11);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.0f, 1.5f, 1.5f, 1.5f, 1.0f, 2.0f, 1.5f, 1.0f, 1.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
