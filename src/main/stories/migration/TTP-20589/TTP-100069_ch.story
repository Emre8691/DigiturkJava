!-- ----------------
!-- TTP-100039 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens denmark
Given is 'D2C' website for brand 'Siemens' and country 'switzerland' and language 'German'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100069 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
Scenario: TTP-100069 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
GivenStories: migration/TTP-20589/steps/TTP-100069.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
