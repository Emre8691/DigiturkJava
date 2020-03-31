!-- ----------------
!-- TTP-6039 - [Prod] - Paymet pages check - BOSCH-TR
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-6039 - [Prod] - Paymet pages check - BOSCH-TR
Scenario: TTP-6039 - [Prod] - Paymet pages check - BOSCH-TR
GivenStories: localtests/basic_functionalities/steps/TTP-6039.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
