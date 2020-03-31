!-- ----------------
!-- TTP-411 - Automatic: D2C - N2 basket integration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch france
Given is 'D2C' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-411 - Automatic: D2C - N2 basket integration
Scenario: TTP-411 - Automatic: D2C - N2 basket integration
GivenStories: migration/TTP-98/steps/TTP-411.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
