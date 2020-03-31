!-- ----------------
!-- TTP-11831 - PI - Marketing List Page - Online Dealers
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11831 - PI - Marketing List Page - Online Dealers
Scenario: TTP-11831 - PI - Marketing List Page - Online Dealers
GivenStories: localtests/product_information/steps/TTP-11831.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
