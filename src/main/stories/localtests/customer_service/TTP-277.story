!-- ----------------
!-- TTP-277 - Automatic: Customer Service : Service Shops Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-277 - Automatic: Customer Service : Service Shops Search
Scenario: TTP-277 - Automatic: Customer Service : Service Shops Search
GivenStories: localtests/customer_service/steps/TTP-277.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
