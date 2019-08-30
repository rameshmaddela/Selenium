package seleniumgluecode;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class test {
	public WebDriver driver;
	@Given("^user is  on homepage$")
    public void user_is_on_homepage() throws Throwable {     
//    	System.setProperty("webdriver.gecko.driver","/Users/Documents/geckodriver");
//      driver = new FirefoxDriver();
    	System.setProperty("webdriver.chrome.driver","C:\\Selenium_Standard\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        //driver.findElement(By.linkText("Sign in")).click();
    	driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
    }
    
    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
    	driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();   
    }
    
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    	String exp_message = "Welcome to your account.";//Here you can manage all   of your personal information and orders.
    	String actual = driver.findElement(By.cssSelector(".info-account")).getText();
        //Assert.assertEquals(exp_message, actual);
    	Assert.assertTrue(actual.contains(exp_message));
    	System.out.println("success message is displayed");
    	driver.manage().window().maximize();
       // driver.quit();  
    }      


}
