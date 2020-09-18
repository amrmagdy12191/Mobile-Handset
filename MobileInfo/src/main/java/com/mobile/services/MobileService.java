package com.mobile.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.mobile.clients.ClientsFactory;
import com.mobile.entities.Mobile;
import com.mobile.repositories.MobileRepository;
import com.mobile.repositories.MobileRepositoryCustom;
import com.mobile.repositories.MobileRepositoryCustomImpl;
import com.mobile.utils.Constants;
import com.mobile.utils.Utils;

@Service
public class MobileService {
	
	@Autowired
	MobileRepository mobileRepository;
	
	public List<Mobile>getAllMobiles() {
		// TODO
		return null;
	}
	
	public void addMobile(Mobile mobile) {
		mobileRepository.save(mobile);
	}
	
	public Mobile editMobile(Mobile mobile) {
		// TODO
		return null;
	}
	
	public void deleteMobile(Mobile mobile) {
		// TODO
	}
	
	public List<Mobile> findMobiles(Map<String, String> params, Map<String, String> hardwareParams, Map<String, String> releaseParams){
		return mobileRepository.findMobiles(params, hardwareParams, releaseParams);
	}
	
	@Transactional
	public String LoadAllMobiles() throws Exception {
		String mobilesHandset = ClientsFactory.getMobileHandset(Constants.HTTP_GET, null, null);
		Mobile[] mobiles= null;
		if(mobilesHandset != null & !mobilesHandset.isEmpty()) {
			mobiles = Utils.convertStringToObject(mobilesHandset, Mobile[].class);
		}
		
		if(mobiles != null) {
			for(Mobile mobile:mobiles) {
				addMobile(mobile);
			}
		}
		
		return "success";
	}

}
