!-- ----------------
!-- TTP-18198 - This is a TEST issue
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay armenia
Given is 'D2C' website for brand 'Balay' and country 'armenia' and language 'Armenian'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-18198 - This is a TEST issue
Scenario: TTP-18198 - This is a TEST issue
GivenStories: localtests/basic_functionalities/steps/TTP-18198.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
