package com.nttdata.page;

import org.openqa.selenium.By;

public class CompraPage {

    public static By productoPolo = By.cssSelector("a[href*='blanco']");
    public static By cantidad = By.xpath("//i[@class='material-icons touchspin-up']");
    public static By btnAgregar = By.xpath("//button[@class='btn btn-primary add-to-cart']");
    public static By mensajeAgregar = By.id("myModalLabel");
    public static By btnFinalizarCompra = By.xpath("//*[@id=blockcart-modal]/div/div/div[2]/div/div[2]/div/div/a");
    public static By mensajeCarrito = By.xpath("//*[@id=blockcart-modal]/div/div/div[2]/div/div[2]/div/div/a/text()");
    public static By producto = By.xpath("//img[@alt='Hummingbird printed t-shirt']");


}
