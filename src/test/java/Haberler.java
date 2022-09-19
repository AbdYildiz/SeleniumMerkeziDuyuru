import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Haberler extends BaseTest{
//    public WebDriver driver;

    @BeforeSuite public void init(){
        driver = initialize();
    }

    @Test public void createHaber() throws InterruptedException {
        driver.findElement(By.xpath("//span[normalize-space()='Haberler']")).click();
        driver.findElement(By.xpath("//a[@class='nav-link active']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Haber Oluştur')]")).click();

        String name = "la bandera";
        driver.findElement(By.xpath("((//div[@class='modal-content'])[2]//input)[1]")).sendKeys("C:\\Users\\Si\\Desktop\\RAZER\\la bandera.jpg");
        driver.findElement(By.xpath("((//div[@class='modal-content'])[2]//input)[2]")).sendKeys(name);
        driver.findElement(By.xpath("((//div[@class='modal-content'])[2]//input)[3]")).sendKeys("4");
        driver.findElement(By.xpath("((//div[@class='modal-content'])[2]//input)[4]")).clear();
        driver.findElement(By.xpath("((//div[@class='modal-content'])[2]//input)[4]")).sendKeys("6");
        driver.findElement(By.xpath("((//div[@class='modal-content'])[2]//textarea)")).sendKeys("Hello ladies and gentleman this is a Selenium test Automation that will change your life forever!!!");
        driver.findElement(By.xpath("((//div[@class='modal-content'])[2]//input)[5]")).click();
        driver.findElement(By.xpath("((//div[@class='modal-content'])[2]//button)[2]")).click();
        WebElement ok = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        ok.click();
        wait.until(ExpectedConditions.invisibilityOf(ok));
        boolean act = driver.findElement(By.xpath("//td[normalize-space()='"+name+"']")).isDisplayed();
        soft.assertTrue(act);

        driver.findElement(By.xpath("(//td[normalize-space()='Sil'])[2]")).click();
        WebElement accept = driver.findElement(By.xpath("//button[normalize-space()='Onayla']"));
        accept.click();
        Thread.sleep(1000);
        boolean act2 = driver.findElement(By.xpath("//h2[@id='swal2-title']")).isDisplayed();
        soft.assertTrue(act2);
        driver.findElement(By.xpath("//button[normalize-space()='Tamam']")).click();

        soft.assertAll();
    }

    @AfterSuite public void close() throws InterruptedException {
        quit();
    }
}
