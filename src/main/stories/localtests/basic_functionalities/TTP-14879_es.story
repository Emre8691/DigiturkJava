!-- ----------------
!-- TTP-14879 - (BALAY) - Basic Login 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay spain
Given is 'D2C' website for brand 'Balay' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14879 - (BALAY) - Basic Login 
Scenario: TTP-14879 - (BALAY) - Basic Login 
GivenStories: localtests/basic_functionalities/steps/TTP-14879.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
