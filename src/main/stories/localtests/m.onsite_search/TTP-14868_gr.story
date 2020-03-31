!-- ----------------
!-- TTP-14868 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greece
Given is 'D2C' website for brand 'SIEMENS' and country 'greece'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14868 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V1
Scenario: TTP-14868 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V1
GivenStories: localtests/m.onsite_search/steps/TTP-14868.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
