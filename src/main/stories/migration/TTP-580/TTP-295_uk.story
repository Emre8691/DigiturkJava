!-- ----------------
!-- TTP-295 - Automatic:Checkout: Payment: WorldPay: Maestro (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch greatbritain
Given is 'D2C' website for brand 'Bosch' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-295 - Automatic:Checkout: Payment: WorldPay: Maestro (Bosch)
Scenario: TTP-295 - Automatic:Checkout: Payment: WorldPay: Maestro (Bosch)
GivenStories: migration/TTP-580/steps/TTP-295.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
