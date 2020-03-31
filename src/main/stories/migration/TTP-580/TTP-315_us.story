!-- ----------------
!-- TTP-315 - Automatic:Checkout: Payment: Paymetrics: Visa (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch usa
Given is 'D2C' website for brand 'Bosch' and country 'usa'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-315 - Automatic:Checkout: Payment: Paymetrics: Visa (Bosch)
Scenario: TTP-315 - Automatic:Checkout: Payment: Paymetrics: Visa (Bosch)
GivenStories: migration/TTP-580/steps/TTP-315.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
