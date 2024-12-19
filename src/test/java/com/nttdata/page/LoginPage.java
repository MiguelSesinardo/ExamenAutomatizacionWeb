package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    public static By IniciarSesion = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
    public static By usuario = By.xpath("//*[@id=\"field-email\"]");
    public static By pass = By.xpath("//*[@id=\"field-password\"]");
    public static By btnIniciarSesion = By.xpath("//*[@id=\"submit-login\"]");
    public static By textoTitulo = By.xpath("//*[@id=\"main\"]/header/h1");
    public static By nombre = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span");
    public static By errorMensaje = By.xpath("//li[contains(text(),'Error de autenticación.')]");
}
