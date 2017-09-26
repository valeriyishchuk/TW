import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestW1 {
    WebDriver driver;
    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","/Users/valeriy/Desktop/chromedriver");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().setSize(new Dimension(1950,1050));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @After
    public void EndTests() throws Exception {

        Thread.sleep(5000);
       // driver.close();

    }

    @Test
    public void RedirectLinks() throws Exception {
        open("http://vk.com");
        $(By.className("login_mobile_header")).shouldHave(Condition.text("ВКонтакте для мобильных устройств"));
        $(By.xpath(".//div[2]/div[1]/div[3]/a[1]/div[2]/button")).click();
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        $(By.xpath("//SPAN[text()='Установить']")).shouldBe(visible);
        driver.close();
        driver.switchTo().window(tabs1.get(0));
        $(By.xpath("(//BUTTON[@class='flat_button secondary button_light'])[3]")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        $(By.xpath("(//SPAN[@class='mask'])[6]")).shouldBe(visible);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        $(By.xpath("(//BUTTON[@class='flat_button secondary button_light'])[2]")).click();
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs3.get(1));
        $(By.xpath("(//A[@data-bi-dnt=''])[1]")).shouldBe(visible);
        driver.close();
        driver.switchTo().window(tabs3.get(0));
        Thread.sleep(3000);

    }
    @Test
    public void RegistrationOfNewUser () throws Exception {
        open("http://vk.com");
        $(By.id("ij_first_name")).sendKeys("test");
        $(By.id("ij_last_name")).sendKeys("new");
        $(By.id("dropdown1")).click();
        $(By.xpath(".//*[@id='container1']//ul/li[9]")).click();
        $(By.id("dropdown2")).click();
        $(By.xpath(".//*[@id='container2']/div/div/ul/li[5]")).click();
        $(By.id("dropdown3")).click();
        $(By.xpath(".//*[@id='container3']//ul/li[18]")).click();
        $(By.id("ij_submit")).click();
        $(By.xpath(".//*[@id='ij_sex_row']/div[3]")).click();
        $(By.id("ij_submit")).click();
        $(By.xpath(".//*[@id='join_country_row']//td[1]/input[1]")).click();
        $(By.xpath(".//*[@id='join_country_row']/div/table/tbody/tr/td[1]/input[1]")).clear();
        $(By.xpath(".//*[@id='join_country_row']/div/table/tbody/tr/td[1]/input[1]")).sendKeys("Украина");
        $(By.xpath(".//*[@id='join_country_row']/div/table/tbody/tr/td[1]/input[1]")).pressEnter();
        $(By.id("join_phone")).sendKeys("637662667");
        $(By.id("join_send_phone")).click();
        $(By.id("join_code")).sendKeys("51892");
        $(By.id("join_send_code")).click();
        $(By.id("join_pass")).sendKeys("!qazXsw2");
        $(By.id("join_send_pass")).click();
        $(By.className("feed_asc_header")).shouldHave(Condition.text("Добро пожаловать"));
        Thread.sleep(3000);
    }
    @Test
    public void SignInViaFacebook () throws Exception {
        open("http://vk.com");
        $(By.xpath(".//*[@id='index_fbcontinuewithsign']/div")).click();
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        $(By.id("email")).sendKeys("y_dick_23@yahoo.com");
        $(By.id("pass")).sendKeys("T9CbUJvzbC3");
        $(By.id("u_0_0")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        $(By.xpath(".//*[@id='join_fb_finish']/div[2]/button")).click();
        $(By.id("join_box_first_name")).sendKeys("test");
        $(By.id("join_box_last_name")).sendKeys("new");
        $(By.id("dropdown5")).click();
        $(By.xpath(".//*[@id='container5']/div/div/ul/li[9]")).click();
        $(By.id("dropdown6")).click();
        $(By.xpath(".//*[@id='container6']/div/div/ul/li[5]")).click();
        $(By.id("dropdown7")).click();
        $(By.xpath(".//*[@id='container7']/div/div/ul/li[18]")).click();
        $(By.id("join_submit_button")).click();
        $(By.xpath(".//*[@id='join_box_sex_row']/div[3]")).click();
        $(By.id("join_submit_button")).click();
        $(By.id("join_phone")).sendKeys("637662667");
        $(By.id("join_send_phone")).click();
        $(By.id("join_code")).sendKeys("51892");
        $(By.id("join_send_code")).click();
        $(By.id("join_pass")).sendKeys("!qazXsw2");
        $(By.id("join_send_pass")).click();
        $(By.className("feed_asc_header")).shouldHave(Condition.text("Добро пожаловать"));
        Thread.sleep(3000);
    }
    @Test
    public void NegativeLogIn () throws Exception {
        open("http://vk.com");
        $(By.id("index_email")).sendKeys("wrongemail");
        $(By.id("index_pass")).sendKeys("wrongpass");
        $(By.id("index_login_button")).click();
        $(By.xpath(".//*[@id='login_message']/div/div/b[1]")).shouldHave(text("Не удается войти."));
        Thread.sleep(3000);
    }
    @Test
    public void PositiveLogIn () throws Exception {
        open("http://vk.com");
        $(By.id("index_email")).sendKeys("+380637662667");
        $(By.id("index_pass")).sendKeys("!qazXsw2");
        $(By.id("index_login_button")).click();
        $(By.xpath("(//DIV[@class='feed_asc_block center page_block _block'])[1]")).shouldHave(text("Добавьте фотографию"));
        Thread.sleep(3000);
    }
}

