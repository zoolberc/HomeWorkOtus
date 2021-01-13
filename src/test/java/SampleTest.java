import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class SampleTest {
    protected static WebDriver driver;
    protected static Logger logger = LogManager.getLogger(SampleTest.class);

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Driver open");
    }

    @Test
    public void openPage(){
        driver.get("https://otus.ru/");
        logger.info("Page open");

        String currentTitle = driver.getTitle();
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        assertEquals(expectedTitle,currentTitle);
        logger.info("Passed check title");
    }

    @After
    public void setDown(){
        if (driver != null){
            driver.quit();
            logger.info("Close driver");
        }
    }

}
