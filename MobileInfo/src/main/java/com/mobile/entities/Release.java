package com.mobile.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mobile.utils.CustomJsonDateDeserializer;

@Entity
@Table(name = "Release_table")
public class Release implements Serializable {
	
	@Id
	@Column(name = "release_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer releaseId;

	@Column(name = "announce_date")
	private String announceDate;

	@Column(name = "price_eur")
	private String priceEur;


	public Integer getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(Integer releaseId) {
		this.releaseId = releaseId;
	}


	public String getAnnounceDate() {
		return announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}

	public String getPriceEur() {
		return priceEur;
	}

	public void setPriceEur(String priceEur) {
		this.priceEur = priceEur;
	}

}
