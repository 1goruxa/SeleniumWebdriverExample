package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MsgList {
    WebDriver driver;

    public MsgList(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://m.mail.ru/messages/inbox");

    }

    public void newMsg(){
        driver.findElement(By.xpath("//span[contains(text(),'Написать')]")).click();
    }
}
