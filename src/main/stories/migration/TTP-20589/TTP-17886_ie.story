!-- ----------------
!-- TTP-17886 - (MBMD) - SER2- Customer Services - service assistant
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch ireland
Given is 'D2C' website for brand 'Bosch' and country 'ireland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17886 - (MBMD) - SER2- Customer Services - service assistant
Scenario: TTP-17886 - (MBMD) - SER2- Customer Services - service assistant
GivenStories: migration/TTP-20589/steps/TTP-17886.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
