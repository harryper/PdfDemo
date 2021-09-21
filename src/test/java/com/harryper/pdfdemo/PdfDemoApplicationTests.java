package com.harryper.pdfdemo;

import com.harryper.pdfdemo.service.PDFDemoService;
import com.lowagie.text.DocumentException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PdfDemoApplicationTests {

    @Autowired
    private PDFDemoService pdfDemoService;

    @Test
    void contextLoads() {
        try {
            pdfDemoService.printPDF();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
