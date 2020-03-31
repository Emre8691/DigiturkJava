!-- ----------------
!-- TTP-62 - Automatic:Basic Functionalities:Carousel
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'Dutch'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-62 - Automatic:Basic Functionalities:Carousel
Scenario: TTP-62 - Automatic:Basic Functionalities:Carousel
GivenStories: localtests/basic_functionalities/steps/TTP-62.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
