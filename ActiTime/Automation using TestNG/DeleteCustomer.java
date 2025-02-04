package Programs.jan_20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.GenericUtility;


public class DeleteCustomer {
    public static void main(String[]args){
        String bName = "ch";
        String url = "http://127.0.0.1:82/login.do;jsessionid=m7f4arcvn9pb";
        GenericUtility gu = new GenericUtility();
        WebDriver driver = gu.startUp(bName,url);


        //Login
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.id("loginButton")).click();

        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        WebElement clickproject =driver.findElement(By.xpath("//a[contains(text(),'Projects &')]"));
        gu.clickByJS(driver,clickproject);
        WebElement clickHDFC =driver.findElement(By.xpath("//a[text()='HDFC']"));
        gu.clickByJS(driver,clickHDFC);
        driver.findElement(By.xpath("//input[@value='Delete This Customer']")).click();
        driver.findElement(By.xpath("//input[@value= 'Delete Customer']")).click();
        driver.quit();

    }
}
