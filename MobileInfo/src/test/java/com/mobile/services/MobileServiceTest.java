package com.mobile.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mobile.entities.Hardware;
import com.mobile.entities.Mobile;
import com.mobile.entities.Release;
import com.mobile.repositories.MobileRepository;

@SpringBootTest
class MobileServiceTest {
	
	@Autowired
	private MobileService mobileService;
	
	@MockBean
	private MobileRepository mobileRepository;

	@Test
	void test() {
		Hardware hardware = new Hardware();
		hardware.setHardwareId(14);
		hardware.setAudioJack("No");
		hardware.setGps("Yes with A-GPS");
		hardware.setBattery("Li-Ion 279 mAh battery (1.07 Wh) - 38mm version");
		
		Release release= new Release();
		release.setReleaseId(14);
		release.setAnnounceDate("2017 September");
		release.setPriceEur("480");
		
		Mobile mobile= new Mobile();
		mobile.setId(20504);
		mobile.setBrand("Apple");
		mobile.setPhone("Apple Watch Series 3 Aluminum");
		mobile.setPicture("https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series3-sport-.jpg");
		mobile.setSim("eSIM");
		mobile.setResolution("390 x 312 pixels");		
		mobile.setRelease(release);
		mobile.setHardware(hardware);
		
		List<Mobile> mockMobileList = new ArrayList<Mobile>();
		mockMobileList.add(mobile);
		
		Map<String, String> mobileParams = new HashMap<>();
		Map<String, String> hardwareParams = new HashMap<>();
		Map<String, String> releaseParams = new HashMap<>();
		
		mobileParams.put("id", "20504");
		mobileParams.put("brand", "Apple");
		
		hardwareParams.put("gps", "Yes with A-GPS");
		
		releaseParams.put("priceEur", "480");
		
		Mockito.when(mobileRepository.findMobiles(mobileParams, hardwareParams, releaseParams)).thenReturn(mockMobileList);
	
		assertThat(mobileService.findMobiles(mobileParams, hardwareParams, releaseParams)).isEqualTo(mockMobileList);
	}

}
