!-- ----------------
!-- TTP-572 - CEW: Appliance Data validations
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'D2C' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-572 - CEW: Appliance Data validations
Scenario: TTP-572 - CEW: Appliance Data validations
GivenStories: migration/TTP-591/steps/TTP-572.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
