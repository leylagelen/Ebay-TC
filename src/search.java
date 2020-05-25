import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class search {
    public static void main(String[] args){

        try {
            WebDriver driver = new ChromeDriver(); //Open with chrome browser
            driver.get("http://www.google.com"); // Web page url
            Thread.sleep(5000); // sleep during 5 seconds
            driver.close(); // close driver
            System.out.println("TEST PASSED");
        } catch (Exception e) {
            System.out.println("TEST FAILED");
        }
    }
}
