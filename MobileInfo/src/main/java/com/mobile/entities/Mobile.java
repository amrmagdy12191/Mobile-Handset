package com.mobile.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mobile")
public class Mobile implements Serializable {
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="picture")
	private String picture;
	
	@Column(name="sim")
	private String sim;
	
	@Column(name="resolution")
	private String resolution;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="hardware_id")
	private Hardware hardware;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "release_id")
	private Release release;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Hardware getHardware() {
		return hardware;
	}

	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}
	

}
