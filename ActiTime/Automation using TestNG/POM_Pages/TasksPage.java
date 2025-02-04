package Programs.jan_20.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.GenericUtility;

public class TasksPage extends GenericUtility {
    private WebDriver driver;

    // 1.WebElement

    @FindBy(xpath = "//div[contains(text(),'Tasks')]")
    private WebElement clickOnTasks;

    @FindBy(css = "input[value=\"Create New Tasks\"]")
    private WebElement clickOnNewTask;

    @FindBy(name = "customerId")
    private WebElement custDropdown;

    @FindBy(name = "projectId")
    private WebElement projectDropdown;

    @FindBy(name = "task[0].name")
    private WebElement taskNameTextField;

    @FindBy(css = "input[value='Create Tasks']")
    private WebElement createTaskSubmitbtn;






    // 2. Constructor
    public TasksPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    // 3.Page Action Methods

    public boolean isClickOnTaskdisplayed(){
        return iselementpresent(clickOnTasks);
    }

    public void clickOnTask(){
        clickByJS(driver,clickOnTasks);
    }

    public void clickOnNewTask(){
        clickByJS(driver,clickOnNewTask);
    }

    public boolean isCustDropdowndisplayed(){
        return iselementpresent(custDropdown);
    }
    public void selectCustDropdown(){
        Select sel = new Select(custDropdown);
        sel.selectByVisibleText("HDFC");
    }


    public boolean isProjectDropdowndisplayed(){
        return iselementpresent(projectDropdown);
    }
    public void selectProjectDropdown(){
        Select sel = new Select(projectDropdown);
        sel.selectByVisibleText("HDFC_Project");
    }

    public boolean isTaskNameTextFielddisplayed(){
        return iselementpresent(taskNameTextField);
    }
    public void enterTask(String taskName){
        taskNameTextField.sendKeys(taskName);
    }

    public boolean isCreateTasksubmitbtndisplayed(){
        return iselementpresent(createTaskSubmitbtn);
    }

    public void clickOnCreateTaskBtn(){
        createTaskSubmitbtn.click();
    }






}
