package com.e1b.incidashboard.steps;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.e1b.InciDashboardApplication;;

@ContextConfiguration(classes = InciDashboardApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
@ActiveProfiles("INTEGRATION_TEST")

public class IncidenceStateSteps {

}
