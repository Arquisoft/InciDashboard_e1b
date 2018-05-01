Feature: Change the state of an incidence
	The operator sees the table of incidences that he has asigned
Scenario: States
    Given a operator with username "O1" 
    When he watch the state of an incidence <incidence>  
    Then it is <state>
    Examples:
      | incidence	| state  					 	 |
      | i			| EN_PROCESO       			 	 |
      | i1			| CERRADA    				 	 |
      | i2			| ANULADA			      		 |
