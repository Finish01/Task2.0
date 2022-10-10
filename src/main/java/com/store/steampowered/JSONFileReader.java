package com.store.steampowered;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReader{
	
	private final static String FILEPATH = "./testData.json";
	
	public static List<String> getJSONConfigData(){
		
		JSONParser parser = new JSONParser();
		List<String> actualLanguages = new ArrayList<String>();
		
		try {
			Object obj = parser.parse(new FileReader(FILEPATH));
			JSONObject jsonObject = (JSONObject) obj; 
			
			JSONArray array = (JSONArray)jsonObject.get("languages");
			
			for(int i=0; i<array.size(); i++) {
				String language = (String) array.get(i);
				actualLanguages.add(language); 
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actualLanguages;
		
	
		
	} 
	
}
