package deu_calendar;
  
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import java.security.cert.X509Certificate;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Crawling_C {
	public static void main(String[] args) {

	}
	
	public static boolean DoorCrawling(String doorId, String doorPw) throws Exception{
		// WebDriver ��� ����(�� ���ϰ�� �����ʼ�)
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\atrix\\Desktop\\Git\\DEU-Calendar\\chromedriver_win32\\chromedriver.exe");

	    // ũ�� ȭ�� �� �۾����� Ȯ���� ���� �޼ҵ�(������ �������, ���� �����Ͽ� ũ��â �ȶ�� �� ����)
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("headless");
	    options.addArguments("--enable-automation", "--remote-debugging-port=9222");
	    options.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
	    
	    // WebDriver �ν��Ͻ� ����
	    WebDriver driver = new ChromeDriver(options);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		// �������⸦ ����(�����Ͽ��̶� ������̹��� ȣȯ������ �̷��Ը� ��밡��!!)

	    try {
	        // �α��� ������ URL
	        String loginUrl = "https://door.deu.ac.kr/sso/login.aspx";

	        // WebDriver�� ���� �α��� �������� �̵�
	        driver.get(loginUrl);
	        
	        // �α��ο� �ʿ��� ��Ҹ� ã�Ƽ� ���� �Է�
	        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logId")));
	        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logPw")));

	        usernameInput.sendKeys(doorId);
	        passwordInput.sendKeys(doorPw);
	        
	        // �α��� ��ư Ŭ��
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > form > div:nth-child(5) > div:nth-child(5) > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > a")));
	        loginButton.click();
	        
	        // �α��� ���� ������ URL
	        String loggedInUrl = "http://door.deu.ac.kr/MyPage";
	        // �α��� ���� �������� �̵�
	        driver.get(loggedInUrl);
	        wait.until(ExpectedConditions.urlToBe(loggedInUrl));
	        

	        // �α��� �� �������� HTML �Ľ� �Ǵ� �ʿ��� �۾� ����(���� �ʿ�)
	        String fixedCode = "CHGB001";	// ���� ������ ��(�̰� ���� ���ΰ��� ��ȸ)
	        List<WebElement> titles = driver.findElements(By.xpath("//a[contains(@href, 'javascript:goRoom') and contains(@href, '" + fixedCode + "')]"));
	        for(int i=0; i<titles.size(); i++) {
	        	WebElement title = titles.get(i);

	        	JavascriptExecutor executor = (JavascriptExecutor) driver;	// ���� ������ �̵��� �ڹٽ�ũ��Ʈ�� �̿�
	        	executor.executeScript("arguments[0].click();", title);	// ���� ������ �̵��� �ڹٽ�ũ��Ʈ�� �̿�
	        	
	        	
	        	System.out.println("�׽�Ʈ");
	        	WebElement subPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#lnbContent > div > div:nth-child(3) > ul > li > ul > li:nth-child(3) > a"))); // ���������� �̵�
	        	subPage.click();
	        	System.out.println("�׽�Ʈ2");
	        	
	        	WebElement subs = driver.findElement(By.className("tbl_type"));		// �������������� ������ �������
	        	System.out.println(subs.getText());		// ����� ������ ���� ���
	        	
	        	// ���ǽ� �������� �ٽ� �̵�(2�� �ʼ�)
	        	driver.navigate().back();	// �ڷΰ��� �޼ҵ�
	        	driver.navigate().back();
	        	
	        }
	 
	    } catch (Exception e) {
			// TODO: handle exception
	    	System.out.println("�α��� ����!");
	    	JOptionPane.showMessageDialog(null, "�α��� ����!","ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
	    	
	    	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = "C:\\Users\\atrix\\Desktop\\failure_screenshot.png";  // ���� �� ��ũ���� ���� ���
	        Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);

	    	return false;
		}finally {
	        // WebDriver ����
//	        driver.quit();
	    }
	    return true;
	}

}