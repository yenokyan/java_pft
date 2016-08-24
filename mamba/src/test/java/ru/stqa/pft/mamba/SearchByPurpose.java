package ru.stqa.pft.mamba;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class SearchByPurpose {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void SearchByPurpose() {
        Login();

        //Выполняем поиск по цели знакомства - Путешествия
        wd.findElement(By.linkText("Поиск")).click();
        wd.findElement(By.xpath("//nav[@class='b-menu__auth']/a[10]/i")).click();

        //Смотрим нет ли других указанных целей в анкете, если есть то снимаем
        if (wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[1]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[1]/ng-include/div/input")).click();
        }
        wd.findElement(By.xpath("//div[@class='b-fieldset']//div[normalize-space(.)='Переписка']")).click();
        if (wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[2]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[2]/ng-include/div/input")).click();
        }
        if (wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[3]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[3]/ng-include/div/input")).click();
        }
        if (wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[4]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[4]/ng-include/div/input")).click();
        }
        if (wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[5]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[5]/ng-include/div/input")).click();
        }
        if (wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[6]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[6]/ng-include/div/input")).click();
        }
        if (!wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[7]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[7]/ng-include/div/input")).click();
        }
        if (wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[8]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[8]/ng-include/div/input")).click();
        }
        if (wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[9]/ng-include/div/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[1]/div[8]/div/div[2]/div/label[9]/ng-include/div/input")).click();
        }

        //Проверяем цель в нескольких анкетах
        wd.findElement(By.cssSelector("input.button.b-button")).click();
        wd.findElement(By.cssSelector("span.name")).click();
        wd.findElement(By.xpath("//div[@class='b-content__main']//li[.='Путешествия']")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Путешествия")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.navigate().back();
        wd.findElement(By.linkText("2")).click();
        wd.findElement(By.xpath("//div[@class='b-content__main']/ul[2]/li[4]/a/span[1]/div/img")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Путешествия")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.cssSelector("html")).click();
        wd.navigate().back();
        wd.findElement(By.linkText("4")).click();
        wd.findElement(By.xpath("//div[@class='b-content__main']/ul[2]/li[5]/a/span[1]/div/img")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Путешествия")) {
            System.out.println("verifyTextPresent failed");
        }
    }

    private void Login() {
        wd.get("http://m.mamba.ru.www5.lan/ru/");
        wd.findElement(By.linkText("Вход")).click();
        wd.findElement(By.xpath("//fieldset[@class='b-form_fieldset']/div[5]/div/div[2]/input")).click();
        wd.findElement(By.xpath("//fieldset[@class='b-form_fieldset']/div[5]/div/div[2]/input")).clear();
        wd.findElement(By.xpath("//fieldset[@class='b-form_fieldset']/div[5]/div/div[2]/input")).sendKeys("arega.yenokyan@yahoo.com");
        wd.findElement(By.xpath("//fieldset[@class='b-form_fieldset']/div[6]/div/div[2]/input")).click();
        wd.findElement(By.xpath("//fieldset[@class='b-form_fieldset']/div[6]/div/div[2]/input")).clear();
        wd.findElement(By.xpath("//fieldset[@class='b-form_fieldset']/div[6]/div/div[2]/input")).sendKeys("Qw123456");
        wd.findElement(By.cssSelector("input.b-button")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
