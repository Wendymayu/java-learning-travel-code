package com.wendy.http.rest_template;

import com.wendy.http.common.entity.TranslationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/1/4 22:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/text")
public class RestTemplateDemo {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/translation")
    public String translateText(String text, String fromLanguage, String toLanguage) {
        HashMap<String, String> map = new HashMap<>();
        map.put("q", text);
        map.put("from", fromLanguage);
        map.put("to", toLanguage);
        map.put("appid", "2015063000000001");
        map.put("salt", "1435660288");
        map.put("sign", "f89f9594663708c1605f3d736d01d2d4");

        ResponseEntity<TranslationResult> responseEntity = restTemplate.getForEntity(
                "http://api.fanyi.baidu.com/api/trans/vip/translate",
                TranslationResult.class,
                map);

        return responseEntity.getBody().getTransResult().get(0).getDst();
    }
}
