package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailLogin {
    WebDriver driver;

    public MailLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://m.mail.ru/login");
    }

    public void login(String name, String password){
        WebElement el = driver.findElement(By.name("Login"));
        el.sendKeys(name);
        el = driver.findElement(By.name("Password"));
        el.sendKeys(password);
        el.sendKeys(Keys.ENTER);
    }

}
