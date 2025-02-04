package Programs.jan_20.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericUtility;

public class CustomerPage extends GenericUtility {
    private WebDriver driver;
    // 1.WebElement

    @FindBy(xpath = "//div[contains(text(),'Tasks')]")
    private WebElement clickOnTasks;

    @FindBy(xpath = "//a[@class='content tt_selected selected']/div")
    private WebElement selectedTaskTab;

    @FindBy(xpath = "//a[contains(text(),'Projects &')]")
    private WebElement clickOnProjectsandCustomer;

    @FindBy(css = "input[value='Create New Customer']")
    private WebElement createNewCustomer;

    @FindBy(name = "name")
    private WebElement customerNameTextField;

    @FindBy(name = "createCustomerSubmit")
    private WebElement submitbtn;




    // 2. Constructor
    public CustomerPage(WebDriver driver){
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

    public void clickOnCreateCustomer(){
        clickByJS(driver,createNewCustomer);
    }

    public boolean iscustomerNameTextFielddisplayed(){
        return iselementpresent(customerNameTextField);
    }

    public void enterCustomerName(String custName){
        customerNameTextField.sendKeys(custName);
    }

    public boolean isSubmitBtndisplayed(){
        return iselementpresent(submitbtn);
    }

    public void clickOnSubmitBtn(){
        submitbtn.click();
    }
    public String getTaskDashboard(){
        return driver.getTitle();
    }







}
