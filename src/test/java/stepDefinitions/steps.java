package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import java.io.PipedOutputStream;
import java.time.Duration;
import java.util.ResourceBundle;

public class steps {

    ResourceBundle rb;
    MyAccountPage macc;
    HomePage hp;
    LoginPage lp;
    String br;
    WebDriver driver;
    @Before
    public void setup(){
        rb = ResourceBundle.getBundle("config");
        br = rb.getString("browser");
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("Scenario status ==>>>" + scenario.getStatus() );
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        driver.quit();
    }
    @Given("User Launch Browser")
    public void user_launch_browser() {

        if(br.equals("chrome")){
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(option);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("Opens URL {string}")
    public void opens_url(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @When("User navigate to My Account menu")
    public void user_navigate_to_my_account_menu(){
        hp = new HomePage(driver);

        hp.clickMyAccount();
    }
    @When("click on Login")
    public void click_on_login() {
        hp.clickLogin();
    }
    @When("User enters email id {string} and password {string}")
    public void user_enters_email_id_and_password(String email, String password) {
        lp = new LoginPage(driver);

        lp.setEmail(email);
        lp.setPassword(password);
    }
    @When("Click on Login button")
    public void click_on_login_button() {
        lp.clickLogin();
    }
    @Then("User navigates to My Account page")
    public void user_navigates_to_my_account_page() {
        macc = new MyAccountPage(driver);

        boolean temp = macc.isMyAccountPageExists();
        Assert.assertTrue(temp);
    }

}
