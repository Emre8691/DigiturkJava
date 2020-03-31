!-- ----------------
!-- TTP-85 - Automatic:Basic Functionalities:Customer Service:Flyout
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-85 - Automatic:Basic Functionalities:Customer Service:Flyout
Scenario: TTP-85 - Automatic:Basic Functionalities:Customer Service:Flyout
GivenStories: migration/TTP-587/steps/TTP-85.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
