!-- ----------------
!-- TTP-14872 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V2
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS unitedarabemirates
Given is 'D2C' website for brand 'SIEMENS' and country 'unitedarabemirates'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14872 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V2
Scenario: TTP-14872 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V2
GivenStories: migration/TTP-625/steps/TTP-14872.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
