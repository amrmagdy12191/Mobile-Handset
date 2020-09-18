package com.mobile.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "hardware")
public class Hardware implements Serializable {

	@Id
	@Column(name = "hardware_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hardwareId;

	@Column(name = "audio_jack")
	private String audioJack;

	@Column(name = "gps")
	private String gps;

	@Column(name = "battery")
	private String battery;
	

	public String getAudioJack() {
		return audioJack;
	}

	public void setAudioJack(String audioJack) {
		this.audioJack = audioJack;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public Integer getHardwareId() {
		return hardwareId;
	}

	public void setHardwareId(Integer hardwareId) {
		this.hardwareId = hardwareId;
	}


}
