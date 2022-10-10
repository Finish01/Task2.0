package com.store.steampowered;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {
	
	public static WebDriver driver;
	
	public static void Driver() {
		
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Finish\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://store.steampowered.com/");
	}
	
	public static void quit() {
		driver.quit();
	}
}

