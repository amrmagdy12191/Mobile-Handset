package com.mobile.clients;

import java.util.Map;
import java.util.Optional;

import javax.ws.rs.core.MediaType;

import com.mobile.entities.Mobile;
import com.mobile.utils.Constants;
import com.mobile.utils.JerseyUtil;
import com.mobile.utils.Utils;

public class ClientsFactory {
	
	static String params = "";
	

	public static String getMobileHandset(String methodType,  String data, Map<String,String> pathParams) throws Exception {
		// Entity.entity(emp, MediaType.APPLICATION_JSON)
	//	JerseyUtil.get(Constants.MOBILE_HANDSET_URL, path, MediaType.APPLICATION_JSON);
		
		String url = Constants.MOBILE_HANDSET_URL + "?";
		if(pathParams != null && pathParams.isEmpty()) {
			params = "";
			pathParams.forEach((k,v)->params=params+ k +"="+ v + "&");			
			url = Constants.MOBILE_HANDSET_URL + params;
			
		}
		String response = JerseyUtil.process(url.substring(0, url.length()-1), data, methodType, MediaType.APPLICATION_JSON, 0, null);
		
		
		return response;
	}
	
	

}
