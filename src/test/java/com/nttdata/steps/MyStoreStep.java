package com.nttdata.steps;

import com.nttdata.page.CompraPage;
import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStoreStep {
    private WebDriver driver;

    public MyStoreStep(WebDriver driver){
        this.driver = driver;
    }

    public void buscarIniciarSesion() {
        this.driver.findElement(LoginPage.IniciarSesion).click();
    }

    public void ingresarUsuario(String usuario) {
        WebElement userInputElement = driver.findElement(LoginPage.usuario);
        userInputElement.sendKeys(usuario);
    }

    public void ingresarPassword(String password) {
        WebElement userInputElement = driver.findElement(LoginPage.pass);
        userInputElement.sendKeys(password);
    }

    public void iniciarSesion() {
        this.driver.findElement(LoginPage.btnIniciarSesion).click();
    }

    public void validarInicioSesion() {
        WebElement nombre = driver.findElement(LoginPage.nombre);
        String txtNombre = nombre.getText();
        Assertions.assertEquals("Miguel Sesinardo", txtNombre);
    }

    public void validarNoInicioSesion() {
        WebElement nombre = driver.findElement(LoginPage.errorMensaje);
        String txtNombre = nombre.getText();
        Assertions.assertEquals("Error de autenticación.", txtNombre);
    }

    public void eleccionCategoriaSubcategoria(String categoria, String subcategoria) {
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("a[href*='"+categoria+"']"))).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement subcat = driver.findElement(By.cssSelector("a[href*='"+subcategoria+"']"));
        wait.until(ExpectedConditions.visibilityOf(subcat));
    }

    public void elegirProducto() {
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(CompraPage.productoPolo)).build().perform();
    }

    public void agregarCarrito(String cantidad) throws InterruptedException {
        this.driver.findElement(CompraPage.producto).click();
        Thread.sleep(2000L);
//        this.driver.findElement(CompraPage.cantidad).click();
//        this.driver.findElement(CompraPage.btnAgregar).click();
//        Thread.sleep(2000L);

    }

    public void validarAgregarProducto() {

        WebElement mensaje = driver.findElement(CompraPage.mensajeAgregar);
        String txtMensaje = mensaje.getText();
        Assertions.assertEquals("Producto añadido correctamente a su carrito de compra", txtMensaje);
    }

    public void finalizarCompra() {
        this.driver.findElement(CompraPage.btnFinalizarCompra).click();

    }

    public void validarFinalizarCompra() {
        WebElement mensaje = driver.findElement(CompraPage.mensajeCarrito);
        String txtMensaje = mensaje.getText();
        Assertions.assertEquals("CARRITO", txtMensaje);
    }
}


