package com.nttdata.stepsdefinitions;

import com.nttdata.page.CompraPage;
import com.nttdata.page.LoginPage;
import com.nttdata.steps.MyStoreStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepDef {
    private WebDriver driver;
    MyStoreStep myStoreStep;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");

        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String password) {

        myStoreStep = new MyStoreStep(driver);
        myStoreStep.buscarIniciarSesion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textoTitulo = driver.findElement(LoginPage.textoTitulo);
        wait.until(ExpectedConditions.visibilityOf(textoTitulo));
        myStoreStep.ingresarUsuario(usuario);
        myStoreStep.ingresarPassword(password);
        screenShot();
        myStoreStep.iniciarSesion();
        screenShot();
        myStoreStep.validarInicioSesion();



    }

    @Entonces("valido que que haya iniciado sesíón")
    public void validoQueQueHayaIniciadoSesíón() {
        myStoreStep.validarInicioSesion();
    }

    @Entonces("valido que que no haya iniciado sesíón")
    public void validoQueQueNoHayaIniciadoSesíón() {
        myStoreStep.validarNoInicioSesion();
    }

    @Cuando("me logueo con un usuario {string} y clave {string}")
    public void meLogueoConUnUsuarioYClave(String usuario, String password) {
        myStoreStep = new MyStoreStep(driver);
        myStoreStep.buscarIniciarSesion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textoTitulo = driver.findElement(LoginPage.textoTitulo);
        wait.until(ExpectedConditions.visibilityOf(textoTitulo));
        myStoreStep.ingresarUsuario(usuario);
        myStoreStep.ingresarPassword(password);
        screenShot();
        myStoreStep.iniciarSesion();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        myStoreStep = new MyStoreStep(driver);
        myStoreStep.eleccionCategoriaSubcategoria(categoria,subcategoria);
    }

    @Y("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) throws InterruptedException {
        myStoreStep = new MyStoreStep(driver);
        myStoreStep.elegirProducto();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtCantidad = driver.findElement(CompraPage.btnAgregar);
        wait.until(ExpectedConditions.visibilityOf(txtCantidad));
        myStoreStep.agregarCarrito(cantidad);

    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {

        myStoreStep.validarAgregarProducto();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {

        myStoreStep.finalizarCompra();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {

        myStoreStep.validarFinalizarCompra();
    }
}


