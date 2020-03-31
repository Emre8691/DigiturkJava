!-- ----------------
!-- TTP-1948 - Payment: Union Pay (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'German'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1948 - Payment: Union Pay (Bosch)
Scenario: TTP-1948 - Payment: Union Pay (Bosch)
GivenStories: migration/TTP-649/steps/TTP-1948.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
