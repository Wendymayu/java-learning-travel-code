package com.wendy.filetransform.upload.service.impl;

import com.wendy.filetransform.upload.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.Iterator;
import java.util.UUID;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/6 12:47
 * @Version 1.0
 */
@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger log = LoggerFactory.getLogger(UploadServiceImpl.class);

    private static final String ROOT_PATH = "D:\\file_server\\blog\\photo\\";

    @Override
    public String uploadSingleFile(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String filePath = ROOT_PATH + UUID.randomUUID().toString() + File.separator;
        File file = new File(filePath+fileName);
        createFile(file);
        InputStream inputStream = multipartFile.getInputStream();
        byte[] buffer = new byte[1024];
        FileOutputStream outputStream = new FileOutputStream(file);
        while(inputStream.read(buffer)!=-1){
            outputStream.write(buffer);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
        return "上传成功";
    }

    @Override
    public String uploadMultiFile(MultipartHttpServletRequest multipartHttpServletRequest) {
        File photoPath;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
        while (iterator.hasNext()) {
            MultipartFile file = multipartHttpServletRequest.getFile(iterator.next());
            String fileName = null;
            if (file != null) {
                fileName = file.getOriginalFilename();
            }
            String filePath = ROOT_PATH + UUID.randomUUID().toString() + File.separator;
            photoPath = new File(filePath + fileName);
            createFile(photoPath);
            try (OutputStream os = new FileOutputStream(photoPath);
                 //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
                 InputStream is = file.getInputStream()) {
                byte[] bts = new byte[1024];
                //读取字节数据写入输出流
                while (is.read(bts) != -1) {
                    os.write(bts);
                }
            } catch (IOException e) {
                log.error("upload file failed");
                return "上传失败";
            }
        }
        return "上传成功";
    }

    private void createFile(File photoPath) {
        File parentFile = photoPath.getParentFile();
        // 先创建目录
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        // 再创建文件
        if (!photoPath.exists()) {
            try {
                photoPath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkFileSize(MultipartFile multipartFile){
        if(multipartFile.getSize()>1024){
            return false;
        }
        return true;
    }
    public boolean isFileExist(MultipartFile multipartFile){
        if(multipartFile.isEmpty()){
            return false;
        }
        return true;
    }
}
