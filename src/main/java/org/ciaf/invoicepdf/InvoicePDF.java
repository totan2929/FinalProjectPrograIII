package org.ciaf.invoicepdf;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;


public class InvoicePDF {

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
                    System.out.println("El archivo PDF está encriptado y no se puede leer.");
                }
            } catch (IOException e) {
                System.out.println("Se produjo un error al leer el archivo PDF.");
                e.printStackTrace();
            }
            return text.toString();
        }

        // Método para escribir texto en un archivo PDF
        public static void writeToPDF(String fileName, StringBuilder factura) {


            try {

                // Crear un PdfWriter para escribir el archivo

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

                System.out.println("PDF creado correctamente en: " + fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }




