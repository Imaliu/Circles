package TestCases;

import Pages.Home;
import Pages.Laptops;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.CommandBase;
import utils.DataProviders;

import java.util.concurrent.TimeUnit;

public class Regression {


        public WebDriver driver;
        Home home=new Home();
        Laptops laptops = new Laptops();

        @BeforeMethod
        @Parameters({"browser","url","driverPath"})

        public void setup(String browser,String url,String driverPath) {


            if (browser.equalsIgnoreCase("chrome")) {



                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--disable-notifications");
                ops.addArguments("disable-infobars");

                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver(ops);
            } else if (browser.equalsIgnoreCase("firefox")) {

                System.setProperty("webdriver.gecko.driver",
                        "/Users/Imali/Documents/Projects/Drivers/geckodriver");
                driver = new FirefoxDriver();
            }


            driver.get(url);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }


        @Test(dataProvider = "dt_ValidateUserCanNavigateToLeafCategoryPageAndSeeTheproductsListedInThePage", dataProviderClass = DataProviders.class)

        public void ValidateUserCanNavigateToLeafCategoryPageAndSeeTheproductsListedInThePage(String topCategory, String secondLevelCategory,String thirdLevelCategory, String header) throws InterruptedException {
            home.clickSideMenuLevel1(driver,topCategory);
            home.hoverSideMenuLevel2(driver,secondLevelCategory);
            home.clickSideMenuLevel3(driver,thirdLevelCategory);
            Assert.assertTrue(laptops.verifyNavigation2In1Laptop(driver,thirdLevelCategory));
            Assert.assertTrue(laptops.verifyHeader2In1Laptop(driver,header));
        }


    @Test(dataProvider = "dt_ValidateIfChildCategoriesDisplayedExpected", dataProviderClass = DataProviders.class)

    public void ValidateIfChildCategoriesDisplayedExpected(String topCategory, String secondLevelCategory,String secondLevelList, String thirdLevelList) throws InterruptedException {
        home.hoverSideMenuLevel1(driver,topCategory);
        Assert.assertEquals(home.verifySideMenuLevel2(driver,secondLevelList),true);
        home.hoverSideMenuLevel2(driver,secondLevelCategory);
        Assert.assertEquals(true,home.verifySideMenuLevel3(driver,thirdLevelList));

    }
@AfterMethod
    public void quit(){


            driver.quit();
}

}
