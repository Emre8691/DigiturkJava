!-- ----------------
!-- TTP-23895 - Bosch - eInvoice
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23895 - Bosch - eInvoice
Scenario: TTP-23895 - Bosch - eInvoice
GivenStories: migration/TTP-24026/steps/TTP-23895.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
