!-- ----------------
!-- TTP-344 - Automatic: Checkout: Payment: Union Pay (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS china
Given is 'D2C' website for brand 'SIEMENS' and country 'china'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-344 - Automatic: Checkout: Payment: Union Pay (Siemens)
Scenario: TTP-344 - Automatic: Checkout: Payment: Union Pay (Siemens)
GivenStories: migration/TTP-580/steps/TTP-344.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
