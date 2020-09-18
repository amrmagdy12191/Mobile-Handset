package com.mobile.utils;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JerseyUtil {
	
	private static String CONNECT_TIMEOUT="CONNECT_TIMEOUT";
	private static String READ_TIMEOUT="READ_TIMEOUT";
	

	public static String process(String url, String data, String methodType, String mediaType,
			int timeout, Map<String, String> header) throws Exception {
		
		Client client = ClientBuilder.newClient();
		
		if(timeout != 0) {
			client.property(CONNECT_TIMEOUT, timeout);
			client.property(READ_TIMEOUT, timeout);
		}
		
		Response response = null;
		WebTarget webTarget = client.target(url);
		Invocation.Builder invocationBuilder = webTarget.request(mediaType);
		if(header != null) {
			for (Map.Entry<String, String> entry : header.entrySet()) {
				invocationBuilder = invocationBuilder.header(entry.getKey(), entry.getValue());
			}
		}
		

		if (Constants.HTTP_GET.equals(methodType)) {
			response = invocationBuilder.get();
		} else if (Constants.HTTP_POST.equals(methodType)) {
			response = invocationBuilder.post(Entity.entity(data, mediaType));
		} else if (Constants.HTTP_PUT.equals(methodType)) {
			response = invocationBuilder.put(Entity.entity(data, mediaType));
		} else {
			return "";
		}

		String message = "";
		if (response.getStatus() == 200 || response.getStatus() == 201 || response.getStatus() == 204) {
			message = response.readEntity(String.class);
		}

		return message;
	}


//	public static String get(String url, String path, String mediaType) {
//		Client client = ClientBuilder.newClient();
//
//		return (String) client.target(url).path(path).request(mediaType).get(String.class);
//
//	}
//
//	public static Response post(String url, String mediaType, Entity entity) {
//		Client client = ClientBuilder.newClient();
//
//		return client.target(url).request(mediaType).post(entity);
//
//	}
//
//	public static Response put(String url, String mediaType, Entity entity) {
//		Client client = ClientBuilder.newClient();
//
//		return client.target(url).request(mediaType).put(entity);
//
//	}
//
//	public static String delete(String url, String path, String mediaType) {
//		Client client = ClientBuilder.newClient();
//
//		return (String) client.target(url).path(path).request(mediaType).delete(String.class);
//
//	}

}
