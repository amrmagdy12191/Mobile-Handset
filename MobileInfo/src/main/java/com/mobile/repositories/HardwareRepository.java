package com.mobile.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.entities.Hardware;

@Repository
public interface HardwareRepository extends CrudRepository<Hardware, Integer> {

}
