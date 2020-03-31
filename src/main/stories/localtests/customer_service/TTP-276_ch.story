!-- ----------------
!-- TTP-276 - Automatic: Customer Service : Accessories
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-276 - Automatic: Customer Service : Accessories
Scenario: TTP-276 - Automatic: Customer Service : Accessories
GivenStories: localtests/customer_service/steps/TTP-276.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
