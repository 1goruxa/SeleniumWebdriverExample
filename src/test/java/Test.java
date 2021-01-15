import PageObject.ComposeMsg;
import PageObject.MailLogin;
import PageObject.MsgList;
import PageObject.SettingsList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.Scanner;

public class Test {
    WebDriver driver;
    WebDriverWait wait;
    String mailboxName;
    String mailboxPsw;

    @BeforeMethod
    public void openPage(){
        ChromeOptions options = new ChromeOptions();

        //Запрос данных. Имя почты и пароль указать вручную в переменных mailboxName и mailboxPsw
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название ящика:");
        //mailboxName = scanner.nextLine();
        mailboxName = "";

        System.out.println("Введите пароль:");
        //mailboxPsw = scanner.nextLine();
        mailboxPsw = "";

        //Общие настройки
        options.addArguments("--headless");
        options.addArguments("window-size=1200x600");
        System.setProperty("webdriver.chrome.driver", "D:\\JavaKotlinProjects\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver(options);

    }


    @Title("Title check")
    @Description("Checking the title of the loaded page.")
    @org.testng.annotations.Test
    public void testMailSend(){
        //Зайти в почту mail.ru
        MailLogin mailLogin = new MailLogin(driver);
        mailLogin.open();
        mailLogin.login(mailboxName, mailboxPsw);
        WaitForPageLoad.waitForPageLoad(driver);

        //Определяем сколько нашлось писем;
        SettingsList settingsList = new SettingsList(driver);
        settingsList.open();
        int msgCount = settingsList.count();

        //Переходим в список писем и создаем новое письмо
        MsgList msgList = new MsgList(driver);
        msgList.open();
        msgList.newMsg();

        WaitForPageLoad.waitForPageLoad(driver);

        //Отправить количество найденных писем самому себе
        ComposeMsg composeMsg = new ComposeMsg(driver);
        composeMsg.compose("89235974301@mail.ru", "В этом ящике нашлось писем:", msgCount);
        composeMsg.send();
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
