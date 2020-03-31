!-- ----------------
!-- TTP-14868 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS taiwan
Given is 'D2C' website for brand 'SIEMENS' and country 'taiwan'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14868 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V1
Scenario: TTP-14868 - (DS) Product Detailed Page ND - Breadcrumbs Products PDP3 -V1
GivenStories: migration/TTP-625/steps/TTP-14868.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
