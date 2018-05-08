package com.e1b.cucumber;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MainControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testLanding() throws Exception {
    mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(containsString("Panel de Control InciDashBoard")));
  }
  
  @Test
  public void testControllers() throws Exception {
	  mvc.perform(get("/home")).andExpect(status().isOk()).andExpect(content().string(containsString("Bienvenido a tu pagina personal")));
	  mvc.perform(get("/login")).andExpect(status().isOk()).andExpect(content().string(containsString("Identificate")));
	  mvc.perform(get("/map")).andExpect(status().isOk()).andExpect(content().string(containsString("googleMap")));
	  mvc.perform(get("/notifications/list")).andExpect(status().isOk()).andExpect(content().string(containsString("Notificaciones actuales:")));
	  mvc.perform(get("/incidencias/list")).andExpect(status().isOk()).andExpect(content().string(containsString("se muestran todas las incidencias registradas en el sistema")));
	  mvc.perform(get("/incidencias/estado/a")).andExpect(status().is4xxClientError());
	  mvc.perform(get("/incidencias/statistics")).andExpect(status().isOk()).andExpect(content().string(containsString("<canvas")));
	  mvc.perform(get("/incidencias/kafka-messages")).andExpect(status().isOk());
  }
}