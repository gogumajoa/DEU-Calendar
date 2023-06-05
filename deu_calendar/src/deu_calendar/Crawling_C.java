package deu_calendar;
  
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import java.security.cert.X509Certificate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class Crawling_C {
	public static void main(String[] args) throws Exception {
		// WebDriver 경로 설정(뒤 파일경로 수정필수)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\atrix\\Desktop\\Git\\DEU-Calendar\\chromedriver_win32\\chromedriver.exe");


        // 크롬 화면 띄어서 작업순서 확인을 위한 메소드(아직은 적용안함, 추후 적용하여 크롬창 안띄게 할 예정)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        
        // WebDriver 인스턴스 생성
        WebDriver driver = new ChromeDriver();

        try {
            // 로그인 페이지 URL
            String loginUrl = "https://door.deu.ac.kr/sso/login.aspx";

            // WebDriver를 통해 로그인 페이지로 이동
            driver.get(loginUrl);

            try {Thread.sleep(1000);} catch (InterruptedException e) {}		//  1초 대기
            
            // 로그인에 필요한 요소를 찾아서 값을 입력
            WebElement usernameInput = driver.findElement(By.id("logId"));
            WebElement passwordInput = driver.findElement(By.id("logPw"));

            usernameInput.sendKeys("20172088");
            passwordInput.sendKeys("donggon0104@");
            try {Thread.sleep(1000);} catch (InterruptedException e) {}		// 1초 대기
            
            // 로그인 버튼 클릭
            WebElement loginButton = driver.findElement(By.cssSelector("body > form > div:nth-child(5) > div:nth-child(5) > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > a"));
            loginButton.click();

            try {Thread.sleep(1000);} catch (InterruptedException e) {}		// 1초 대기
            
            // 로그인 후의 페이지 URL
            String loggedInUrl = "http://door.deu.ac.kr/MyPage";

            // 로그인 후의 페이지로 이동
            driver.get(loggedInUrl);
            try {Thread.sleep(1000);} catch (InterruptedException e) {} 	// 1초 대기

            // 로그인 후 페이지의 HTML 파싱 또는 필요한 작업 수행(수정 필요)
            String fixedCode = "CHGB001";	// 과목에 고정된 값(이걸 통해 개인과목 조회)
            List<WebElement> titles = driver.findElements(By.xpath("//a[contains(@href, 'javascript:goRoom') and contains(@href, '" + fixedCode + "')]"));
            for(int i=0; i<titles.size(); i++) {
            	WebElement el = titles.get(i);

            	JavascriptExecutor executor = (JavascriptExecutor) driver;	// 과목별 페이지 이동은 자바스크립트를 이용
            	executor.executeScript("arguments[0].click();", el);	// 과목별 페이지 이동은 자바스크립트를 이용
            	try {Thread.sleep(1000);} catch (InterruptedException e) {}		// 1초 대기
            	
            	driver.findElement(By.xpath("//*[@id=\"lnbContent\"]/div/div[3]/ul/li/ul/li[3]/a/span")).click();	// 과제페이지 이동
            	try {Thread.sleep(1000);} catch (InterruptedException e) {}		// 1초 대기
            	
            	WebElement subs = driver.findElement(By.className("tbl_type"));		// 과제페이지에서 과제란 요소저장
            	System.out.println(subs.getText());		// 저장된 과제란 전부 출력
            	
            	// 강의실 페이지로 다시 이동(2번 필수)
            	driver.navigate().back();	// 뒤로가기 메소드
            	try {Thread.sleep(1000);} catch (InterruptedException e) {}		// 1초 대기
            	driver.navigate().back();
        
            }
     
        } finally {
            // WebDriver 종료
            driver.quit();
        }
	}


	// 아래 코드 Jsoup 사용할 때 웹 인증서 강제 허용할때 사용
//    private static void disableSSLVerification() throws Exception {
//        // 신뢰할 수 있는 모든 인증서 허용
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
//        // SSL 컨텍스트 생성
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//
//        // 기존의 SSL 소켓 팩토리를 커스텀 SSL 컨텍스트로 교체
//        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
//
//        // 호스트 이름 검증 비활성화
//        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
//    }
    
}
