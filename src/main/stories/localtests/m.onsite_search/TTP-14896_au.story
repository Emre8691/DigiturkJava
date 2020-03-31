!-- ----------------
!-- TTP-14896 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V4
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS australia
Given is 'D2C' website for brand 'SIEMENS' and country 'australia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14896 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V4
Scenario: TTP-14896 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V4
GivenStories: localtests/m.onsite_search/steps/TTP-14896.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
