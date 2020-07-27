package uk.co.newcastle.rh.graphmaven.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.net.URISyntaxException;

public class PDFBoxGenerator {
    public static void main(String[] args) throws IOException, URISyntaxException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.showText("Hello World");
        contentStream.endText();
        contentStream.close();

        document.save("pdfBoxHelloWorld.pdf");
        document.close();

        /*PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDImageXObject image
                = PDImageXObject.createFromFile(path.toAbsolutePath().toString(), document);
        contentStream.drawImage(image, 0, 0);
        contentStream.close();

        document.save("pdfBoxImage.pdf");
        document.close();*/
    }
}
