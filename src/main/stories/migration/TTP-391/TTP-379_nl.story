!-- ----------------
!-- TTP-379 - Staffsales User Registration - Non-whitelisted mail address (REJEFCT request)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-379 - Staffsales User Registration - Non-whitelisted mail address (REJEFCT request)
Scenario: TTP-379 - Staffsales User Registration - Non-whitelisted mail address (REJEFCT request)
GivenStories: migration/TTP-391/steps/TTP-379.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
