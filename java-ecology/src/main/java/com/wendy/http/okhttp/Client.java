package com.wendy.http.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/19 10:49
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?name=马")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            return ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ;

    }
}
