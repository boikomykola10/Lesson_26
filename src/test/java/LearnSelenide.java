import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LearnSelenide {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1200x900";
        Configuration.timeout = 5000;
        open("https://rozetka.com.ua/");
    }

    @Test
    public void testSelenide() {
        /*$(By.xpath("//button[@class='button button--navy button--small main-auth__button']")).
                 shouldBe(visible)
                .shouldNotHave(text("Maks"))
                .shouldHave(text("Увійдіть в особистий кабінет"))
                .click();*/
        /*SelenideElement login = $("body > app-root > div > div > rz-header > rz-main-header > header > " +
                "div > div > ul > li.header-actions__item.header-actions__item--user > rz-user > button");

        String text = login.getText();
        System.out.println(text);

        String color = login.getCssValue("color");
        System.out.println(color);

        sleep(5000);*/
        WebDriver driver = getWebDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        SelenideElement laptopsAndComputers = $(By.xpath("//a[@class='main-categories__link ng-star-inserted']"));
                // $(By.cssSelector("body > app-root > div > div > rz-main-page > div > main > rz-main-page-content > " +
                //"rz-app-fat-menu-tablet > nav > ul > li:nth-child(1) > a"));
        jse.executeScript("arguments[0].click()", laptopsAndComputers);

        /*JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        SelenideElement laptops = $("body > app-root > rz-single-modal-window > " +
                "div.modal__holder.modal__holder_show_animation.modal__holder--large > div.modal__content > fat-menu-mobile > ul.menu-main.ng-star-inserted > li:nth-child(1) > a");
        jse1.executeScript("arguments[0].click()", laptops);*/
        $(By.xpath("//a[@class='menu-main__link button--medium button--link']"))
                /*"body > app-root > rz-single-modal-window > div.modal__holder.modal__holder_" +
                "show_animation.modal__holder--large > div.modal__content > fat-menu-mobile > ul.menu-main.ng-star-" +
                "inserted > li:nth-child(1) > a"*/
                .click();

        $("body > app-root > div > div > rz-category > div > main > rz-catalog > div > div > section > " +
                "rz-grid > ul > li:nth-child(1) > rz-catalog-tile > app-goods-tile-default > div > div.goods-tile__inner " +
                "> div.goods-tile__prices > div.goods-tile__price.price--red.ng-star-inserted > app-buy-button > button")
                .click();
        String firstProductTitle = $(By.xpath("/html/body/app-root/div/div/rz-category/div/main/rz-catalog" +
                "/div/div/section/rz-grid/ul/li[1]/rz-catalog-tile/app-goods-tile-default/div/div[2]/a[2]/span"))
                .getText();
        System.out.println(firstProductTitle);

        $(By.xpath("//span[@class='counter counter--green ng-star-inserted']"))
                .shouldHave(text("1"));

        $(By.xpath("//button[@class='header__button ng-star-inserted header__button--active']"))
                .click();

        String productTitleInBasket = $("body > app-root > div > div > rz-cart-page > div > main > rz-shopping" +
                "-cart > div > ul > li > rz-cart-product > div > div.cart-product__body > div > a")
                .getText();
        System.out.println(productTitleInBasket);

        Assert.assertEquals(productTitleInBasket, firstProductTitle);

        sleep(2000);


    }
}
