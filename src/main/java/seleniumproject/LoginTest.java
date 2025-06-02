package seleniumproject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginTest {

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("myname");
        driver.findElement(By.name("inputPassword")).sendKeys("volter6870*0");

        // attempt to log in
        driver.findElement(By.className("signInBtn")).click();

        // wait for error message and print it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
        System.out.println("Login error: " + driver.findElement(By.cssSelector("p.error")).getText());

        // click on "Forgot your password?" link
        driver.findElement(By.linkText("Forgot your password?")).click();

        // fill in password recovery form
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Jatin");
        sleep(800);
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jatin123@gmail.com");
        sleep(800);
        driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9123456789");
        sleep(500);

        // click on Reset Password button
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        // wait for success message and print it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.infoMsg")));
        System.out.println("Password reset message: " + driver.findElement(By.cssSelector("p.infoMsg")).getText());

        // go back to login page
        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername")));

        // log in with correct credentials
        driver.findElement(By.id("inputUsername")).sendKeys("jatintiwari");
        sleep(800);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        sleep(500);
        driver.findElement(By.cssSelector("button.submit.signInBtn")).click();

        // wait and verify success message
        sleep(3000); 
        String successMessage = driver.findElement(By.tagName("p")).getText();
        System.out.println("Login success message: " + successMessage);

        // assertion to ensure login was successful
        Assert.assertEquals(successMessage, "You are successfully logged in.");

        // close browser after test
        driver.quit();
    }
}
