package com.mobile.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
	
	private final static Gson gson = new GsonBuilder().setDateFormat("yyyy MMMM").enableComplexMapKeySerialization().create();
	
	public static <T> T convertStringToObject(String str, Class<T> classOfT) {
		
		return gson.fromJson(str, classOfT);
	}
	
	public static <T> String convertObjectToString(T Object) {
		return gson.toJson(Object);
	}

}
