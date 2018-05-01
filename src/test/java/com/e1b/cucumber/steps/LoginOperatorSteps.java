package com.e1b.cucumber.steps;

import cucumber.api.java.en.*;
import java.util.List;
import static org.junit.Assert.assertTrue;

import com.e1b.entities.Operario;

public class LoginOperatorSteps {
	
	private Operario operario;
	
	@Given("^a list of users:$")
	public void a_list_of_users(List<Operario> operarios) throws Throwable {
		for (Operario o : operarios){
			if (o.getUsername().equals("o1"))
				assertTrue(o.getPassword().equals("123456"));
			else if(o.getUsername().equals("o2"))
				assertTrue(o.getPassword().equals("123456"));
		}
	}
	
	@When("^I login with name \"(.+)\" and password \"(.+)\"$")
	public void i_login_with_name_and_password(String name, String contrasena) throws Throwable {
//		for (Operario o : operarios){
//			// donde encontrar listado usuarios
//			if(o.getUsername().equals(name) && o.getPassword().equals(name))
//				operario=o;
//		}
//		System.out.println("Login as " + name);
		
	}

	@Then("^receives the list of incidence of the user")
	public void receives_the_list_of_incidence_of_the_user() throws Throwable {
//		operario.getIncidencias().size();
	}

}