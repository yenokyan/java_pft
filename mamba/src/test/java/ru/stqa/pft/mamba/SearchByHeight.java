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

public class SearchByHeight {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void SearchByHeight() {
        Login();
        // Делаем поиск по заданному росту 180 - 190 см
        wd.findElement(By.linkText("Поиск")).click();
        wd.findElement(By.xpath("//nav[@class='b-menu__auth']/a[10]/i")).click();
        if (!wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[2]/div[5]/div/div[2]/select//option[5]")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[2]/div[5]/div/div[2]/select//option[5]")).click();
        }
        String str1 = wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[2]/div[5]/div/div[2]/select//option[5]")).getText();

        if (!wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[2]/div[6]/div/div[2]/select//option[6]")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[2]/div[6]/div/div[2]/select//option[6]")).click();
        }
        String str2 = wd.findElement(By.xpath("//div[@class='b-fieldset']/fieldset[2]/div[6]/div/div[2]/select//option[6]")).getText();

        //Проверяем рост в нескольких анкетах
        wd.findElement(By.cssSelector("input.button.b-button")).click();
        wd.findElement(By.cssSelector("img.g-block_item-image")).click();
        wd.findElement(By.xpath("//div[@class='b-content__main']//div[.='180']")).click();
        String prof1 = wd.findElement(By.xpath("//div[@class='b-content__main']//div[.='180']")).getText();
        wd.navigate().back();
        wd.findElement(By.xpath("//div[@class='b-content__main']/ul[2]/li[6]/a/span[1]/div/img")).click();
        wd.findElement(By.xpath("//div[@class='b-content__main']//div[.='190']")).click();
        String prof2 = wd.findElement(By.xpath("//div[@class='b-content__main']//div[.='190']")).getText();
        wd.navigate().back();
        wd.findElement(By.xpath("//div[@class='b-content__main']/ul[2]/li[9]/a/span[1]/div/img")).click();
        wd.findElement(By.xpath("//div[@class='b-content__main']//div[.='186']")).click();
        String prof3 = wd.findElement(By.xpath("//div[@class='b-content__main']//div[.='186']")).getText();

        //Удаляем лишнее (из "180см (5'11'') оставляем только "180")
        String substr1 = str1.substring(0,3);
        String substr2 = str2.substring(0,3);

        //Превращаем строку в число
        int i = Integer.parseInt(substr1);
        int j = Integer.parseInt(substr2);
        int p1 = Integer.parseInt(prof1);
        int p2 = Integer.parseInt(prof2);
        int p3 = Integer.parseInt(prof3);

        //Проверяем нет ли после поиска анкет не из заданного диапазона
        if (p1>=i && p1<=j && p2>=i && p2>=j && p3>=i && p3<=j)
        {
            System.out.println("OK");
        }
    }

    private void Login() {
        wd.get("http://m.mamba.ru.www5.lan/");
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
