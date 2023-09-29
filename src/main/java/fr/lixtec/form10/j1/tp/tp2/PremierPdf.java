package fr.lixtec.form10.j1.tp.tp2;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PremierPdf {

  public static void main(String [] args) throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("premier-pdf.pdf"));
    document.open();
    document.addTitle("Mon premier PDF");
    document.add(new Paragraph("Hello the world en PDF grâce à iText"));
    document.close();
  }
}