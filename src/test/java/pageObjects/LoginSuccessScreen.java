package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessScreen
{
	 WebDriver driver;

	    public LoginSuccessScreen(WebDriver driver)
	    {
	        this.driver=driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//h1[normalize-space()='Logged In Successfully']") WebElement LoginSuccessMessage;
	    @FindBy(xpath = "//a[normalize-space()='Log out']") WebElement LogoutBtn;

	    public String LoginSuccessMessageCheck()
	    {
	        String message=LoginSuccessMessage.getText();
	        System.out.println(message);
	        return message;
	    }

	    public void clickLogout()
	    {
	        LogoutBtn.click();
	    }

}
