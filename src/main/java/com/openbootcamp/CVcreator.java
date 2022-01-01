package com.openbootcamp;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CVcreator {
    public static void main(String[] args) throws DocumentException, IOException, URISyntaxException {
        createNewPdf();
    }

    public static void createNewPdf() throws DocumentException, IOException, URISyntaxException {
        String imageName = "gato-pc.jpeg";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("FutureCVFile.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Paragraph p1 = new Paragraph("Name: Mew", font);
        Paragraph p2 = new Paragraph("Email: mewcoder@gmail.com", font);

        document.add(p1);
        document.add(p2);
        addImage(document,imageName);
        document.close();
    }

    public static void addImage(Document document, String imageName ) throws URISyntaxException, DocumentException, IOException {
        Path path = Paths.get(ClassLoader.getSystemResource(imageName).toURI());
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        document.add(img);
    }
}


