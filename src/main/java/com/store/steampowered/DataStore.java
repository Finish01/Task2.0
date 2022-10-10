package com.store.steampowered;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class DataStore {
	
	private static JSONObject jsonObject;

	public static JSONObject getJsonObject() {
		return jsonObject;
	}

	public static void setJsonObject(JSONObject jsonObject) {
		DataStore.jsonObject = jsonObject; 
	} 
	
	public static JSONObject getJsonObject(String key) {
		return (JSONObject) jsonObject.get(key);
	}

	public static JSONObject getEnvironmentInfo(String envkey) {
		return (JSONObject) ((HashMap) jsonObject.get("environment")).get(envkey);
	}
	
}
