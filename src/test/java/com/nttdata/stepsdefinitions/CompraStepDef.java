package com.nttdata.stepsdefinitions;

import com.nttdata.page.CompraPage;
import com.nttdata.page.LoginPage;
import com.nttdata.steps.CompraStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;

public class CompraStepDef {
    private WebDriver driver;
    CompraStep compraStep;

    @Y("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) {
        driver = getDriver();
        compraStep = new CompraStep(driver);
        compraStep.elegirProducto();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement txtCantidad = driver.findElement(CompraPage.btnAgregar);
//        wait.until(ExpectedConditions.visibilityOf(txtCantidad));
        compraStep.agregarCarrito(cantidad);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement txtCantidad = driver.findElement(CompraPage.cantidad);
//        wait.until(ExpectedConditions.visibilityOf(txtCantidad));
        //compraStep.agregarCarrito(cantidad);






    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        compraStep.validarAgregarProducto();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        compraStep.finalizarCompra();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        compraStep.validarFinalizarCompra();
    }
}
