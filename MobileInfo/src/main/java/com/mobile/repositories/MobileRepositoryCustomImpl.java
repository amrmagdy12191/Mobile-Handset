package com.mobile.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.springframework.stereotype.Repository;

import com.mobile.entities.Hardware;
import com.mobile.entities.Mobile;
import com.mobile.entities.Release;
import com.mobile.utils.SearchParams;

@Repository
public class MobileRepositoryCustomImpl implements MobileRepositoryCustom {

	private EntityManager em;
	
	public MobileRepositoryCustomImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Mobile> findMobiles(Map<String, String> params, Map<String, String> hardwareParams, Map<String, String> releaseParams) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Mobile> query = builder.createQuery(Mobile.class);
		Root<Mobile> mobile = query.from(Mobile.class);
				
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				if("id".equals(entry.getKey())) {
					predicates.add(builder.equal(mobile.get(entry.getKey()), Long.parseLong(entry.getValue())));
				}else {
					predicates.add(builder.like(mobile.get(entry.getKey()), entry.getValue()));
				}
				
			}
		}
		
		if(releaseParams != null && !releaseParams.isEmpty()) {
			Join<Mobile, Release> releaseJoin= mobile.join("release", JoinType.LEFT);	
			for (Map.Entry<String, String> entry : releaseParams.entrySet()) {
				predicates.add(builder.equal(releaseJoin.get(entry.getKey()), builder.parameter(String.class, entry.getKey())));
			}
		}
		
		if(hardwareParams != null && !hardwareParams.isEmpty()) {
			Join<Mobile, Release> hardwareJoin= mobile.join("hardware", JoinType.LEFT);	
			for (Map.Entry<String, String> entry : hardwareParams.entrySet()) {
				predicates.add(builder.equal(hardwareJoin.get(entry.getKey()), builder.parameter(String.class, entry.getKey())));
			}
		}
			
		
		query.select(mobile)
		 .where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		 
		 
		
		TypedQuery<Mobile> typedQuery =  em.createQuery(query);
		 if(hardwareParams != null && !hardwareParams.isEmpty()) {
			 for (Map.Entry<String, String> entry : hardwareParams.entrySet()) {
				 typedQuery.setParameter(entry.getKey(), entry.getValue());
			 }			 
		 }
		 
		 if(releaseParams != null && !releaseParams.isEmpty()) {
			 for (Map.Entry<String, String> entry : releaseParams.entrySet()) {
				 typedQuery.setParameter(entry.getKey(), entry.getValue());
			 }			 
		 }
		 
         return typedQuery.getResultList();
	}
	

}
