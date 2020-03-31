!-- ----------------
!-- TTP-14869 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V3
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14869 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V3
Scenario: TTP-14869 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V3
GivenStories: migration/TTP-625/steps/TTP-14869.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
