!-- ----------------
!-- TTP-288 - Automatic: Customer Service: Spare Parts
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-288 - Automatic: Customer Service: Spare Parts
Scenario: TTP-288 - Automatic: Customer Service: Spare Parts
GivenStories: localtests/customer_service/steps/TTP-288.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
