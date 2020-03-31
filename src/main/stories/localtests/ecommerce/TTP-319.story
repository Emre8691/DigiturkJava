!-- ----------------
!-- TTP-319 - Automatic:Checkout with Paymetrics - Bosch US public - anonymous
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch usa
Given is 'D2C' website for brand 'Bosch' and country 'usa'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-319 - Automatic:Checkout with Paymetrics - Bosch US public - anonymous
Scenario: TTP-319 - Automatic:Checkout with Paymetrics - Bosch US public - anonymous
GivenStories: localtests/ecommerce/steps/TTP-319.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
