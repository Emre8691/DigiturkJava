!-- ----------------
!-- TTP-471 - Automatic: Checkout Payment Worldpay VISA (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-471 - Automatic: Checkout Payment Worldpay VISA (NEFF)
Scenario: TTP-471 - Automatic: Checkout Payment Worldpay VISA (NEFF)
GivenStories: migration/TTP-580/steps/TTP-471.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
