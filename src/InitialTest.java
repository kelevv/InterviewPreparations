import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class InitialTest {
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeSuite
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "\\Users\\vikentii.kelevich\\IdeaProjects\\LearningSelenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);

        js = (JavascriptExecutor) driver;
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.onpathtesting.com/blog/qa-testers-what-is-the-agile-testing-pyramid");
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//*[@class=\"PostItem__title\"])[1]")));
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("(//*[@class=\"PostItem__title\"])[1]")).getText(),
                "Is my functional testing aligned with my end-user goals?");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
