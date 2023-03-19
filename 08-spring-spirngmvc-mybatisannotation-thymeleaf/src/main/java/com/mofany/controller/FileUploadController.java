package com.mofany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description FileUploadController 自定义文件上传控制器
 */
//@Controller
//@RequestMapping("file")
//public class FileUploadController {
//    @GetMapping("fileupload")
//    public ModelAndView fileUploadRequest(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request){
//        return new ModelAndView("success");
//    }
//}
