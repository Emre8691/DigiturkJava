!-- ----------------
!-- TTP-568 - Automatic:Basic Functionalities: Category Flyout (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'D2C' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-568 - Automatic:Basic Functionalities: Category Flyout (Siemens)
Scenario: TTP-568 - Automatic:Basic Functionalities: Category Flyout (Siemens)
GivenStories: migration/TTP-645/steps/TTP-568.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
