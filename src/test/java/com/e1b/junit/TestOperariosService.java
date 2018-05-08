package com.e1b.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.e1b.InciDashboardApplication;
import com.e1b.entities.Operario;
import com.e1b.services.OperariosService;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes=InciDashboardApplication.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class TestOperariosService {
	@Autowired
	private OperariosService operariosService;
	
	private Operario operario1, operario2, operario3, operario4;
	
	@Before
	public void initialize(){
		operario1= new Operario("o1", "123456");
		operario2= new Operario("o2", "1234");
		operario3= new Operario("o3", "123");
		operario4= new Operario("o4", "12345");
		operariosService.addOperario(operario3);
		operariosService.addOperario(operario4);
	}

	@Test
	public void testAddOperario() {
		operariosService.addOperario(operario2);
		operariosService.addOperario(operario1);
		assertEquals(operariosService.findByUsername("o2"), operario2);
		assertEquals(operariosService.findByUsername("o1"), operario1);
	}

	@Test
	public void testFindByUsername() {
		assertEquals(operariosService.findByUsername("o3"), operario3);
		assertEquals(operariosService.findByUsername("o4"), operario4);
	}


}
