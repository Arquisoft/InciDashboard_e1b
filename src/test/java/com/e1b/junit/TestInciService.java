package com.e1b.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.e1b.InciDashboardApplication;
import com.e1b.entities.Incidence;
import com.e1b.entities.Operario;
import com.e1b.services.InciService;

@ContextConfiguration(classes=InciDashboardApplication.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class TestInciService {
	@Autowired
	private InciService inciService;
	
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
		incidencia = new Incidence(operario1, "o1", "123456", "inci1", "incidencia de ejemplo para realizar pruebas", "47",
				tags, "información adicional", propiedades, "Abierta",
				"si", "2018/11/02", "o1");
		incidencia.set_id(id);
	}
	
	@Test
	public void testFindById() {
		inciService.updateIncidencia(incidencia);
		assertEquals(inciService.findById(id), incidencia);
	}
	
	@Test
	public void testAddIncidencia() {
		inciService.updateIncidencia(incidencia);
		assertEquals(inciService.numberOfIncidences("o1"), 1);
	}


	@Test
	public void testFindIncidencesByOperario() {
		inciService.updateIncidencia(incidencia);
		assertEquals(inciService.findIncidencesByOperario("o1"), incidencia);
	}

}
