package com.e1b.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.e1b.entities.utils.Status;

@Entity
public class Incidencia {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String description;
	private Date expirationgDate;
	private Status status;
	private String location;
	
	@ManyToOne
	private Operario operario;
	
	public Incidencia() {}

	public Incidencia(String name, String description, Date expirationgDate, Status status, String location,
			Operario operario) {
		super();
		setName(name);
		setDescription(description);
		setExpirationgDate(expirationgDate);
		setStatus(status);
		setLocation(location);
		this.operario = operario;
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpirationgDate() {
		return expirationgDate;
	}

	public void setExpirationgDate(Date expirationgDate) {
		this.expirationgDate = expirationgDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Incidencia other = (Incidencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", name=" + name + ", description=" + description + ", expirationgDate="
				+ expirationgDate + ", status=" + status + ", location=" + location + ", operario=" + operario + "]";
	}
	
	
	
}
