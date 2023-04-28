package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement inputFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement inputLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement inputPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	public WebElement checkboxAgree;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cnfMsg;
	
	//Actions
	
	public void setFirstName(String fn) {
		inputFirstName.sendKeys(fn);
	}
	
	public void setLastName(String ln) {
		inputLastName.sendKeys(ln);
	}
	
	public void setEmail(String emailID) {
		inputEmail.sendKeys(emailID);
	}
	
	public void setPassword(String pwd) {
		inputPassword.sendKeys(pwd);
	}
	
	public void clickAgreeCheckbox() {
		checkboxAgree.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMessage() {
		try {
			return (cnfMsg.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	

}
