!-- ----------------
!-- TTP-1950 - [Prod]-[Tracking]-[N3-SI] Check whether Adobe Analytics tracking data is sent No Action for Cookie
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'D2C' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1950 - [Prod]-[Tracking]-[N3-SI] Check whether Adobe Analytics tracking data is sent No Action for Cookie
Scenario: TTP-1950 - [Prod]-[Tracking]-[N3-SI] Check whether Adobe Analytics tracking data is sent No Action for Cookie
GivenStories: migration/TTP-2530/steps/TTP-1950.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
