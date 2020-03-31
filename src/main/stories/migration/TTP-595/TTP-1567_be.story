!-- ----------------
!-- TTP-1567 - e-numbers which are not DOB available (2/2: Beginning on service assistent start page)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1567 - e-numbers which are not DOB available (2/2: Beginning on service assistent start page)
Scenario: TTP-1567 - e-numbers which are not DOB available (2/2: Beginning on service assistent start page)
GivenStories: migration/TTP-595/steps/TTP-1567.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
