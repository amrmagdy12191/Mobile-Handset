package com.mobile.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.entities.Mobile;

public interface MobileRepositoryCustom {
	
	public List<Mobile> findMobiles(Map<String, String> params, Map<String, String> hardwareParams, Map<String, String> releaseParams);

}
