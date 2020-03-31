!-- ----------------
!-- TTP-100199 - Bosch - (MBMD) - Outlet - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch netherlands
Given is 'OUTLET' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100199 - (MBMD) - ACC7 - MyAccount - Password Forgotten
Scenario: TTP-100199 - (MBMD) - ACC7 - MyAccount - Password Forgotten
GivenStories: migration/TTP-20589/steps/TTP-100199.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
