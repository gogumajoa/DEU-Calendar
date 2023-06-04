package deu_calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Crawling_C {
	public static void main(String[] args) {
		try {
			// 크롤링 할 Door 사이트 주소
			String url = "http://door.deu.ac.kr/Home/Index";
			
			// 웹 사이트의 HTML 가져오기
			Document doc = Jsoup.connect(url).get();
			
			// 특정 클래스 요소 선택
			Elements elements = doc.select(".info_l");
			
			for(Element element : elements) {
				System.out.println(element.text());
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
