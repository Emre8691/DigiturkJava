!-- ----------------
!-- TTP-14894 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V2
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'D2C' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14894 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V2
Scenario: TTP-14894 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V2
GivenStories: migration/TTP-625/steps/TTP-14894.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
