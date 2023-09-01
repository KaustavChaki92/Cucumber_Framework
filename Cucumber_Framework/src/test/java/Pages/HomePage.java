package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;

public class HomePage {
public WebDriver driver;
public WebDriverWait wait;

public HomePage(WebDriver driver)
{
    this.driver=driver;
    wait=new WebDriverWait(driver, Duration.ofSeconds(30),Duration.ofSeconds(2));
 //   wait.until(ExpectedConditions.visibilityOfElementLocated());
    PageFactory.initElements(driver,this);
}
    @FindBy(how = How.XPATH, xpath = "//a[@aria-label='Amazon.in']")
    public WebElement logo;

    @FindBy(xpath = "//span[contains(text(),'Hello, sign in')]")
    public WebElement SignInBtn;
}
