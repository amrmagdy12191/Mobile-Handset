package com.mobile.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mobile.utils.SearchParams;

public class MobileHansetValidator {
	
	public static List<String>  vaidateRequestParams(Map<String, String> params) {
		boolean exist = false;
		List<String> badParams = new ArrayList<String>();
		for (Entry<String, String> param : params.entrySet()) {
			exist = false;
			for (SearchParams searchParam : SearchParams.values()) {
		        if (searchParam.name().equals(param.getKey())) {
		        	exist = true;
		        }
		    }
			
			if(!exist) {
				badParams.add(param.getKey());
			}
			
		}
		return badParams;
	}
}
