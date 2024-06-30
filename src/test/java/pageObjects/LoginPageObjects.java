package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects 
{
	WebDriver driver;
    
    public LoginPageObjects(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='username']") WebElement Username;
    @FindBy(xpath="//input[@id='password']") WebElement Password;
    @FindBy(xpath="//button[@id='submit']") WebElement SubmitBtn;


    public void setUsername(String unString)
    {
        Username.sendKeys(unString);
    }

    public void setPassword(String pwdString)
    {
        Password.sendKeys(pwdString);
    }

    public void clickSubmitBtn()
    {
        SubmitBtn.click();
    }

}
