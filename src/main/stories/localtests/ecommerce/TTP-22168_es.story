!-- ----------------
!-- TTP-22168 - Automatic: Checkout: Delivery: Logged User - WorldPay- Merchant ID (Balay)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay spain
Given is 'D2C' website for brand 'Balay' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-22168 - Automatic: Checkout: Delivery: Logged User - WorldPay- Merchant ID (Balay)
Scenario: TTP-22168 - Automatic: Checkout: Delivery: Logged User - WorldPay- Merchant ID (Balay)
GivenStories: localtests/ecommerce/steps/TTP-22168.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
