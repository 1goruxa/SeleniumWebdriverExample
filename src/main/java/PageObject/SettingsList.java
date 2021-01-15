package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsList {
    WebDriver driver;

    public SettingsList(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://m.mail.ru/folders/");
    }

    public int count(){
        String text = driver.findElement(By.xpath("//p[contains(@class,'folder-list__item__total-messages')]")).getText();
        int countMsg = Integer.parseInt(text.substring(text.indexOf(" ")+1, text.indexOf("п")-1));
        return countMsg;
    }
}
