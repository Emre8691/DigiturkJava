!-- ----------------
!-- TTP-299 - Automatic:Checkout: Payment: Paymetrics: MasterCard (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch usa
Given is 'D2C' website for brand 'Bosch' and country 'usa'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-299 - Automatic:Checkout: Payment: Paymetrics: MasterCard (Bosch)
Scenario: TTP-299 - Automatic:Checkout: Payment: Paymetrics: MasterCard (Bosch)
GivenStories: localtests/ecommerce/steps/TTP-299.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
