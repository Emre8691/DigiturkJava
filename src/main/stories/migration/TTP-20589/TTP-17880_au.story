!-- ----------------
!-- TTP-17880 - (MBMD) - PDP3 - Breadcrumbs Products
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch australia
Given is 'D2C' website for brand 'Bosch' and country 'australia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17880 - (MBMD) - PDP3 - Breadcrumbs Products
Scenario: TTP-17880 - (MBMD) - PDP3 - Breadcrumbs Products
GivenStories: migration/TTP-20589/steps/TTP-17880.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
