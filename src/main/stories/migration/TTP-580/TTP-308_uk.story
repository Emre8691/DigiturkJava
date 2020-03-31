!-- ----------------
!-- TTP-308 - Automatic :Payment: Change Payment Method(Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch greatbritain
Given is 'D2C' website for brand 'Bosch' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-308 - Automatic :Payment: Change Payment Method(Bosch)
Scenario: TTP-308 - Automatic :Payment: Change Payment Method(Bosch)
GivenStories: migration/TTP-580/steps/TTP-308.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
