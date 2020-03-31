!-- ----------------
!-- TTP-14385 - Test 1 - Navigation - Metanavigation Tabs
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Ufesa switzerland
Given is 'D2C' website for brand 'Ufesa' and country 'switzerland' and language 'German'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14385 - Test 1 - Navigation - Metanavigation Tabs
Scenario: TTP-14385 - Test 1 - Navigation - Metanavigation Tabs
GivenStories: localtests/no_component/steps/TTP-14385.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
