!-- ----------------
!-- TTP-17893 - (MBMD) - ACC7 - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch portugal
Given is 'D2C' website for brand 'Bosch' and country 'portugal'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17893 - (MBMD) - ACC7 - MyAccount - Password Forgotten
Scenario: TTP-17893 - (MBMD) - ACC7 - MyAccount - Password Forgotten
GivenStories: localtests/mbmd/steps/TTP-17893.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
