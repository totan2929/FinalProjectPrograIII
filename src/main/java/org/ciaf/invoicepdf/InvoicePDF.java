package org.ciaf.invoicepdf;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.ciaf.MainElectronicStore;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;


public class InvoicePDF {
        private static final Logger logger = Logger.getLogger(MainElectronicStore.class.getName());

        // Método para leer texto desde un archivo PDF
        public static String readFromPDF(String fileName) {
            // Se crea un objeto StringBuilder para concatenar el texto extraído del PDF.
            StringBuilder text = new StringBuilder();
            try (PDDocument document = PDDocument.load(new File(fileName))) {
                // Se carga el documento PDF desde el archivo especificado.
                // El documento se cerrará automáticamente al finalizar el bloque try.
                if (!document.isEncrypted()) {
                    // Se verifica si el documento PDF está encriptado.
                    // Si no lo está, se procede a extraer el texto del PDF.
                    PDFTextStripper stripper = new PDFTextStripper();
                    // Se crea un objeto PDFTextStripper para extraer texto del PDF.
                    text.append(stripper.getText(document));
                    // Se obtiene el texto del documento y se agrega al StringBuilder.
                } else {
                    logger.info("The PDF file is encrypted and cannot be read.");
                }
            } catch (IOException e) {
                logger.info("An error occurred while reading the PDF file.");
                e.printStackTrace();
            }
            return text.toString();
        }

        // Método para escribir texto en un archivo PDF
        public static void writeToPDF(String fileName, StringBuilder factura) {


            try {


                // Crear un PdfWriter para escribir el archivo
                PdfWriter writer = new PdfWriter(fileName);

                // Crear el PdfDocument y asociarlo con el PdfWriter
                PdfDocument pdfDoc = new PdfDocument(writer);

                // Crear el documento para agregar contenido
                Document document = new Document(pdfDoc);

                // Agregar el contenido de StringBuilder como un párrafo
                document.add(new Paragraph(factura.toString()));

                // Cerrar el documento


                document.close();

                logger.info("PDF successfully created in: " + fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }




