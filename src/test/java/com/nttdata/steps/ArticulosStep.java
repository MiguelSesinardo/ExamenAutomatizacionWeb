package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArticulosStep {

    private WebDriver driver;

    public ArticulosStep(WebDriver driver){

        this.driver = driver;
    }


    public void eleccionCategoriaSubcategoria(String categoria, String subcategoria) {
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("a[href*='"+categoria+"']"))).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement subcat = driver.findElement(By.cssSelector("a[href*='"+subcategoria+"']"));
        wait.until(ExpectedConditions.visibilityOf(subcat));
    }
}
