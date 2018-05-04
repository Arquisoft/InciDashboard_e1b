package com.e1b.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.e1b.entities.Incidence;
import com.e1b.entities.Operario;

public class TestIncidence {
	
	Map<String, String> propiedades;
	List<String> tags;
	Operario operario1;
	Incidence incidencia;
	
	@Before
	public void initialize(){
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
//		incidencia = new Incidence("o1", "123456", "inci1", "incidencia de ejemplo para realizar pruebas", "47",
//				tags, "información adicional", propiedades, "Abierta",
//				"si", "2018/11/02", "o1");
//		assertEquals(incidencia.getName(), "inci1");
//		assertEquals(incidencia.getDescription(), "incidencia de ejemplo para realizar pruebas");
//		assertEquals(incidencia.getLocation(), "47");
//		assertEquals(incidencia.getTags(), tags);
//		assertEquals(incidencia.getAdditionalInformation(), "información adicional");
//		assertEquals(incidencia.getProperties(), propiedades);
//		assertEquals(incidencia.getState(), "Abierta");
//		assertEquals(incidencia.getNotification(), "si");
//		assertEquals(incidencia.getExpiration(), "2018/11/02");
//		assertEquals(incidencia.getAssignedTo(), "o1");

	}
	
	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdditionalInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAdditionalInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetState() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetState() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAssignedTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTags() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTags() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProperties() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProperties() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNotification() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNotification() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOperario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOperario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSet_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExpiration() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExpiration() {
		fail("Not yet implemented");
	}

}
