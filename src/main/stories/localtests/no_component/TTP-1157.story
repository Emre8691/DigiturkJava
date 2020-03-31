!-- ----------------
!-- TTP-1157 - Max order limit per item in BOSCH TR
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch slovakia
Given is 'D2C' website for brand 'Bosch' and country 'slovakia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1157 - Max order limit per item in BOSCH TR
Scenario: TTP-1157 - Max order limit per item in BOSCH TR
GivenStories: localtests/no_component/steps/TTP-1157.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
