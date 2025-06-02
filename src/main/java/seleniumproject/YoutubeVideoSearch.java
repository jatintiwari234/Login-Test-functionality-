package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class YoutubeVideoSearch {

    public static void main(String[] args) {

        // Step 1: Launch Chrome
        WebDriver driver = new ChromeDriver();

        // Step 2: Go to YouTube
        driver.get("https://www.youtube.com");

        // Step 3: Wait until search box appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));

        // Step 4: Type "nature in 4k" and press ENTER
        searchBox.sendKeys("nature in 4k", Keys.ENTER);

        // Step 5: Wait for results to appear and click first video
        WebElement firstVideo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='video-title'])[1]")));
        firstVideo.click();

        // Step 6: Wait while video plays
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.quit();

        // Step 7: Close Chrome
        
    }
}