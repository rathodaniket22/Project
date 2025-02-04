package Programs.jan_20.POM_TestCases;

import Programs.jan_19.POM_Pages.LoginPage;
import Programs.jan_20.POM_Pages.ProjectPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.GenericUtility;


import java.util.Properties;

public class ProjectPageTC {
    WebDriver driver;
    Properties prop;

    @BeforeMethod
    public void initBrowser() {
        ConfigReader cr = new ConfigReader();
        Properties prop = cr.getPropObj();
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
    public void readProjectTestNG(){
        System.out.println("Read Project_TestNG...");
    }

    @AfterTest
    public void closeProjectTestNG(){
        System.out.println("Close Project_TestNG...");
    }

    @Test(priority = 1)
    public void clickOnTask(){
        System.out.println("ClickOnTask Starts");
        ProjectPage projObj = new ProjectPage(driver);
        projObj.isClickOnTaskdisplayed();
        projObj.clickOnTasks();
        System.out.println("ClickOnTask Ends");

    }

    /*@Test(priority = 2)
    public void verifyTaskTab(){
        System.out.println("Verify Task Dashboard Starts");
        ProjectPage projObj = new ProjectPage(driver);
        String expectedTitle = "actiTIME - Open Tasks";
        String actualTitle = projObj.getTaskDashboard();
        Assert.assertEquals(actualTitle,expectedTitle,"Task tab is not displayed ");
        System.out.println("Verify Task Dashboard Ends ");
    }
*/

    @Test(priority = 2)
    public void clickOnProjectsandCustomer()  {
        System.out.println("clickOnProjectsandCustomer Starts");
        ProjectPage projObj = new ProjectPage(driver);
        projObj.clickOnTasks();
        projObj.clickOnProjectsandCustomer();
        System.out.println("clickOnProjectsandCustomer Ends");

    }

    @Test(priority = 3)
    public void clickOnCreateProject()  {
        System.out.println("clickOnCreateProject Starts");
        ProjectPage projObj = new ProjectPage(driver);
        projObj.clickOnTasks();
        projObj.clickOnProjectsandCustomer();
        projObj.clickOnCreateProject();
        projObj.selectCustDropdown();
        projObj.isprojectNameTextFielddisplayed();
        projObj.enterProjectName(prop.getProperty("projectName"));
        projObj.isCreateProjectsubmitbtndisplayed();
        projObj.clickOnCreateProjectBtn();
        System.out.println("clickOnCreateProject Ends");

    }

        // Login   ......
    //Click on tasks .....
    // verify dashbaord ....
    // click on projects and customer ....
    // click on create new customer ....
    // Enter details
    // Submit the details
}
