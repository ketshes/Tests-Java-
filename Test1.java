
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test1 {
	
//boolean testResult;
	
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  
  class Test1Parameters {
  
	  private String testName = "Test 1-1 (dreamkas.ru tests, test case 1)";	
	  private String testDescriprion1 = "Tests if changing the city causes phone number change ";
	  private String testDescription2 = "Проверить, изменяется ли номер телефона при изменении города";
	  
	  private String getTestName(){
		  return testName;
	  }
	  
	  
  }
 
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://dreamkas.ru";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
	  int i;
	  int g;
    driver.get(baseUrl + "/");
    driver.manage().window().maximize();
    Thread.sleep(1000);	
    
     
   driver.findElement(By.cssSelector("span.md-select-icon")).click();
   Thread.sleep(400);
   
   driver.findElement(By.id("select_option_3")).click();
   Thread.sleep(400);
   
   WebElement  element = driver.findElement(By.cssSelector("span.dk-header__phone-number.ng-binding"));
  String text1;
  String text2;
  boolean a;
      
    for (i = 1; i<23; i ++){
    g =i +3;
    
    text1 = element.getText();
    driver.findElement(By.cssSelector("span.md-select-icon")).click();
    Thread.sleep(400);
    driver.findElement(By.id("select_option_"+g)).click();
    Thread.sleep(400);
      
    text2 = element.getText();
    
   
    a = text1.equals(text2);
    
    assertFalse(a);
    		
   // assertNotSame(text2,text1);
    		
   
    }
    
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
