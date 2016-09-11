package com.pengjinfei.ch4.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) {
        try {
            FileUtils.writeByteArrayToFile(new File("/Users/Pengjinfei/IdeaProjects/spring-boot-learning/ch4/target/"+file.getOriginalFilename()),file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
