package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposeMsg {
    WebDriver driver;

    public ComposeMsg(WebDriver driver) {
        this.driver = driver;
    }

    public void compose(String to, String subj, int msgCount){
        WebElement el = driver.findElement(By.name("To"));
        el.sendKeys(to);
        el = driver.findElement(By.name("Subject"));
        el.sendKeys(subj);
        el = driver.findElement(By.name("Body"));
        el.clear();
        el.sendKeys(String.valueOf(msgCount));
    }

    public void send(){
        driver.findElement(By.name("send")).click();
    }

}
