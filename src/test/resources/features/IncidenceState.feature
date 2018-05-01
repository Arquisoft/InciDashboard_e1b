Feature: Change the state of an incidence
	The operator sees the table of incidences that he has asigned
Scenario: States
    Given a operator with username "O1" 
    When he changes the state of a incidence <incidence>  
    Then he changes the state <state>
    Given a list of Incidences:
      | incidence	| state  					 	 |
      | i			| EN_PROCESO       			 	 |
      | i1			| CERRADA    				 	 |
      | i2			| ANULADA			      		 |
