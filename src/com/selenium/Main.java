package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // Defino la ubicación de los drivers de los navegadores
        Properties p = new Properties(System.getProperties());
        p.put("webdriver.chrome.driver","C://Selenium//Drivers//chromedriver/chromedriver.exe");
        p.put("webdriver.gecko.driver","C://Selenium//Drivers//firefoxdriver/geckodriver.exe");
        p.put("webdriver.opera.driver","C://Selenium//Drivers//operadriver/operadriver.exe");
        p.put("webdriver.edge.driver","C://Selenium//Drivers//edgedriver/msedgedriver.exe");
        System.setProperties(p);
        // Código normal
        Scanner entry = new Scanner(System.in);
        System.out.println("Ingrese el numero asociado al navegador deseado" +
                "\n1.Chrome"+
                "\n2.Firefox"+
                "\n3.Opera"+
                "\n4.Edge");
        int opt = entry.nextInt();
        WebDriver driv = null;
        switch (opt){
            case 1:
                driv = new ChromeDriver();
                break;
            case 2:
                driv = new FirefoxDriver();
                break;
            case 3:
                driv = new OperaDriver();
                break;
            case 4:
                driv = new EdgeDriver();
                break;
            default:
                System.out.println("Datos ingresados erroneos");
        }
        /*// Abrir el navegador
        driv.get("https://www.google.com");
        // Cerrar el navegador
        driv.close();*/

        /*//Encontrar la ubicación del archivo
        System.out.println(System.getProperty("user.dir"));
        String j = System.getProperty("user.dir");*/

        // COMO CONFIRMAR EL NOMBRE DE LA PÁGINA
        /*String baseUrl = "http://demo.guru99.com/test/newtours/index.php";
        String actResult = "";
        String expResult = "Welcome: Mercury Tours";

        driv.get(baseUrl);

        actResult = driv.getTitle();

        System.out.println(actResult.contentEquals(expResult)? "Prueba pasada = "+actResult : "Prueba negada = "+actResult);
        driv.close();*/

        //INGRESAR A UNA PAGINA, AGREGAR AL CARRITO Y CONFIRMAR SUBTOTAL
        String baseUrl = "http://live.demoguru99.com/index.php";
        String actResult = "";
        String expResult = "$615.00";

        driv.get(baseUrl);
        driv.manage().window().maximize();
        //Click en el link tv
        driv.findElement(By.linkText("TV")).click();
        //Click en ADD TO CART
        driv.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();
        //Obtener el valor del texto
        actResult = driv.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span")).getText();
        System.out.println(actResult.contentEquals(expResult)? "Precio = "+expResult : "Precio erroneo = "+expResult);
        driv.close();





    }
}
