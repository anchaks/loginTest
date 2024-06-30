package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPageObjects;
import pageObjects.LoginSuccessScreen;

public class TC_001_LoginHardCoded  extends BaseClass
{
	@Test
    public void TC_001_LoginHC()
    {
        LoginPageObjects lp=new LoginPageObjects(driver);

        lp.setUsername("student");
        lp.setPassword("Password123");
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
