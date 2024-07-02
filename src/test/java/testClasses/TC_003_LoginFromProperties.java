package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPageObjectsProperty;
import pageObjects.LoginSuccessScreen;

public class TC_003_LoginFromProperties extends BaseClass
{
	@Test
	public void TC_003_LoginProperties()
	{
		LoginPageObjectsProperty lp=new LoginPageObjectsProperty(driver,property);

        lp.setUsername();
        lp.setPassword();
        lp.clickSubmitBtn();

        LoginSuccessScreen ls=new LoginSuccessScreen(driver);
        if(ls.LoginSuccessMessageCheck().equals(("Logged In Successfully")))
        {
            System.out.println("Test Case Passed. Login Successful");
        }
        else
        {
            Assert.fail("Test Case Failed");
        }
		
	}

}
