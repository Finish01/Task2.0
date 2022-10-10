package selenium.demo;

import java.util.List;

import org.junit.Assert; 

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.store.steampowered.GetLanguages;
import com.store.steampowered.GetYear;
import com.store.steampowered.JSONFileReader;
import com.store.steampowered.Singleton;
import com.store.steampowered.childWindow;

public class Demo {
	
	@BeforeClass
	public static void launchBrowser() throws InterruptedException {
		Singleton.Driver();
	}
	
	@Test 
	public void verifyAccessToMainPage() throws InterruptedException {
		String expectedTitle = "Добро пожаловать в Steam";
		String actualTitle = Singleton.driver.getTitle();
		Assert.assertEquals("Main page is not displayed",expectedTitle, actualTitle); 
	}
	
	@Test 
	public void verifyAccessToPolicyPage() throws InterruptedException {
		
		childWindow window = new childWindow();
		String childWindow = window.childWindowMethod();
		
		String expectedTitle = "Соглашение политики конфиденциальности";
		String actualTitle = Singleton.driver.switchTo().window(childWindow).getTitle();
		
		Assert.assertEquals("Privacy page is not displayed!", expectedTitle, actualTitle);
	}

	@Test
	public void verifyLanguages() {

		GetLanguages classLanguages = new GetLanguages();
		List<String> languagesToString = classLanguages.listOfLanguages(); 
		
		JSONFileReader reader = new JSONFileReader();
		List<String> expectedLanguages = reader.getJSONConfigData();
		
		
		Assert.assertEquals("Lists didn't match", expectedLanguages, languagesToString);
	}
	
	@Test
	public void verifyYear() {
		GetYear year = new GetYear();
		String actualYear = year.currentYear();
		
		String expectedYear = "2022";

		Assert.assertEquals("They are not equal", expectedYear, actualYear);
	}
	
	@Test
	public void verifyData() {
		JSONFileReader reader = new JSONFileReader();
		List<String> languages = reader.getJSONConfigData();
		
		for(int i=0; i<languages.size(); i++) {
			System.out.println((String)languages.get(i));
		}
	}
	
	
	@AfterClass
	public static void closeBrowser(){
		Singleton.quit();
	}

}

