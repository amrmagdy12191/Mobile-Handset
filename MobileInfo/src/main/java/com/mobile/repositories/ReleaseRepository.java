package com.mobile.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.entities.Release;

@Repository
public interface ReleaseRepository extends CrudRepository<Release, Integer> {

}
