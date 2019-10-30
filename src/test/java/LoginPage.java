import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;
 class LoginPage {

	
	WebDriver dr;
	
	
	@BeforeMethod
	public void setUp(){
		
		String key = "webdriver.chrome.driver";
		String value= "./drivers/chromedriver.exe";
		System.setProperty(key, value);
		dr = new ChromeDriver();
		dr.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	
	}
	
	@DataProvider
	public Iterator<Object[]> getData(){
		ArrayList<Object[]> testData = TestUtil.getData();
		return testData.iterator();
		
	}
	
	
	@Test(dataProvider="getData")
	public void loginTest(String email, String pass){
		
		dr.findElement(By.xpath("//input[@id='Email']")).clear();
		dr.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		
		dr.findElement(By.xpath("//input[@id='Password']")).clear();
		dr.findElement(By.xpath("//input[@id='Password']")).sendKeys(pass);
	}
	
	
	@AfterMethod
	
	public void tearDown(){
		dr.quit();
	}
	
}
