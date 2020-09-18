package com.mobile.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.mobile.entities.Mobile;
import com.mobile.handler.exceptions.BusinessException;
import com.mobile.services.MobileService;
import com.mobile.utils.JerseyUtil;
import com.mobile.utils.SearchParams;
import com.mobile.utils.Utils;
import com.mobile.validators.MobileHansetValidator;

@RestController
@RequestMapping(path = "/mobile")
public class MobileController {
	
	@Autowired
	MobileService mobileService;
	
	@GetMapping(path = "/find", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Mobile>> find(@RequestParam Map<String,String> params){
		System.out.println("Params : "  + params.entrySet());
		
		if(params != null && !params.isEmpty() && !MobileHansetValidator.vaidateRequestParams(params).isEmpty()) {
			throw new BusinessException(null , "Bad Request Parameters: " + MobileHansetValidator.vaidateRequestParams(params));
		}

		Map<String, String> mobileParams = new HashMap<>();
		Map<String, String> hardwareParams = new HashMap<>();
		Map<String, String> releaseParams = new HashMap<>();		
		prepareSearchParameters(params, mobileParams, hardwareParams, releaseParams);
		
		List<Mobile> result = new ArrayList<Mobile>();
		try {
			result = mobileService.findMobiles(mobileParams, hardwareParams, releaseParams);
		//	response = Utils.convertObjectToString(result);
		}catch (Exception e) {
			throw new BusinessException(e, "Failed to find any Mobiles");
		}
		
		
		
	    return ResponseEntity.ok(result);
	    
	}
	
	private void prepareSearchParameters( Map<String,String> params, Map<String, String> mobileParams,
			Map<String, String> hardwareParams,
			Map<String, String> releaseParams) {		
		for (Map.Entry<String, String> param : params.entrySet()) {
			String key = param.getKey();
			String value =param.getValue();
			if(key.equals(SearchParams.priceEur.name()) 
					|| key.equals(SearchParams.announceDate.name())) {
				releaseParams.put(key, value);
			}else if(key.equals(SearchParams.audioJack.name()) 
					|| key.equals(SearchParams.gps.name())
					|| key.equals(SearchParams.battery.name())) {
				hardwareParams.put(key, value);
			}else {
				mobileParams.put(key, value);
			}
		}
	}
	
	@GetMapping("/load")
	public ResponseEntity loadData() {
		try {
			return ResponseEntity.ok(mobileService.LoadAllMobiles());
		} catch (Exception e) {
			throw new BusinessException(e, "Failed to laod data");
		}
	}

}
