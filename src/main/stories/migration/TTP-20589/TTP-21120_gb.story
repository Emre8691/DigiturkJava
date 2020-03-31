!-- ----------------
!-- TTP-21120 - Neff/Balay- (MBMD) - SER2- Customer Services - service assistant
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay greatbritain
Given is 'D2C' website for brand 'Balay' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21120 - Neff/Balay- (MBMD) - SER2- Customer Services - service assistant
Scenario: TTP-21120 - Neff/Balay- (MBMD) - SER2- Customer Services - service assistant
GivenStories: migration/TTP-20589/steps/TTP-21120.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
