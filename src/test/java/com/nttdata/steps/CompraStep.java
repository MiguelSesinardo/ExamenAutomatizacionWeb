package com.nttdata.steps;

import com.nttdata.page.CompraPage;
import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CompraStep {

    private WebDriver driver;

    public CompraStep(WebDriver driver){

        this.driver = driver;
    }


    public void elegirProducto() {
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(CompraPage.productoPolo)).build().perform();
    }

    public void agregarCarrito(String cantidad) {
        this.driver.findElement(CompraPage.btnAgregar).click();

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
