package com.mofany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


/**
 * @author MoFany-J
 * @date 2023/1/26
 * @description FileController 文件上传控制器
 */
@Controller
public class FileController {

    /**
     * 文件上传请求处理程序
     * */
    @PostMapping("fileupload")
    public String fileUploadRequestHandler(@RequestParam("files") CommonsMultipartFile file, Model model, HttpServletRequest request){
        /**
         * 1.所有请求皆先判断再处理
         * */
        if(!file.isEmpty()){
            model.addAttribute("content","文件已存在，上传成功!");
            /**
             * 2.文件上传的底层逻辑就是简单文件的复制，即关于文件输入输出流的读写。
             *   使用NIO同步非阻塞IO流进行文件的读写。
             * */
            try {

                /**
                 * 构造文件名：构建基于当前工程的相对上传路径
                 * */
                //目标文件名（原文件名+上传日期）
                String targetFileName=file.getOriginalFilename();
                //文件前缀
                String filePrefix=targetFileName.substring(0,targetFileName.lastIndexOf("."))+'-';
                //文件后缀
                String fileSuffix=targetFileName.substring(targetFileName.lastIndexOf("."));
                //格式化当前日期时间
                DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS");
                String currentDateTime=dateFormat.format(new Date())+':';
                currentDateTime=currentDateTime
                        .replaceFirst("-","年")
                        .replaceFirst("-","月")
                        .replaceFirst(" ","日");
                currentDateTime=currentDateTime
                        .replaceFirst(":","时")
                        .replaceFirst(":","分")
                        .replaceFirst(":","秒")
                        .replaceFirst(":","毫秒");
                //新文件名（前缀+日期+后缀）
                String newTargetFileName=filePrefix+currentDateTime+fileSuffix;
                System.out.println("新文件名："+newTargetFileName);
                //父目录（workFiles-类型）
                String parentDir="workFiles-"+file.getContentType().replaceAll("/","-");
                System.out.println("父目录："+parentDir);
                //子目录（文件名-上传日期-uuid）
                String subDir=filePrefix
                        +LocalDate.now().toString()
                        .replaceFirst("-","年")
                        .replaceFirst("-","月")
                        .replaceFirst("-","日")
                        +'-'
                        +UUID.randomUUID().toString().replace('-','$');
                System.out.println("子目录："+subDir);
                //构建相对路径
                String relativePath="WEB-INF/"+parentDir+'/'+subDir+'/'+newTargetFileName;
                //通过相对路径映射绝对路径（获取实际路径时始终获取到的）
                String realPath=request.getRealPath(relativePath);
                System.out.println("生成的路径："+realPath);
                //创建文件
                File targetFile=new File(realPath);
                //文件的父目录不存在时则创建目录
                if (!targetFile.getParentFile().exists()){
                    if (targetFile.getParentFile().mkdirs()){
                        System.out.println("父目录创建成功!");
                    }
                    //将上传文件保存到一个目标文件中
                    file.transferTo(targetFile);
                    System.out.println("文件上传成功!");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return "message/success";
        }else {
            model.addAttribute("content","文件不存在，上传失败!");
            return "message/failure";
        }
    }

    /**
     * 文件下载请求处理程序
     * */
    @PostMapping("filedown")
    public String fileDownRequestHandler(){
        return "";
    }
}
