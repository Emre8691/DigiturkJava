!-- ----------------
!-- TTP-116 - Automatic:Product Detail Page:Breadcrumbs Shop
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-116 - Automatic:Product Detail Page:Breadcrumbs Shop
Scenario: TTP-116 - Automatic:Product Detail Page:Breadcrumbs Shop
GivenStories: migration/TTP-649/steps/TTP-116.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
