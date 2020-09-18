package com.mobile.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.entities.Hardware;
import com.mobile.entities.Mobile;
import com.mobile.entities.Release;

@SpringBootTest
class MobileRepositoryCustomImplTest {

	
	@Autowired
	MobileRepository mobileRepository;
	
	@Test
	void test() {
		Hardware hardware = new Hardware();
		hardware.setAudioJack("No");
		hardware.setGps("Yes with A-GPS Test");
		hardware.setBattery("Li-Ion 279 mAh battery (1.07 Wh) - 38mm version");
		
		Release release= new Release();
		release.setAnnounceDate("2017 September");
		release.setPriceEur("4800");
		
		Mobile mobile= new Mobile();
		mobile.setId(31558);
		mobile.setBrand("Apple");
		mobile.setPhone("Apple Watch Series 3 Aluminum Test");
		mobile.setPicture("https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series3-sport-.jpg");
		mobile.setSim("eSIM");
		mobile.setResolution("390 x 312 pixels");		
		mobile.setRelease(release);
		mobile.setHardware(hardware);

		mobileRepository.save(mobile);
		
		Mobile mobileFromInDb = mobileRepository.findById(mobile.getId()).get();
		
		mobile.getHardware().setHardwareId(mobileFromInDb.getHardware().getHardwareId());
		mobile.getRelease().setReleaseId(mobile.getRelease().getReleaseId());
		assertThat(mobile.getId()).isEqualTo(mobileFromInDb.getId());
	}

}
