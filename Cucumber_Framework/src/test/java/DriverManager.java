import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverManager
{
    public WebDriver driver;
    WebDriverWait wait;
    FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configs\\config.properties");
    Properties prop=new Properties();
    public DriverManager() throws IOException {
        prop.load(fis);

    }

    public void loadDriver()
    {
        switch (prop.getProperty("browser")) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
               wait =new WebDriverWait(driver, Duration.ofSeconds(30));
                driver.get(prop.getProperty("URL"));
              //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.)
                System.out.println("Driver is set to chrome");
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(prop.getProperty("URL"));
                System.out.println("Driver is set to firefox");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        DriverManager D=new DriverManager();
        D.loadDriver();
    }
}
