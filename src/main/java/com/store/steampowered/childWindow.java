package com.store.steampowered;

import java.util.Iterator;
import java.util.Set;

public class childWindow {
	
	public String childWindowMethod() {
		
		PrivacyPolicy policy = new PrivacyPolicy(Singleton.driver);
		policy.clickToPolicy();
		
		Set<String> windows = Singleton.driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		
		String childWindow = null;
		
		while(window.hasNext())
		{

			String child_window= window.next();

			if(!Singleton.driver.getWindowHandle().equals(child_window))
			{
				childWindow = child_window;
			}
		}
		return childWindow;
	}
}