!-- ----------------
!-- TTP-286 - Automatic:Checkout: Payment: WorldPay: MasterCard (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-286 - Automatic:Checkout: Payment: WorldPay: MasterCard (Siemens)
Scenario: TTP-286 - Automatic:Checkout: Payment: WorldPay: MasterCard (Siemens)
GivenStories: migration/TTP-580/steps/TTP-286.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
