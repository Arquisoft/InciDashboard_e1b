package com.e1b.entities;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Operario {

	@Id
	private ObjectId _id;

	private String username;
	private String password;

	private Set<Incidence> incidencias;

	public Operario() {
	}

	public Operario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	public Set<Incidence> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidence> incidencias) {
		this.incidencias = incidencias;
	}

	@Override
	public String toString() {
		return "Operario [_id=" + _id + ", username=" + username + ", password=" + password + ", incidencias="
				+ incidencias + "]";
	}
	

}
