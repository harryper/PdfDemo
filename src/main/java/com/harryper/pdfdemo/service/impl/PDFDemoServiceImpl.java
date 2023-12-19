package com.harryper.pdfdemo.service.impl;

import com.harryper.pdfdemo.service.PDFDemoService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class PDFDemoServiceImpl implements PDFDemoService {
    @Override
    public void printPDF() throws DocumentException {

        // 创建 document 文档
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        // 创建数据流
        FileOutputStream buffer = null;
        try {
            buffer = new FileOutputStream("hello.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 创建 PDF 实例
        PdfWriter writer = PdfWriter.getInstance(document, buffer);

        // 定义字体
        FontFactoryImp ffi = new FontFactoryImp();
        // 注册全部默认字体目录，windows会自动找fonts文件夹的，返回值为注册到了多少字体
        ffi.registerDirectories();
        // 获取字体
        Font font = ffi.getFont("heiti tc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12, Font.UNDEFINED, null);

        String title = "这是标题！！！";
        document.open();

        // 增加一个段落
        Paragraph elements = new Paragraph(title, font);
        elements.setAlignment(Element.ALIGN_CENTER);

        document.add(elements);
        document.add(new Paragraph("\n\r", font));

        // 创建表格，5列的表格
        PdfPTable table = new PdfPTable(4);
        table.setTotalWidth(PageSize.A4.getWidth() - 100);
        table.setLockedWidth(true);

        // 创建头
        Paragraph hed = new Paragraph("报价基础信息", font);
        PdfPCell hCell = new PdfPCell(hed);
        hCell.setColspan(4);
        table.addCell(hCell);
        // 添加内容
        Paragraph paragraph = new Paragraph("报价单号", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("2222222222", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("价格", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("23232323", font);
        table.addCell(paragraph);

        paragraph = new Paragraph("供应商", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("搜索", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("报价人", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("LH", font);
        table.addCell(paragraph);

        paragraph = new Paragraph("报价有效日期", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("2021-08-25", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("报价日期", font);
        table.addCell(paragraph);
        paragraph = new Paragraph("2021-09-25", font);
        table.addCell(paragraph);


        paragraph = new Paragraph("质疑截止日期", font);
        PdfPCell cell = new PdfPCell(paragraph);
        cell.setColspan(1);
        table.addCell(cell);
        paragraph = new Paragraph("2021-09-25", font);
        cell = new PdfPCell(paragraph);
        cell.setColspan(3);
        table.addCell(cell);

        paragraph = new Paragraph("备注", font);
        cell = new PdfPCell(paragraph);
        cell.setColspan(1);
        table.addCell(cell);
        paragraph = new Paragraph("范德萨范德萨范德萨发收到", font);
        cell = new PdfPCell(paragraph);
        cell.setColspan(3);
        table.addCell(cell);


// 创建表格，5列的表格
        PdfPTable table2 = new PdfPTable(4);
        table2.setTotalWidth(PageSize.A4.getWidth() - 100);
        table2.setLockedWidth(true);
        table2.setSpacingBefore(50f);

// 创建头
        Paragraph hed2 = new Paragraph("报价详情", font);
        PdfPCell hCell2 = new PdfPCell(hed);
        hCell2.setColspan(4);
        table.addCell(hCell2);

        table2.addCell(new Paragraph("序号", font));
        table2.addCell(new Paragraph("采购明细", font));
        table2.addCell(new Paragraph("价格", font));
        table2.addCell(new Paragraph("需求单位--", font));

        document.add(table);
        document.add(table2);



//
//        // 打开文档
//        document.open();
//
//        // 添加内容
//        document.add(new Paragraph("hello world"));

        // 关闭文档
        document.close();
        writer.close();
    }
}
