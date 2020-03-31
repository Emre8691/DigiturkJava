!-- ----------------
!-- TTP-335 - Automatic: Checkout: Social Sign On (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'D2C' website for brand 'Bosch' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-335 - Automatic: Checkout: Social Sign On (Bosch)
Scenario: TTP-335 - Automatic: Checkout: Social Sign On (Bosch)
GivenStories: localtests/social_media/steps/TTP-335.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
