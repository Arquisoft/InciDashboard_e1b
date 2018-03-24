package com.e1b.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Operario {

	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "operario", cascade = CascadeType.ALL)
	private Set<Incidencia> incidencias;
	
	public Operario() {}

	public Operario(String username, String password) {
		super();
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Operario [id=" + id + ", username=" + username + ", password=" + password + ", incidencias="
				+ incidencias + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operario other = (Operario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
