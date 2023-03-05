package com.wendy.filetransform.download;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/5 11:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/file")
public class DownloadController {
    private static final Logger log = LoggerFactory.getLogger(DownloadController.class);

    /**
     * create by: wendyMa
     * description: 从服务部署机器的本地下载文件
     * create time: 2022/3/6 9:12
     * @return
     */
    @GetMapping("/download")
    public Object downloadFile() {
        ResponseEntity<byte[]> responseEntity = null;
        try {
            ClassPathResource resource = new ClassPathResource("xml/website.xml");
            InputStream inputStream = resource.getInputStream();
            byte[] body = new byte[inputStream.available()]; // body不能为空，不然空指针异常
            inputStream.read(body);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename="+"customers.xlsx");
            headers.add("Content-Type","application/octet-stream");
            HttpStatus statusCode = HttpStatus.OK;
            responseEntity = new ResponseEntity<>(body, headers, statusCode);
            inputStream.close();
        } catch (FileNotFoundException e) {
            log.error("file uploading failed, may be file not exist");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    /**
     * create by: wendyMa
     * description: 从远程文件服务器下载文件
     * create time: 2022/3/6 9:12
     * @return
     */
    @GetMapping("/downloadnet")
    public void downloadNet(HttpServletResponse response) throws MalformedURLException {
        String tempFilePath = "D:/file_server/net/logo.png";
        String netFilePath = "https://static.mszlu.com/a7302c88-e106-46ad-9713-dc9a6d523957.png";
        //String netFilePath = "http://localhost:8080/static/img/customer.xlsx";
        URL url = new URL(netFilePath);
        try {
            // 先将网络文件保存到服务器本地
            InputStream inputStream = url.openConnection().getInputStream();
            FileOutputStream outputStream = new FileOutputStream(tempFilePath);
            byte[] buffer = new byte[1024];
            int length;
            while((length=inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,length);
                //outputStream.write(buffer); //这种方式文件内容会有残缺
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();

            // 将临时文件发送给客户
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition","attachment;filename=logo.png");
            FileInputStream inputStream1 = new FileInputStream(tempFilePath);
            byte[] content = new byte[1024];
            int len;
            ServletOutputStream outputStream1 = response.getOutputStream();
            while ((len = inputStream1.read(content)) > 0) {
                outputStream1.write(content);
            }
            inputStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
