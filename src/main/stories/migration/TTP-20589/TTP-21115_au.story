!-- ----------------
!-- TTP-21115 - Neff/Balay - (MBMD) - ACC7 - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay australia
Given is 'D2C' website for brand 'Balay' and country 'australia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21115 - Neff/Balay - (MBMD) - ACC7 - MyAccount - Password Forgotten
Scenario: TTP-21115 - Neff/Balay - (MBMD) - ACC7 - MyAccount - Password Forgotten
GivenStories: migration/TTP-20589/steps/TTP-21115.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
