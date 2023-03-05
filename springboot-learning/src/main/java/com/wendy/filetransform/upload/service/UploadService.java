package com.wendy.filetransform.upload.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/6 12:53
 * @Version 1.0
 */
public interface UploadService {
    /**
     * create by: wendyMa
     * description: 一次上传单个文件
     * create time: 2022/3/6 13:00
     * @return
     */

    String uploadSingleFile(MultipartFile multipartFile) throws IOException;
    /**
     * create by: wendyMa
     * description: 表单一次上传多个文件
     * create time: 2022/3/6 12:55
     * @return
     */
    String uploadMultiFile(MultipartHttpServletRequest multipartHttpServletRequest);
}