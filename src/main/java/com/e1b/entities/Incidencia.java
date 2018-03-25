package com.e1b.entities;

public class Incidencia {
	
	private Operario operario;
	private String name;
	private double lat;
	private double lng;
	
	public Incidencia() {}

	public Incidencia(String name, double lat, double lng) {
		this.setName(name);
		this.setLat(lat);
		this.setLng(lng);
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

}
