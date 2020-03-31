!-- ----------------
!-- TTP-100040 - (MBMD) - ACC7 - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens denmark
Given is 'D2C' website for brand 'Siemens' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100040 - (MBMD) - ACC7 - MyAccount - Password Forgotten
Scenario: TTP-100040 - (MBMD) - ACC7 - MyAccount - Password Forgotten
GivenStories: migration/TTP-20589/steps/TTP-100050.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
