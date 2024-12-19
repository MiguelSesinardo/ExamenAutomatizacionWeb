package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginStep {
    
    private WebDriver driver;

    public LoginStep(WebDriver driver){
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
}
