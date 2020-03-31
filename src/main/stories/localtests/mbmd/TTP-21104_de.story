!-- ----------------
!-- TTP-21104 - Neff/Balay - (MBMD) - PDP3 - Breadcrumbs Products
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay germany
Given is 'D2C' website for brand 'Balay' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21104 - Neff/Balay - (MBMD) - PDP3 - Breadcrumbs Products
Scenario: TTP-21104 - Neff/Balay - (MBMD) - PDP3 - Breadcrumbs Products
GivenStories: localtests/mbmd/steps/TTP-21104.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
