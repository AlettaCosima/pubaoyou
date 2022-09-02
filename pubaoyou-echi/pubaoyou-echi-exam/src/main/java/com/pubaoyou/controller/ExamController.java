package com.pubaoyou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/itssc/exam/v1")
public class ExamController {

    @RequestMapping(value = "/toExam",method = RequestMethod.POST)
    public ModelAndView toExam() throws Exception{
        return new ModelAndView("/index");
    }

    @RequestMapping(value = "/uploadExamResult",method = RequestMethod.POST)
    public ModelAndView uploadExamResult() throws Exception{

        return new ModelAndView("/success");
    }

}
