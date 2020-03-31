!-- ----------------
!-- TTP-316 - Automatic:Checkout: Payment: Paymetrics: AMEX (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch usa
Given is 'D2C' website for brand 'Bosch' and country 'usa'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-316 - Automatic:Checkout: Payment: Paymetrics: AMEX (Bosch)
Scenario: TTP-316 - Automatic:Checkout: Payment: Paymetrics: AMEX (Bosch)
GivenStories: localtests/ecommerce/steps/TTP-316.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
