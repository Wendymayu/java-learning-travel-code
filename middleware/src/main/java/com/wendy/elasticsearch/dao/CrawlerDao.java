package com.wendy.elasticsearch.dao;

import com.wendy.elasticsearch.entity.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/5 21:41
 * @Version 1.0
 */
@Service
public class CrawlerDao {
    public List<Content> parseJD(String keywords) throws Exception {
        String url = "https://search.jd.com/Search?keyword=" + keywords;
        // 爬取得到 html 数据
        Document document = Jsoup.parse(new URL(url), 30000);
        // 从html 中得到物品列表，Element对象可以封装 html 元素
        Element element = document.getElementById("J_goodsList");
        // 用 Elements 封装 ui 列表中的所有元素
        Elements elements = element.getElementsByTag("li");
        // 将所有 html 元素解析为java对象
        ArrayList<Content> goodsList = new ArrayList<>();

        // 获取京东的商品信息
        for (Element el : elements) {
            String img = el.getElementsByTag("img").eq(0).attr("src");
            //String img = el.getElementsByTag("img").eq(0).attr("source-data- lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();

            // 封装获取的数据
            Content content = new Content();
            content.setImg(img);
            content.setPrice(price);
            content.setTitle(title);
            goodsList.add(content);
        }
        return goodsList;
    }
}
