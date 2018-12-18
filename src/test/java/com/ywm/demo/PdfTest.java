package com.ywm.demo;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.StringReader;

/**
 * @Author: yuanweimin
 * @Date: 2018/12/17 17:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PdfTest {
    @Test
    public void createPdfTest() throws Exception {
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream("E:/jpeg/testpdf1.pdf"));
        document.open();
        HTMLWorker htmlWorker = new HTMLWorker(document);
        htmlWorker.parse(new StringReader("<h1>This is a test!</h1>"));
        document.close();
    }
}
