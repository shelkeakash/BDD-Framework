package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement inputPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	public void setEmail(String inputEmailID) {
		inputEmail.sendKeys(inputEmailID);
	}
	
	public void setPassword(String inputPasswordID) {
		inputPassword.sendKeys(inputPasswordID);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
}
