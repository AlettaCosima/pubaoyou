package com.pubaoyou.itext.controller;

import com.pubaoyou.itext.utils.ITestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RestController
@RequestMapping("/pubaoyou/echi/itext/v1")
@Slf4j
public class ItextController {

    @RequestMapping(value = "/pdf_test",method = RequestMethod.GET)
    public String pdf_thread_test(){

        try {
            String[] files = {"F:\\itssc\\one.pdf", "F:\\itssc\\two.pdf"};
            String outputPath= "F:\\itssc";
            String outputFileName ="merge.pdf";
            ITestUtils.mergePDF(files,outputPath,outputFileName);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
