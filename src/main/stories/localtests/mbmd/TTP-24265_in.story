!-- ----------------
!-- TTP-24265 - (MBMD) - Siemens - Checkout with Login 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS india
Given is 'D2C' website for brand 'SIEMENS' and country 'india'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-24265 - (MBMD) - Siemens - Checkout with Login 
Scenario: TTP-24265 - (MBMD) - Siemens - Checkout with Login 
GivenStories: localtests/mbmd/steps/TTP-24265.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
