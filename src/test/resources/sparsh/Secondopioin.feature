
@Start
Feature: Second Opinion

  @MainProcess
  Scenario: Validate the working of Opinion functionality
  
    Given Open Browser and Enter Sparsh Url
    
    When  Click on Hospital and Select the Yeshwantpur Hospital Dropdown
    
    And Select the Second Opinion 
    
    And Enters the firstname, lastname, phonenumber,emailid
    
    And Upload the report and Enter the Message and click the send button
    
    Then Thank you should have in displayed
    
    And Bank info should have been displayed
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
   # Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step

    #Examples: 
     # | name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
