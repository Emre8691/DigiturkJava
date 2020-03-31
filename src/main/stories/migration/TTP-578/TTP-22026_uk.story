!-- ----------------
!-- TTP-22026 - Automatic: Checkout: Delivery: Logged User - WorldPay- Merchant ID (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for  greatbritain
Given is 'D2C' website for brand '' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-22026 - Automatic: Checkout: Delivery: Logged User - WorldPay- Merchant ID (Siemens)
Scenario: TTP-22026 - Automatic: Checkout: Delivery: Logged User - WorldPay- Merchant ID (Siemens)
GivenStories: migration/TTP-578/steps/TTP-22026.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
