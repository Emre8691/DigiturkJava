!-- ----------------
!-- TTP-428 - Automatic : Checkout with Garanti Bank - Bosch TR public - anonymous
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-428 - Automatic : Checkout with Garanti Bank - Bosch TR public - anonymous
Scenario: TTP-428 - Automatic : Checkout with Garanti Bank - Bosch TR public - anonymous
GivenStories: migration/TTP-578/steps/TTP-428.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
