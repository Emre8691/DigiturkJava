!-- ----------------
!-- TTP-363 - Automatic: Product List Page:Filter(Product) (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS bahrain
Given is 'D2C' website for brand 'SIEMENS' and country 'bahrain' and language 'Arabic'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-363 - Automatic: Product List Page:Filter(Product) (Siemens)
Scenario: TTP-363 - Automatic: Product List Page:Filter(Product) (Siemens)
GivenStories: migration/TTP-651/steps/TTP-363.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
