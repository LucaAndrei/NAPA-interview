package com.andreiluca.app.model;

import javax.persistence.*;

@Entity
public class Ship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column
	private String ship_class;
	@Column
	private int gross_tonnage;
	@Column
	private int tonnage;
	@Column
	private float length;
	@Column
	private float width;
	@Column
	private float constructionYear;
	@Column
	private boolean isActive;
	@Column
	private String country;
	@Column
	private float latitude;
	@Column
	private float longitude;
	
	public Ship(String name, String ship_class, int gross_tonnage, int tonnage, float length, 
			float width, float constructionYear, boolean isActive, String country, float latitude,
			float longitude) {
		super();
		this.name = name;
		this.ship_class = ship_class;
		this.gross_tonnage = gross_tonnage;
		this.tonnage = tonnage;
		this.length = length;
		this.width = width;
		this.constructionYear = constructionYear;
		this.isActive = isActive;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public Ship() {
		super();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShipClass() {
		return ship_class;
	}
	public void setShipClass(String shipClass) {
		this.ship_class = shipClass;
	}
	public int getGrossTonnage() {
		return gross_tonnage;
	}
	public void setGrossTonnage(int grossTonnage) {
		this.gross_tonnage = grossTonnage;
	}
	public int getTonnage() {
		return tonnage;
	}
	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getConstructionYear() {
		return constructionYear;
	}
	public void setConstructionYear(float constructionYear) {
		this.constructionYear = constructionYear;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}



}
