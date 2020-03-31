!-- ----------------
!-- TTP-2468 - [Prod] - Check Adobe Analytics data - NO option countries - No Action
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-2468 - [Prod] - Check Adobe Analytics data - NO option countries - No Action
Scenario: TTP-2468 - [Prod] - Check Adobe Analytics data - NO option countries - No Action
GivenStories: localtests/basic_functionalities/steps/TTP-2468.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
