package com.consultoriaGlobal.search;

import static org.junit.Assert.assertEquals;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
private WebDriver driver;
private WebElement element;
	
	@Before
	public void setUp() {
		System.out.println(" Este es el inicio del test !!!");
		System.out.println(" Abriendo consultoriaglobal.com");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lucas\\eclipse-workspace\\ConsultoriaGlobal\\src\\test\\resources\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.consultoriaglobal.com.ar/cgweb/?page_id=370");
	}
	@Test
	
	public void testGooglePage() {
		
		System.out.println("En este momento el formulario se va a completar");
		
		WebElement name = driver.findElement(By.xpath("//input[@name='your-name']"));
		name.sendKeys("Nombre de Prueba");
		//name.clear();
		
		WebElement email = driver.findElement(By.xpath("//input[@name='your-email']"));
		email.sendKeys("aaa@gmail.com"); 
		//email.clear();
		
		if (ValidarMail("aaagmail.com") == true) {
            System.out.println("El email es valido.");
        } else {
            System.out.println("El email NO es valido.");
        }
 
		WebElement subject = driver.findElement(By.xpath("//input[@name='your-subject']"));
		subject.sendKeys("Probando formulario");
		//subject.clear();
		
		//Pulsamos botón para logarnos
		WebElement ingreso = driver.findElement(By.xpath("//input[@value='Enviar']"));
		ingreso.click();
		
		
		System.out.println("El formulario termino de completarse");
						 
	}
	@After
	
	public void tearDown() {
		//driver.quit();
	}
	public static boolean ValidarMail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

}
