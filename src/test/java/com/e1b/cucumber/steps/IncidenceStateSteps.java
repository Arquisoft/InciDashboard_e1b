package com.e1b.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.junit.Assert;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.e1b.InciDashboardApplication;
import com.e1b.entities.Incidence;
import com.e1b.entities.Operario;
import com.e1b.services.OperariosService;

	
	@ContextConfiguration(classes = InciDashboardApplication.class, loader = SpringApplicationContextLoader.class)
	@ActiveProfiles("INTEGRATION_TEST")
	@WebAppConfiguration
	public class IncidenceStateSteps {

		@Autowired
		OperariosService operatorsService;

		private Operario operario;
		private Incidence incidence;

		@Given("^a operator with username \"([^\"]*)\"$")
		public void a_operator_with_username(String username) throws Throwable {
			operario = operatorsService.findByUsername(username);
		}

		@When("^he watch the state of an incidence \"([^\"]*)\"$")
		public void he_watch_the_state_of_an_incidence(String name) throws Throwable {
			for (Incidence i : operario.getIncidencias()) {
				if (i.getName().equals(name)) {
					incidence = i;
					break;
				}
			}
		}

		@Then("^it is \"([^\"]*)\"$")
		public void it_is(String estado) throws Throwable {
			if(estado.toLowerCase().equals("en_proceso")){
				assertTrue(incidence.getName().equals("i"));
				assertTrue(incidence.getState().toLowerCase().equals("en_proceso"));
			}
			else if(estado.toLowerCase().equals("cerrada")){
				assertTrue(incidence.getName().equals("i"));
				assertTrue(incidence.getState().toLowerCase().equals("cerrada"));
			}
			else if(estado.toLowerCase().equals("anulada")){
				assertTrue(incidence.getName().equals("i"));
				assertTrue(incidence.getState().toLowerCase().equals("anulada"));
			}
		}

	}
