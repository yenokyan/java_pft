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

public class SearchByAge {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void SearchByAge() {
        Login();
        wd.findElement(By.linkText("Поиск")).click();

        //String str = wd.findElement(By.className("b-field__type ng-pristine ng-valid ng-touched")).getText();

        wd.findElement(By.xpath("//nav[@class='b-menu__auth']/a[10]/i")).click();
        if (!wd.findElement(By.xpath("//div[@class='b-field__inner']/select[1]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-field__inner']/select[1]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@class='b-field__inner']/select[2]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[@class='b-field__inner']/select[2]//option[3]")).click();
        }
        wd.findElement(By.cssSelector("input.button.b-button")).click();

        // Берем теккстовые значения полей
        String str1 = wd.findElement(By.xpath("//div[@class='b-field__inner']/select[1]//option[1]")).getText();
        String str2 = wd.findElement(By.xpath("//div[@class='b-field__inner']/select[2]//option[3]")).getText();
        String str = wd.findElement(By.className("age")).getText();
        // Убираем лишние значения, в нешем случае пробел и слово "лет"
        String substr = str.substring(2,4);
        // Текстовые поля превращяем в числа
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        int k = Integer.parseInt(substr);
        //Смотрим на странице в общем классе Age нет ли чисел не совпадающий с заданным диапозоном
        if (k>=i && k<=j)
        {
            System.out.println("OK");
        }
    }

    //String str = wd.findElement(By.tagName("html")).getText();
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

        //WebElement mySelEl = wd.findElement(By.xpath("//fieldset[@class='b-form_fieldset']/div[5]/div/div[2]/input"));
       // Select mySel = new Select(mySelEl);



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

/*
WebElement mySelectElm = driver.findElement(By.id("mySelectID"));
Select mySelect= new Select(mySelectElm);
selMySelect.selectByValue("Value");*/
