package Programs.jan_20.POM_TestCases;

import Programs.jan_19.POM_Pages.LoginPage;
import Programs.jan_20.POM_Pages.CustomerPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.GenericUtility;


import java.util.Properties;

public class CustomerPageTC  {
    WebDriver driver;
    Properties prop;

    @BeforeMethod
    public void initBrowser() {
        ConfigReader cr = new ConfigReader();
        prop = cr.getPropObj();
        GenericUtility gu = new GenericUtility();
        driver = gu.startUp(prop.getProperty("bName"), prop.getProperty("URL"));
        LoginPage lpObj = new LoginPage(driver);
        lpObj.enterUsername(prop.getProperty("uName"));
        lpObj.enterPassword(prop.getProperty("pwd"));
        lpObj.clickOnLoginBtn();
       // Assert.assertTrue((new DashboardPage(driver)).isSelectedTimeTrackTabDisplayed(), "Time-Track tab is not displayed.");
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @BeforeTest
    public void readCustomerTestNG(){
        System.out.println("Read Customer_TestNG...");
    }

    @AfterTest
    public void closeCustomerTestNG(){
        System.out.println("Close Customer_TestNG...");
    }

    @Test(priority = 1)
    public void clickOnTask(){
        System.out.println("ClickOnTask Starts");
        CustomerPage custObj = new CustomerPage(driver);
        custObj.isClickOnTaskdisplayed();
        custObj.clickOnTasks();
        System.out.println("ClickOnTask Ends");

    }

    /*@Test(priority = 2)
    public void verifyTaskTab(){
        System.out.println("Verify Task Dashboard Starts");
        CustomerPage custObj = new CustomerPage(driver);
        String expectedTitle = "actiTIME - Open Tasks";
        String actualTitle = custObj.getTaskDashboard();
        Assert.assertEquals(actualTitle,expectedTitle,"Task tab is not displayed ");
        System.out.println("Verify Task Dashboard Ends ");
    }
*/

    @Test(priority = 3)
    public void clickOnProjectsandCustomer()  {
        System.out.println("clickOnProjectsandCustomer Starts");
        CustomerPage custObj = new CustomerPage(driver);
        custObj.clickOnTasks();
        custObj.clickOnProjectsandCustomer();
        System.out.println("clickOnProjectsandCustomer Ends");

    }

    @Test(priority = 4)
    public void clickOnCreateCustomer(){
        System.out.println("clickOnCreateCustomer Starts");
        CustomerPage custObj = new CustomerPage(driver);
        custObj.clickOnTasks();
        custObj.clickOnProjectsandCustomer();
        custObj.clickOnCreateCustomer();
        custObj.iscustomerNameTextFielddisplayed();
        custObj.enterCustomerName(prop.getProperty("custName"));
        custObj.isSubmitBtndisplayed();
        custObj.clickOnSubmitBtn();
        System.out.println("clickOnCreateCustomer Ends");

    }

        // Login   ......
    //Click on tasks .....
    // verify dashbaord ....
    // click on projects and customer ....
    // click on create new customer ....
    // Enter details
    // Submit the details
}
