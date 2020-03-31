!-- ----------------
!-- TTP-329 - Automatic: Eco fee on Bosch old layout
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch france
Given is 'STAFF' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-329 - Automatic: Eco fee on Bosch old layout
Scenario: TTP-329 - Automatic: Eco fee on Bosch old layout
GivenStories: localtests/staff_sales/steps/TTP-329.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
