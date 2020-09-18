package com.mobile.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.entities.Mobile;

@Repository
public interface MobileRepository extends CrudRepository<Mobile, Integer>, MobileRepositoryCustom {

}
