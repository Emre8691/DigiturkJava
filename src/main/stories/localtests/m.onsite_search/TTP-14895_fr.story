!-- ----------------
!-- TTP-14895 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V3
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'D2C' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14895 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V3
Scenario: TTP-14895 - (DS) Customer Service ND - Customer Service - Service Assistant SER2 - V3
GivenStories: localtests/m.onsite_search/steps/TTP-14895.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
