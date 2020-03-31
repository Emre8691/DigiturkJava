!-- ----------------
!-- TTP-569 - Automatic:Basic Functionalities: Customer Service Flyout (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'D2C' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-569 - Automatic:Basic Functionalities: Customer Service Flyout (Siemens)
Scenario: TTP-569 - Automatic:Basic Functionalities: Customer Service Flyout (Siemens)
GivenStories: migration/TTP-645/steps/TTP-569.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
