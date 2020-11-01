package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.Thread;

import static java.lang.Thread.sleep;

public class Home {

    By sideMenu1 = By.xpath("//ul[@class='lzd-site-menu-root']/li/a/span");
    By sideMenu2 = By.xpath("//ul[@class='lzd-site-menu-sub Level_1_Category_No1 lzd-site-menu-sub-active']/li/a/span");
    By sideMenu3 = By.xpath("//ul[@class='lzd-site-menu-grand lzd-site-menu-grand-active']/li/a/span");


    public void clickSideMenuLevel1(WebDriver driver, String menuName) {

        List<WebElement> Menuitems = driver.findElements(sideMenu1);
        for (WebElement MenuItem : Menuitems) {
            if (MenuItem.getText().equalsIgnoreCase(menuName)) {
                MenuItem.click();
                break;
            }

        }
    }

    public void clickSideMenuLevel2(WebDriver driver, String menuName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        sleep(3000);
        List<WebElement> Menuitems = driver.findElements(sideMenu2);
        for (WebElement MenuItem : Menuitems) {
            if (MenuItem.getText().equalsIgnoreCase(menuName)) {

                MenuItem.click();
                break;
            }

        }
    }

    public void clickSideMenuLevel3(WebDriver driver, String menuName) throws InterruptedException {
        sleep(3000);
        List<WebElement> Menuitems = driver.findElements(sideMenu3);
        for (WebElement MenuItem : Menuitems) {
            if (MenuItem.getText().equalsIgnoreCase(menuName)) {
                MenuItem.click();
                break;
            }

        }
    }

    public void hoverSideMenuLevel2(WebDriver driver, String menuName) throws InterruptedException {
        // WebDriverWait wait = new WebDriverWait (driver, 25);
        //wait.until (((JavaScriptExecutor)driver).ExecuteScript("return document.readyState").Equals("complete"));
        Actions actions = new Actions(driver);
        sleep(30000);
        List<WebElement> Menuitems = driver.findElements(sideMenu2);
        for (WebElement MenuItem : Menuitems) {
            if (MenuItem.getText().equalsIgnoreCase(menuName)) {
                actions.moveToElement(MenuItem, 50, 0).perform();
                //MenuItem.click();
                break;
            }

        }
    }

    public void hoverSideMenuLevel1(WebDriver driver, String menuName) throws InterruptedException {
        Actions actions = new Actions(driver);
        sleep(3000);
        List<WebElement> Menuitems = driver.findElements(sideMenu1);
        for (WebElement MenuItem : Menuitems) {
            if (MenuItem.getText().equalsIgnoreCase(menuName)) {
                actions.moveToElement(MenuItem, 50, 0).perform();
                //MenuItem.click();
                break;
            }

        }
    }

    public boolean verifySideMenuLevel2(WebDriver driver, String secondLevelList) throws InterruptedException {

        List<String> list1 = Arrays.asList(secondLevelList.split("\\s*,\\s*"));
        Actions actions = new Actions(driver);
        sleep(5000);
        List<WebElement> Menuitems = driver.findElements(sideMenu2);
        List<String> list2 = new ArrayList<String>();
        for (WebElement MenuItem : Menuitems) {
            String MI1 = MenuItem.getText();
            if (MI1 != "") {
                list2.add(MI1);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        if (list1.equals(list2)) {

            return true;
        } else {
            return false;
        }

    }

    public boolean verifySideMenuLevel3(WebDriver driver, String thirdLevelList) throws InterruptedException {

        List<String> list1 = Arrays.asList(thirdLevelList.split("\\s*,\\s*"));
        Actions actions = new Actions(driver);
        sleep(5000);
        List<WebElement> Menuitems = driver.findElements(sideMenu3);
        List<String> list2 = new ArrayList<String>();
        for (WebElement MenuItem : Menuitems) {
            String MI1 = MenuItem.getText();
            if (MI1 != "") {
                list2.add(MI1);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        if (list1.equals(list2)) {

            return true;
        } else {
            return false;
        }
    }
}



