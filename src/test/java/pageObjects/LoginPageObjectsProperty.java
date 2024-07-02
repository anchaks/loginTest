package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjectsProperty 
{
	WebDriver driver;
	Properties property;
    
    public LoginPageObjectsProperty(WebDriver driver, Properties property)
    {
        this.driver=driver;
        this.property=property;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='username']") WebElement Username;
    @FindBy(xpath="//input[@id='password']") WebElement Password;
    @FindBy(xpath="//button[@id='submit']") WebElement SubmitBtn;


    public void setUsername()
    {
        Username.sendKeys(property.getProperty("userID"));
    }

    public void setPassword()
    {
        Password.sendKeys(property.getProperty("password"));
    }

    public void clickSubmitBtn()
    {
        SubmitBtn.click();
    }

}
