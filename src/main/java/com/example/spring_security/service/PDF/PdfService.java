package com.example.spring_security.service.PDF;

import com.example.spring_security.model.Diagnosis;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class PdfService {

    private static final Logger LOGGER = Logger.getLogger(PdfService.class.getName());

    public ByteArrayInputStream generateDiagnosisListPdf(List<Diagnosis> diagnoses) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document(); // Используем правильный класс Document из iText
        try {
            PdfWriter.getInstance(document, out);

            // Open the document
            document.open();

            // Add title
            document.add(new Paragraph("List of diagnoses"));

            // Create table with 3 columns
            PdfPTable table = new PdfPTable(3);
            table.setWidths(new int[]{4, 4, 12});

            // Add table headers
            table.addCell("Doctor");
            table.addCell("Date");
            table.addCell("Description");

            // Add table rows
            for (Diagnosis diagnosis : diagnoses) {
                if (diagnosis.getDoctor() != null && diagnosis.getCreatedDateTime() != null && diagnosis.getDescription() != null) {
                    table.addCell(diagnosis.getDoctor().getName());
                    table.addCell(diagnosis.getCreatedDateTime().toString());
                    table.addCell(diagnosis.getDescription());
                } else {
                    LOGGER.warning("Не удалось добавить диагноз в PDF: некорректные данные");
                }
            }

            document.add(table);

        } catch (Exception e) {
            LOGGER.severe("Ошибка при создании PDF: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the document
            document.close();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
