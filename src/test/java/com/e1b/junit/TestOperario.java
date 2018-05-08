package com.e1b.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.e1b.entities.Operario;

public class TestOperario {

	private Operario operario1, operario2, operario99;
	
	@Before
	public void initialize(){
		operario1= new Operario("o1", "123456");
		operario2= new Operario("o2", "1234");
		operario99=new Operario();
	}
	
	@Test
	public void testOperario() {
		//Comprobamos que el usuario se crea correctamente
		Operario operario3= new Operario("o3", "66666");
		assertEquals(operario3.getUsername(), "o3");
		assertEquals(operario3.getPassword(), "66666");
	}
	
	@Test
	public void testGetUsername() {
		//Pruebas positivas
		assertEquals(operario1.getUsername(), "o1");
		assertEquals(operario2.getUsername(), "o2");
		//Pruebas negativas
		assertEquals(operario99.getUsername(), null);
	}

	@Test
	public void testSetUsername() {
		operario1.setUsername("o11");
		assertEquals(operario1.getUsername(), "o11");
		operario2.setUsername("o22");
		assertEquals(operario2.getUsername(), "o22");
	}

	@Test
	public void testGetPassword() {
		//Pruebas positivas
		assertEquals(operario1.getPassword(), "123456");
		assertEquals(operario2.getPassword(), "1234");
		//Pruebas negativas
		assertEquals(operario99.getPassword(), null);
	}

	@Test
	public void testSetPassword() {
		operario1.setPassword("654321");
		assertEquals(operario1.getPassword(), "654321");
		operario2.setPassword("4321");
		assertEquals(operario2.getPassword(), "4321");
	}


}
