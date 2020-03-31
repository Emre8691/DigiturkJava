!-- ----------------
!-- TTP-314 - Automatic: Checkout: Payment: Invoice Payment (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'D2C' website for brand 'Bosch' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-314 - Automatic: Checkout: Payment: Invoice Payment (Bosch)
Scenario: TTP-314 - Automatic: Checkout: Payment: Invoice Payment (Bosch)
GivenStories: migration/TTP-580/steps/TTP-314.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
