package com.e1b.entities;

import java.util.Set;

public class Operario {
	
	private String username;
	private String password;
	
	private Set<Incidencia> incidencias;
	
	public Operario() {}

	public Operario(String username, String password) {
		this.username=username;
		this.password=password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}
	
	

}
