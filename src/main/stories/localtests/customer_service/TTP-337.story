!-- ----------------
!-- TTP-337 - Automatic: Customer Service : Competency Pages - Service Nearby
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-337 - Automatic: Customer Service : Competency Pages - Service Nearby
Scenario: TTP-337 - Automatic: Customer Service : Competency Pages - Service Nearby
GivenStories: localtests/customer_service/steps/TTP-337.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
