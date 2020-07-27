package uk.co.newcastle.rh.graphmaven.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfException;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * pdf的工具类
 *
 * @author lichaopu1
 * @date 2019-03-26 14:00 2019-03-26 14:24
 */
public class PdfUtil {

    private static final Logger logger = LoggerFactory.getLogger(PdfUtil.class);

    /**
     * 导出到指定的文件目录中
     *
     * @param htmlContent html格式的文件内容
     * @param filePath    导出的目标路径
     * @throws PdfException
     */
    public static void exportToFile(String htmlContent, String filePath) throws PdfException {
        exportToFile(htmlContent, filePath, null);
    }

    /**
     * 导出PDF文件的字节数组
     *
     * @param htmlContent html格式的文件内容
     * @return
     */
    public static byte[] exportToByteArray(String htmlContent) {
        return exportToByteArray(htmlContent, null);
    }

    /**
     * 导出到指定的文件目录中
     *
     * @param htmlContent     html格式的文件内容
     * @param filePath        导出的目标路径
     * @param pageEventHelper
     * @throws PdfException
     */
    public static void exportToFile(String htmlContent, String filePath, PdfPageEventHelper pageEventHelper) throws PdfException {

        FileOutputStream outputStream = null;
        try {
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            // 设置输出路径
            outputStream = new FileOutputStream(filePath);

            // 设置文档大小
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            // 设置页眉页脚
            writer.setPageEvent(pageEventHelper);

            // 输出为PDF文件
            convertToPDF(writer, document, htmlContent);
        } catch (Exception e) {
            throw new PdfException(e);
        } finally {
            closeStream(outputStream);
        }
    }

    /**
     * 导出PDF文件的字节数组
     *
     * @param htmlContent     html格式的文件内容
     * @param pageEventHelper
     * @return
     */
    public static byte[] exportToByteArray(String htmlContent, PdfPageEventHelper pageEventHelper) {
        ByteArrayOutputStream outputStream = null;
        try {
            // 设置输出路径
            outputStream = new ByteArrayOutputStream();

            // 设置文档大小
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            // 设置页眉页脚
            writer.setPageEvent(pageEventHelper);

            // 输出为PDF文件
            convertToPDF(writer, document, htmlContent);
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeStream(outputStream);
        }
    }

    /**
     * @description PDF文件生成
     */
    private static void convertToPDF(PdfWriter writer, Document document, String htmlString) {
        /*try {
            // 获取字体路径
            String fontPath = getFontPath();
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(htmlString.getBytes(Charset.forName("UTF-8"))),
            //XMLWorkerHelper.class.getResourceAsStream("/default.css"), Charset.forName("UTF-8"), new PdfFont());
        } catch (IOException e) {
            throw new RuntimeException("Generating file exception", e);
        } finally {
            document.close();
        }*/
    }

    /**
     * @description 获取字体设置路径
     */
    public static String getFontPath() {
        String classpath = PdfUtil.class.getClassLoader().getResource("").getPath();
        return classpath + "ftl / fonts";
    }

    private static void closeStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                logger.error("close the ", e);
            }
        }
    }
}
