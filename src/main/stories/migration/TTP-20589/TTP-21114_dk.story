!-- ----------------
!-- TTP-21114 - Neff/Balay - (MBMD) - ACC6 - MyAccount - Change Password
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay denmark
Given is 'D2C' website for brand 'Balay' and country 'denmark'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21114 - Neff/Balay - (MBMD) - ACC6 - MyAccount - Change Password
Scenario: TTP-21114 - Neff/Balay - (MBMD) - ACC6 - MyAccount - Change Password
GivenStories: migration/TTP-20589/steps/TTP-21114.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
