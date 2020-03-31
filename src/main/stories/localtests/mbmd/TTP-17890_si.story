!-- ----------------
!-- TTP-17890 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch slovenia
Given is 'D2C' website for brand 'Bosch' and country 'slovenia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17890 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
Scenario: TTP-17890 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
GivenStories: localtests/mbmd/steps/TTP-17890.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
