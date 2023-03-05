package com.wendy.http.java_net;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wendy.http.common.entity.TranslationResult;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/22 22:06
 * @Version 1.0
 */
public class HttpURLConnectionDemo {
    public String translateText(String text, String fromLanguage, String toLanguage) {
        HttpURLConnection conn;
        OutputStream out;
        BufferedReader reader;
        TranslationResult translationResult = null;
        try {
            // 封装restful接口为URL对象
            String url = "http://api.fanyi.baidu.com/api/trans/vip/translate?" +
                    "q=" + text +
                    "&from=" + fromLanguage +
                    "&to=" + toLanguage +
                    "&appid=2015063000000001&salt=1435660288&sign=f89f9594663708c1605f3d736d01d2d4";

            URL restUrl = new URL(url);
            conn = (HttpURLConnection) restUrl.openConnection();

            // 设置http请求头属性
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

            // 请求接口
            conn.connect();
            out = conn.getOutputStream();
            out.flush();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error responseCode:" + responseCode);
            }

            // 读取请求响应
            StringBuffer content = new StringBuffer();
            String output;
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            while ((output = reader.readLine()) != null) {
                content.append(output);
            }

            // 将响应体转为java对象
            ObjectMapper objectMapper = new ObjectMapper();
            translationResult = objectMapper.readValue(content.toString(), TranslationResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return translationResult == null ? "" : translationResult.getTransResult().get(0).getDst();
    }
}
