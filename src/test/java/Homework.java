import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Homework {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1200x900";
        Configuration.timeout = 5000;
        open("https://rozetka.com.ua/");
    }

    @Test
    public void finalTest() {
        SelenideElement category = $(By.xpath("//a[@class='main-categories__link ng-star-inserted']"));

        JavascriptExecutor jse;
        jse = (JavascriptExecutor)getWebDriver();
        jse.executeScript("arguments[0].click()", category);

        SelenideElement laptopCategory = $(By.xpath("//a[@class='menu-main__link button--medium button--link']"));
        laptopCategory.click();

        SelenideElement productTitle = $(By.xpath("//span[@class='goods-tile__title']"));
        productTitle.text();

        SelenideElement buyBtn = $(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']"));
        buyBtn.click();

        SelenideElement counter = $(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
        counter.shouldHave(text("1"));

        SelenideElement cartProductTitle = $(By.xpath("//a[@class='cart-product__title']"));
        String cartProductTitleText = cartProductTitle.text();

        Assert.assertEquals(productTitle, cartProductTitleText);

    }
}
