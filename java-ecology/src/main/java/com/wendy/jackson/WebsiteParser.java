package com.wendy.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/1 23:26
 * @Version 1.0
 */
public class WebsiteParser {
    public static final String MENU_CONFIG_FILE = "json/website.json";

    private List<Website> websiteList;

    public List<Website> getWebsiteList() {
        parseJsonFile();
        return websiteList;
    }

/*    @PostConstruct
    private void init() {
        parseJsonFile();
    }*/

    public void parseJsonFile() {
        ClassPathResource resource = new ClassPathResource(MENU_CONFIG_FILE);
        try (InputStream inputStream = resource.getInputStream();) {
            websiteList = readWebsiteList(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Website> readWebsiteList(InputStream inputStream) throws IOException {
        List<Website> result = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(inputStream);
        JsonNode websites = jsonNode.get("menus");
        if (websites.isArray()) {
            for (JsonNode node : websites) {
                Website website = new Website();
                parseWebsite(node, website);
                result.add(website);
            }
        }
        return result;
    }

    private void parseWebsite(JsonNode node, Website website) {
        String id = node.get("id").asText();
        String zhName = node.get("zh_name").asText();
        String enName = node.get("en_name").asText();
        boolean otherService = node.get("other_service").asBoolean();
        String url = node.get("url").asText();
        website.setId(id);
        website.setZhName(zhName);
        website.setEnName(enName);
        website.setOtherService(otherService);
        website.setUrl(url);
    }
}
