


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test2 {

private String testName = "Test 1-2(dreamkas.ru tests, test case 2";	
private String testDescriprion1 = "Testing if social networks links are working properly ";
private String testDescription2 = "Проверить работы ссылок на страницы в социальных сетях";
boolean testResult;
	
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  
  

  @Before
  public void setUp() throws Exception {
   driver = new FirefoxDriver();
	  
    baseUrl = "https://dreamkas.ru";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test2() throws Exception {
	  
	  ArrayList <String> social = new ArrayList <String> ();
	 social.add("path");
	 social.add("a.dk-footer__social-link.dk-footer__social-link--fb > svg.dk-footer__social-icon");
	 social.add("a.dk-footer__social-link.dk-footer__social-link--twitter > svg.dk-footer__social-icon");
	 social.add("a.dk-footer__social-link.dk-footer__social-link--ok > svg.dk-footer__social-icon");
	 social.add("a.dk-footer__social-link.dk-footer__social-link--youtube > svg.dk-footer__social-icon");
	 social.add("a.dk-footer__social-link.dk-footer__social-link--instagram > svg.dk-footer__social-icon");
	 
	 
	 ArrayList <String> url =new ArrayList <String> ();
	 
	url.add("https://vk.com/dreamkas");
	url.add("https://www.facebook.com/DreamkasRussia");
	url.add("https://twitter.com/DreamkasRU");
	url.add("https://ok.ru/group/55130660601878"); 
	url.add("https://www.youtube.com/user/DreamkasRU");
	url.add("https://www.instagram.com/dreamkas.ru/");
		 
	 String adress;
		  
    driver.get(baseUrl + "/");
    driver.manage().window().maximize();
    Thread.sleep(1000);
          
    for (int i = 0; i <6; i++){ 	
    
    	String winHandleBefore = driver.getWindowHandle();
    	driver.findElement(By.cssSelector(social.get(i))).click();
    Thread.sleep(700);
    
    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);}
    Thread.sleep(700);
    
     adress = driver.getCurrentUrl();
        
    assertEquals(url.get(i), adress); 
    
    driver.close();
     driver.switchTo().window(winHandleBefore);
    Thread.sleep(1000);}
    
   
  }
  
 

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
