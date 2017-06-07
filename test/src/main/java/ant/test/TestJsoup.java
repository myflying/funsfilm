package ant.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by admin on 2017/6/7.
 */

public class TestJsoup {
    public static void main(String[] args) throws IOException {
        // Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = "http://www.ttmeiju.com/";

        System.out.println(url);
        Document doc = Jsoup.connect(url).get();

        Elements dayElements = doc.select("ul.whlist").select("li");
        Elements links = dayElements.select(".listname").select("a[href]"); //"a[href]" //带有href属性的a元素
        Elements imgs = dayElements.select(".listdetail").select("[src]");

        System.out.println("链接数--->" + links.size());

        for (Element link : links) {
            System.out.println(link.attr("abs:href"));
        }

        System.out.println("图片数--->" + links.size());

        for (Element img : imgs) {
            System.out.println(img.attr("abs:src"));
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width - 1) + ".";
        else
            return s;
    }
}
