package com.e1b.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import com.e1b.entities.Incidence;
import com.e1b.entities.Operario;

public class TestIncidence {
	
	private Map<String, String> propiedades;
	private List<String> tags;
	private Operario operario1;
	private Incidence incidencia;
	private ObjectId id;
	
	@Before
	public void initialize(){
		id= new ObjectId();
		operario1= new Operario("o11", "1234");
		tags= new ArrayList<String>();
		tags.add("etiqueta de prueba");
		tags.add("etiqueta de pruebas 2");
		propiedades=new HashMap<String, String>();
		propiedades.put("1", "propiedad1");
		propiedades.put("2", "propiedad2");
		propiedades.put("3", "propiedad3");
		
	}

	@Test
	public void testIncidence() {
		incidencia = new Incidence(operario1, "o1", "123456", "inci1", "incidencia de ejemplo para realizar pruebas", "47",
				tags, "información adicional", propiedades, "Abierta",
				"si", "2018/11/02", "o1");
		assertEquals(incidencia.getName(), "inci1");
		assertEquals(incidencia.getDescription(), "incidencia de ejemplo para realizar pruebas");
		assertEquals(incidencia.getLocation(), "47");
		assertEquals(incidencia.getTags(), tags);
		assertEquals(incidencia.getAdditionalInformation(), "información adicional");
		assertEquals(incidencia.getProperties(), propiedades);
		assertEquals(incidencia.getState(), "Abierta");
		assertEquals(incidencia.getNotification(), "si");
		assertEquals(incidencia.getExpireAt(), "2018/11/02");
		assertEquals(incidencia.getAssignedTo(), "o1");

	}
	
	@Test
	public void testGetId() {
		incidencia = new Incidence(operario1, "o1", "123456", "inci1", "incidencia de ejemplo para realizar pruebas", "47",
				tags, "información adicional", propiedades, "Abierta",
				"si", "2018/11/02", "o1");
		incidencia.set_id(id);
		assertEquals(incidencia.get_id(), id);
	}



}
