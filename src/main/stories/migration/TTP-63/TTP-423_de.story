!-- ----------------
!-- TTP-423 - Automatic: Carousel (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-423 - Automatic: Carousel (NEFF)
Scenario: TTP-423 - Automatic: Carousel (NEFF)
GivenStories: migration/TTP-63/steps/TTP-423.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
