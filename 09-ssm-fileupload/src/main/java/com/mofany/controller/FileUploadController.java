package com.mofany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MoFany-J
 * @date 2023/1/7
 * @description FileUploadController
 */
@Controller
@RequestMapping(value = "fileupload")
public class FileUploadController {
    @PostMapping(value = "{file}")
    public String requestFileUpload(@PathVariable(name = "file") CommonsMultipartFile file, HttpServletRequest request){
        return "success";
    }
}
