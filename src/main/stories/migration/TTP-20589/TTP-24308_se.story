!-- ----------------
!-- TTP-17890 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens sweden
Given is 'D2C' website for brand 'Siemens' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17890 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
Scenario: TTP-24308 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
GivenStories: migration/TTP-20589/steps/TTP-24308.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
