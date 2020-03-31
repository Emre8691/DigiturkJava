!-- ----------------
!-- TTP-345 - Automatic: Staffsales Product Pages - Product detail page breadcrumb
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-345 - Automatic: Staffsales Product Pages - Product detail page breadcrumb
Scenario: TTP-345 - Automatic: Staffsales Product Pages - Product detail page breadcrumb
GivenStories: migration/TTP-391/steps/TTP-345.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
