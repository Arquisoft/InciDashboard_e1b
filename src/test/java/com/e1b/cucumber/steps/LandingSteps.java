package com.e1b.cucumber.steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.e1b.InciDashboardApplication;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = InciDashboardApplication.class, loader = SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class LandingSteps {

	@Autowired
	protected WebApplicationContext context;

	protected MockMvc mvc;
	protected MvcResult result;

	@Value("${local.server.port}")
	protected int port;

	@When("^the client calls /$")
	public void the_client_calls() throws Throwable {
		Assert.notNull(context);
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
		result = mvc.perform(get("/")).andReturn();
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int status) throws Throwable {
		assertThat(result.getResponse().getStatus(), is(status));
	}

	@Then("^the client receives the string \"([^\"]*)\"$")
	public void the_client_receives_the_string(String str) throws Throwable {
		assertThat(result.getResponse().getContentAsString(), containsString(str));
	}

	@Then("^the client receives the html \"([^\"]*)\"$")
	public void the_client_receives_the_html(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertThat(result.getResponse().getContentAsString(), containsString("Panel de Control InciDashBoard"));
	}

}