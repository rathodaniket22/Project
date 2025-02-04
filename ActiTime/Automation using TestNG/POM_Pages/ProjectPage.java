package Programs.jan_20.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.GenericUtility;

public class ProjectPage extends GenericUtility {
    private WebDriver driver;
    // 1.WebElement

    @FindBy(xpath = "//div[contains(text(),'Tasks')]")
    private WebElement clickOnTasks;

    @FindBy(xpath = "//a[@class='content tt_selected selected']/div")
    private WebElement selectedTaskTab;

    @FindBy(xpath = "//a[contains(text(),'Projects &')]")
    private WebElement clickOnProjectsandCustomer;

    @FindBy(css = "input[value='Create New Project']")
    private WebElement createNewProject;

    @FindBy(name = "customerId")
    private WebElement custDropdown;

    @FindBy(name = "name")
    private WebElement projectNameTextField;

    @FindBy(name = "createProjectSubmit")
    private WebElement createProjectSubmitbtn;




    // 2. Constructor
    public ProjectPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    // 3. Page Actions Methods


    public boolean isClickOnTaskdisplayed(){
        return iselementpresent(clickOnTasks);
    }

    public void clickOnTasks(){
        clickOnTasks.click();
    }

    public boolean isSelectedTaskTabDisplayed(){
        return iselementpresent(selectedTaskTab);
    }

    public boolean iscreateNewCustomerdisplayed(){
        return iselementpresent(clickOnProjectsandCustomer);
    }

    public void clickOnProjectsandCustomer(){
        clickByJS(driver,clickOnProjectsandCustomer);
    }

    public void clickOnCreateProject(){
        clickByJS(driver,createNewProject);
    }

    public void selectCustDropdown(){
        Select sel = new Select(custDropdown);
        sel.selectByVisibleText("HDFC");
    }

    public boolean isprojectNameTextFielddisplayed(){
        return iselementpresent(projectNameTextField);
    }

    public void enterProjectName(String projectName){
        projectNameTextField.sendKeys(projectName);
    }

    public boolean isCreateProjectsubmitbtndisplayed(){
        return iselementpresent(createProjectSubmitbtn);
    }

    public void clickOnCreateProjectBtn(){
        createProjectSubmitbtn.click();
    }







}
