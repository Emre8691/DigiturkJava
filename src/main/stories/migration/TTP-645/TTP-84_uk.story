!-- ----------------
!-- TTP-84 - Automatic:Basic Functionalities: Category Flyout (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'D2C' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-84 - Automatic:Basic Functionalities: Category Flyout (Siemens)
Scenario: TTP-84 - Automatic:Basic Functionalities: Category Flyout (Siemens)
GivenStories: migration/TTP-645/steps/TTP-84.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
