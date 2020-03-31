!-- ----------------
!-- TTP-23854 - BOSCH - Hybris:  single item - CP
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'STAFF' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23854 - BOSCH - Hybris:  single item - CP
Scenario: TTP-23854 - BOSCH - Hybris:  single item - CP
GivenStories: localtests/sap/steps/TTP-23854.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
