package com.nttdata.stepsdefinitions;

import com.nttdata.page.LoginPage;
import com.nttdata.steps.LoginStep;
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

public class LoginStepDef {
    private WebDriver driver;
    LoginStep loginStep;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");

        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String password) {

        loginStep = new LoginStep(driver);
        loginStep.buscarIniciarSesion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textoTitulo = driver.findElement(LoginPage.textoTitulo);
        wait.until(ExpectedConditions.visibilityOf(textoTitulo));
        loginStep.ingresarUsuario(usuario);
        loginStep.ingresarPassword(password);
        screenShot();
        loginStep.iniciarSesion();
        screenShot();
        loginStep.validarInicioSesion();



    }

    @Entonces("valido que que haya iniciado sesíón")
    public void validoQueQueHayaIniciadoSesíón() {
        loginStep.validarInicioSesion();
    }

    @Entonces("valido que que no haya iniciado sesíón")
    public void validoQueQueNoHayaIniciadoSesíón() {
        loginStep.validarNoInicioSesion();
    }

    @Cuando("me logueo con un usuario {string} y clave {string}")
    public void meLogueoConUnUsuarioYClave(String usuario, String password) {
        loginStep = new LoginStep(driver);
        loginStep.buscarIniciarSesion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textoTitulo = driver.findElement(LoginPage.textoTitulo);
        wait.until(ExpectedConditions.visibilityOf(textoTitulo));
        loginStep.ingresarUsuario(usuario);
        loginStep.ingresarPassword(password);
        screenShot();
        loginStep.iniciarSesion();
        screenShot();
    }
}
