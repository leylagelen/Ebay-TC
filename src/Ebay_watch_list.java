import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ebay_watch_list {

    public static void main(String[] args){

        try{
            //System.setProperty("webdriver.chrome.driver","chromedriver path");
            ChromeDriver driver = new ChromeDriver();
            driver.get(" https://www.ebay.com/");
            Select statu = new Select(driver.findElement(By.id("gh-cat")));
            statu.selectByVisibleText("Books");
            driver.findElement(By.id("gh-btn")).click();
            Assert.assertEquals("Top level category browsing is not allowed. Please provide keywords or more filters for the applied top level category.","Top level category browsing is not allowed. Please provide keywords or more filters for the applied top level category.");
            WebElement book =  driver.findElement(By.id("gh-ac"));
            book.sendKeys("The Lord of the Rings");
            driver.findElement(By.id("gh-btn")).click();
            driver.findElementByXPath("/html/body/div[4]/div[5]/div[2]/div[1]/div[2]/ul/li[1]").click();
            String price = driver.findElement(By.xpath("//*[@id=\"prcIsum\"]")).getText();
            System.out.println("Price:"+price);
            driver.findElement(By.xpath("//*[@id=\"vi-atl-lnk\"]/a/span[2]")).click();
            WebElement email = driver.findElement(By.xpath("//*[@id=\"userid\"]"));
            email.sendKeys(" email adress");
            WebElement password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
            password.sendKeys("password");
            driver.findElement(By.xpath("//*[@id=\"sgnBt\"]")).click();
            Thread.sleep(3000);
            driver.close();
            System.out.println("TEST PASSED");
        }catch(Exception e){
            System.out.println("TEST FAILED");
        }
    }
}

        /*   Test Case Steps;
        1.Visit https://www.ebay.com/
        2. Select Books category on the drop down menu for search field and hit the Search button
        3. Assert  check for error "Top level category browsing is not allowed. Please provide keywords or more filters for the applied top level category."
        4. Search for "The Lord of the Rings" for "Books" category
        5. Click for the first result link
        6. Collect Price for book
        7. Add to watch list
        8. Login with username & password */