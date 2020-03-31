!-- ----------------
!-- TTP-23864 - BOSCH - Hybris : single item - LDA - B
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'STAFF' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23864 - BOSCH - Hybris : single item - LDA - B
Scenario: TTP-23864 - BOSCH - Hybris : single item - LDA - B
GivenStories: localtests/sap/steps/TTP-23864.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
