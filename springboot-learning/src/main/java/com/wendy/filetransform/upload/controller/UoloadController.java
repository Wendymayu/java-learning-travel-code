package com.wendy.filetransform.upload.controller;

import com.wendy.filetransform.upload.common.Result;
import com.wendy.filetransform.upload.service.UploadService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/6 12:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/uplaod")
public class UoloadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/singleFile")
    public Result uploadSingleFile(MultipartFile multipartFile){
        String photoPath = null;
        try {
            photoPath = uploadService.uploadSingleFile(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail(20001,"上传失败");
        }
        return Result.success(photoPath);
    }

    @PostMapping("/multiFile")
    public Result uploadMultiFile(HttpServletRequest request){
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        String photoPath = uploadService.uploadMultiFile(multipartHttpServletRequest);
        return Result.success(photoPath);
    }
}
