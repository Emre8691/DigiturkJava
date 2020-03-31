!-- ----------------
!-- TTP-100090 - (MBMD) - ACC7 - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens switzerland
Given is 'D2C' website for brand 'Siemens' and country 'switzerland' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100090 - (MBMD) - ACC7 - MyAccount - Password Forgotten
Scenario: TTP-100090 - (MBMD) - ACC7 - MyAccount - Password Forgotten
GivenStories: migration/TTP-20589/steps/TTP-100090.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
