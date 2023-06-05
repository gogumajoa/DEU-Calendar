package deu_calendar;
  
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Crawling_C {
	public static void main(String[] args) throws Exception {
		// WebDriver ��� ����(�� ���ϰ�� �����ʼ�)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\atrix\\Desktop\\Git\\DEU-Calendar\\chromedriver_win32\\chromedriver.exe");


        // ũ�� ȭ�� �� �۾����� Ȯ���� ���� �޼ҵ�(������ �������, ���� �����Ͽ� ũ��â �ȶ�� �� ����)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        
        // WebDriver �ν��Ͻ� ����
        WebDriver driver = new ChromeDriver();

        try {
            // �α��� ������ URL
            String loginUrl = "https://door.deu.ac.kr/sso/login.aspx";

            // WebDriver�� ���� �α��� �������� �̵�
            driver.get(loginUrl);

            try {Thread.sleep(1000);} catch (InterruptedException e) {}		//  1�� ���
            
            // �α��ο� �ʿ��� ��Ҹ� ã�Ƽ� ���� �Է�
            WebElement usernameInput = driver.findElement(By.id("logId"));
            WebElement passwordInput = driver.findElement(By.id("logPw"));

            usernameInput.sendKeys("������̵�");
            passwordInput.sendKeys("�����и�ȣ");
            try {Thread.sleep(1000);} catch (InterruptedException e) {}		// 1�� ���
            
            // �α��� ��ư Ŭ��
            WebElement loginButton = driver.findElement(By.cssSelector("body > form > div:nth-child(5) > div:nth-child(5) > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > a"));
            loginButton.click();

            try {Thread.sleep(1000);} catch (InterruptedException e) {}		// 1�� ���
            
            // �α��� ���� ������ URL
            String loggedInUrl = "http://door.deu.ac.kr/MyPage";

            // �α��� ���� �������� �̵�
            driver.get(loggedInUrl);
            try {Thread.sleep(1000);} catch (InterruptedException e) {} 	// 1�� ���

            // �α��� �� �������� HTML �Ľ� �Ǵ� �ʿ��� �۾� ����(���� �ʿ�)
            List<WebElement> titles = driver.findElements(By.className("tAlignL pad_10 font_wei_n"));
            for(WebElement el:titles) {
            	System.out.println(el.getText());
            }
     
        } finally {
            // WebDriver ����
//            driver.quit();
        }
	}


	// �Ʒ� �ڵ� Jsoup ����� �� �� ������ ���� ����Ҷ� ���
//    private static void disableSSLVerification() throws Exception {
//        // �ŷ��� �� �ִ� ��� ������ ���
//        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
//            public X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//
//            public void checkClientTrusted(X509Certificate[] certs, String authType) {
//            }
//
//            public void checkServerTrusted(X509Certificate[] certs, String authType) {
//            }
//        }};
//
//        // SSL ���ؽ�Ʈ ����
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//
//        // ������ SSL ���� ���丮�� Ŀ���� SSL ���ؽ�Ʈ�� ��ü
//        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
//
//        // ȣ��Ʈ �̸� ���� ��Ȱ��ȭ
//        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
//    }
    
}
