package com.e1b.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Notification 
{

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Incidencia incidence;
	
	
	public Notification()
	{}
	
	public Notification(Incidencia incidence)
	{
		setIncidence(incidence);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Incidencia getIncidence() {
		return incidence;
	}

	public void setIncidence(Incidencia incidence) {
		this.incidence = incidence;
	}
	
	
}
