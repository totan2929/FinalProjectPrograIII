package org.ciaf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.ciaf.product.Product;
import org.ciaf.sale.Sale;
import org.ciaf.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class InvoicePDF {
    public void generateInvoice(Sale sale, User client) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try {
            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 16);
            content.newLineAtOffset(50, 750);
            content.showText("Invoice - Electronic Store");
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 12);
            content.newLineAtOffset(50, 730);
            content.showText("Date: " + LocalDate.now());
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 12);
            content.newLineAtOffset(50, 750);
            content.showText("Client: " + client.getName());
            content.endText();

            int yPosition = 680;

            for (Product product : sale.getProductsSold()){
                content.beginText();
                content.newLineAtOffset(50, yPosition);
                content.showText("Product: " + product.getName() + " - Price: $" + product.getPrice());
                content.endText();
                yPosition -= 20;
            }
            content.beginText();
            content.newLineAtOffset(50, yPosition - 20);
            content.showText(String.format("Total: %s", sale.calculateTotalSale()));
            content.endText();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path outputPath = Paths.get("invoices", "invoice-" + sale.getId() + ".pdf");
        Files.createDirectories(outputPath.getParent());
        document.save(outputPath.toFile());
        document.close();
    }
}
