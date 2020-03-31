!-- ----------------
!-- TTP-318 - Automatic: Checkout: Delivery: Logged User - New Delivery Address (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-318 - Automatic: Checkout: Delivery: Logged User - New Delivery Address (Siemens)
Scenario: TTP-318 - Automatic: Checkout: Delivery: Logged User - New Delivery Address (Siemens)
GivenStories: migration/TTP-578/steps/TTP-318.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
