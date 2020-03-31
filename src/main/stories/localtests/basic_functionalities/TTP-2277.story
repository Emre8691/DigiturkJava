!-- ----------------
!-- TTP-2277 - [Prod]-[Tracking]-[N3-SI] Check whether Adobe Analytics tracking data is sent - DECLINE Cookie
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS denmark
Given is 'D2C' website for brand 'SIEMENS' and country 'denmark'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-2277 - [Prod]-[Tracking]-[N3-SI] Check whether Adobe Analytics tracking data is sent - DECLINE Cookie
Scenario: TTP-2277 - [Prod]-[Tracking]-[N3-SI] Check whether Adobe Analytics tracking data is sent - DECLINE Cookie
GivenStories: localtests/basic_functionalities/steps/TTP-2277.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
