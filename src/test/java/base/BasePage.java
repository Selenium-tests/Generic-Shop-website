package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public abstract class BasePage {

        protected WebDriver driver;
        protected SoftAssert softAssert = new SoftAssert();
        //final String chromeDriverFilePath = "C:\\Users\\Player One\\IdeaProjects\\untitled1\\drivers\\chromedriver.exe";

        protected BasePage(WebDriver driver) {

                this.driver = driver;

                PageFactory.initElements(driver, this);
        }
        public String getTitle() {

                return driver.getTitle();
        }

        public void wait(int seconds) {

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        }
}
