!-- ----------------
!-- TTP-23885 - Bosch - many items - A&B products -scenario1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'STAFF' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23885 - Bosch - many items - A&B products -scenario1
Scenario: TTP-23885 - Bosch - many items - A&B products -scenario1
GivenStories: localtests/sap/steps/TTP-23885.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
