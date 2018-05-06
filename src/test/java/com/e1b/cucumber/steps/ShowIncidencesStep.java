package com.e1b.cucumber.steps;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.e1b.InciDashboardApplication;
import com.e1b.entities.Incidence;
import com.e1b.entities.Operario;
import com.e1b.services.InciService;
import com.e1b.services.OperariosService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
@SuppressWarnings("deprecation")
@ContextConfiguration(classes=InciDashboardApplication.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class ShowIncidencesStep {
	@Autowired
	OperariosService operatorsService;
	@Autowired
	InciService  inciService;
	
	Incidence  incidencia;
	
	Operario oper;
	@Given("^a operator$")
	public void a_operator() throws Throwable {
		oper = operatorsService.findByUsername("o1");
	    Assert.assertNotNull(operatorsService.findByUsername("o1"));
	}

	@When("^he wants to show his incidences$")
	public void he_wants_to_show_his_incidences() throws Throwable {
		incidencia = inciService.findIncidencesByOperario(oper.getUsername()).get(0);
	    Assert.assertTrue(inciService.findIncidencesByOperario(oper.getUsername()).size()>0);
	}

	@Then("^the system will give his incidences <incidencias>$")
	public void the_system_will_give_his_incidences_incidencias() throws Throwable {	    
		Assert.assertEquals("Nueva lectura de humedad", incidencia.getDescription());
	}


}
