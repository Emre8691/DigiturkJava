!-- ----------------
!-- TTP-324 - Automatic:Product Detailed Page: Breadcrumbs Products (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-324 - Automatic:Product Detailed Page: Breadcrumbs Products (Siemens)
Scenario: TTP-324 - Automatic:Product Detailed Page: Breadcrumbs Products (Siemens)
GivenStories: localtests/marketing/steps/TTP-324.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
