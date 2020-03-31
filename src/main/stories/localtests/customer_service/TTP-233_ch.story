!-- ----------------
!-- TTP-233 - Automatic: Service Assistant I (rating plate finder, E-number, product category) 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-233 - Automatic: Service Assistant I (rating plate finder, E-number, product category) 
Scenario: TTP-233 - Automatic: Service Assistant I (rating plate finder, E-number, product category) 
GivenStories: localtests/customer_service/steps/TTP-233.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
