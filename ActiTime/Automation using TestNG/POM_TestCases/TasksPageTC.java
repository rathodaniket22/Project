package Programs.jan_20.POM_TestCases;

import Programs.jan_19.POM_Pages.LoginPage;
import Programs.jan_20.POM_Pages.TasksPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.GenericUtility;


import java.util.Properties;

public class TasksPageTC {
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
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @BeforeTest
    public void readTaskTestNG(){
        System.out.println("Read Task_TestNG...");
    }

    @AfterTest
    public void closeTaskTestNG(){
        System.out.println("Close Task_TestNG...");
    }

    @Test(priority = 1)
    public void clickOnTask(){
        System.out.println("ClickOnTask Starts");
        TasksPage taskObj = new TasksPage(driver);
        taskObj.isClickOnTaskdisplayed();
        taskObj.clickOnTask();
        System.out.println("ClickOnTask Ends");

    }


    @Test(priority = 2)
    public void createNewTasks(){
        System.out.println("create task started");
        TasksPage taskObj = new TasksPage(driver);
        taskObj.clickOnTask();
        taskObj.clickOnNewTask();
        taskObj.selectCustDropdown();
        taskObj.selectProjectDropdown();
        taskObj.enterTask(prop.getProperty("taskName"));
        taskObj.isCreateTasksubmitbtndisplayed();
        taskObj.clickOnCreateTaskBtn();
        System.out.println("create task end");
    }



    // Login
    //Click on tasks
    // verify dashbaord
    // click on projects and customer
    // click on create new customer
    // Enter details
    // Submit the details
    //Click on open tasks
    // create new task
    // select cutomer from dropdown
    // select project from dropdown
    // Enter task name
    // verify taskname field is displayed or not
    //  click on create task
}
