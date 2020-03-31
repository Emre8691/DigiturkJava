!-- ----------------
!-- TTP-21118 - Neff/Balay - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay sweden
Given is 'D2C' website for brand 'Balay' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21118 - Neff/Balay - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
Scenario: TTP-21118 - Neff/Balay - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
GivenStories: localtests/mbmd/steps/TTP-21118.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
