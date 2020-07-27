package uk.co.newcastle.rh.graphmaven.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ITextPdfGenerator {

    public static void main(String[] args) throws Exception {
        /*Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello World", font);

        document.add(chunk);
        document.close();*/

        /*Path path = Paths.get(ClassLoader.getSystemResource("/Users/xuzhijie/Documents/dev_folder/idea_workspace/graph-maven/Java_logo.png").toURI());

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextImageExample.pdf"));
        document.open();
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        document.add(img);

        document.close();*/

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));

        document.open();

        PdfPTable table = new PdfPTable(3);
        /*addTableHeader(table);
        addRows(table);
        addCustomRows(table);*/

        document.add(table);
        document.close();
    }

    private Document document;
    /*private List<>

    private void generatePDF() throws Exception {
        try {
            PdfWriter.getInstance(document, new FileOutputStream("D:\\PDFName.pdf"));
            document.open();
            if (!jobs.isEmpty()) {
                addParagraph("PDF generated for " + jobs.get(0).getJobType().getStore().getName(), Element.ALIGN_CENTER);
                addParagraph("All count jobs " + jobs.size(), Element.ALIGN_LEFT);
                addParagraph("Available jobs " + jobs.size(), Element.ALIGN_LEFT);
                addParagraph("Salary: " + getSalary(), Element.ALIGN_RIGHT);
                addParagraph("Jobs", Element.ALIGN_CENTER);
                addParagraph(" ", Element.ALIGN_RIGHT);
                document.add(new Paragraph());
                addTable();
            } else {
                addParagraph("No results", Element.ALIGN_CENTER);
            }

        }
    }

    private void addTable() {
        try {
            Paragraph paragraph = new Paragraph();
            PdfPTable table = new PdfPTable(6);

            addTableHeader(table, "Id");
            addTableHeader(table, "Type of job");
            addTableHeader(table, "Localization");
            addTableHeader(table, "Date");
            addTableHeader(table, "Time");
            addTableHeader(table, "Pay");

            for (Job job : jobs) {
                addRow(table, job.getId().toString());
                addRow(table, job.getJobType().getType());
                addRow(table, job.getJobType().getStore().getCity());
                addRow(table, job.getDate().toString());
                addRow(table, job.getDateTimeFrom().toString() + " - " + job.getDateTimeTo().toString());
                addRow(table, job.getSalary().toString());
            }
            paragraph.add(table);
            document.add(paragraph);

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private void addRow(PdfPTable table, String text) {
        table.addCell(text);
    }

    private void addParagraph(String text, Integer align) {
        Font font = FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK);
        Chunk textChunk = new Chunk(text, font);
        Paragraph paragraph = new Paragraph(textChunk);
        paragraph.setAlignment(align);
        try {
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    private void addRows(PdfPTable table, List<String> texts) {
        texts.forEach(table::addCell);
    }

    private static void addTableHeader(PdfPTable table,String headerTitle){
        PdfPCell header = new PdfPCell();
        //header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(headerTitle));
        table.addCell(header);
    }*/
}
