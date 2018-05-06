package com.e1b.cucumber.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.e1b.InciDashboardApplication;
import com.e1b.entities.Operario;
import com.e1b.services.InciService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes=InciDashboardApplication.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class LoginOperatorSteps {

	private Operario operario;
	@Autowired
	private InciService incidencesService;
	private List<Operario> op;

	@Given("^a list of users:$")
	public void a_list_of_users(List<Operario> operarios) throws Throwable {
		for (Operario o : operarios) {
			if (o.getUsername().equals("o1"))
				assertTrue(o.getPassword().equals("123456"));
			else if (o.getUsername().equals("o2"))
				assertTrue(o.getPassword().equals("123456"));
		}
		op = operarios;
	}

	@When("^I login with name \"(.+)\" and password \"(.+)\"$")
    public void i_login_with_name_and_password(String name, String contrasena) throws Throwable {
        int cont=1;
        for (Operario o : op){
            // donde encontrar listado usuarios
            if(o.getUsername().equals(name) && o.getPassword().equals(contrasena))
                operario=o;
            assertEquals("o"+cont,o.getUsername());
            cont++;
        }


    }

	@Then("^receives the list of incidence of the user")
	public void receives_the_list_of_incidence_of_the_user() throws Throwable {
		assertEquals(1, incidencesService.numberOfIncidences(operario.getUsername()));
	}

}