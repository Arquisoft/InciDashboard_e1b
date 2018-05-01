Feature: kafka message
  Scenario: client sends a message to kafka stream
    When the producer sends Incidence to the topic "incidences"
    Then the consumer receives Incidence from the topic "incidences"