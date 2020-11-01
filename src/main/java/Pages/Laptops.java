package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Laptops {

    By navigation2In1Laptop = By.xpath("//span[@class='breadcrumb_item_anchor breadcrumb_item_anchor_last']");
    By header2In1Laptop = By.xpath("//h1[@class='c2BJaq']");


    public boolean verifyNavigation2In1Laptop(WebDriver driver, String name) {

            String nav2In1Laptop = driver.findElement(navigation2In1Laptop).getText();
            if (nav2In1Laptop.equalsIgnoreCase(name)) return true;
            else{

                return false;
            }
            }

    public boolean verifyHeader2In1Laptop(WebDriver driver, String name) {

        String hea2In1Laptop = driver.findElement(header2In1Laptop).getText();
        if (hea2In1Laptop.equalsIgnoreCase(name)) return true;
        else{

            return false;
        }

        }

}


