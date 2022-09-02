package com.pubaoyou.itext.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Date;

@Slf4j
public class ITestUtils {

    /**
     * @author Reverse_XML
     * 将多个PDF合并成一个PDF
     * @param files 源PDF路径
     * @param outputPath 合并后输出的PDF路径
     * @param outputFileName 合并后输出的PDF文件名
     */
    public static void mergePDF(String[] files, String outputPath, String outputFileName) {
        String sep = java.io.File.separator;
        Document document = null;
        PdfCopy copy = null;
        PdfReader reader = null;
        try {
            document = new Document(new PdfReader(files[0]).getPageSize(1));
            copy = new PdfCopy(document, new FileOutputStream(outputPath + sep +outputFileName));
            document.open();
            for (int i = 0; i < files.length; i++) {
                reader = new PdfReader(files[i]);
                int numberOfPages = reader.getNumberOfPages();
                for (int j = 1; j <= numberOfPages; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (DocumentException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (document != null)
                document.close();
            if (reader != null)
                reader.close();
            if (copy != null)
                copy.close();
        }
    }

    public static void main(String[] args) {
        String[] files = {"F:\\itssc\\one.pdf", "F:\\itssc\\two.pdf"};
        String outputPath= "F:\\itssc";
        String outputFileName ="merge.pdf";

        try {
            log.info("当前开始时间为{}",new Date());
            ITestUtils iTestUtils =  new ITestUtils();
            iTestUtils.mergePDF(files,outputPath,outputFileName);
            log.info("当前结束时间为{}",new Date());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
