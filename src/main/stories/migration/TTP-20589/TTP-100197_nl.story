!-- ----------------
!-- TTP-100197 - Bosch - (MBMD)-Outlet - Change Profile Address
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch Netherlands
Given is 'Outlet' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TEST-100197 - (MBMD) - BAS3 - Change Profile Address
Scenario: TEST-100197 - (MBMD) - BAS3 - Change Delivery Settings Address
GivenStories: migration/TTP-20589/steps/TTP-100197.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
