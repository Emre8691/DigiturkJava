!-- ----------------
!-- TTP-328 - Automatic: Basic Functionalities: Carousel (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch greatbritain
Given is 'D2C' website for brand 'Bosch' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-328 - Automatic: Basic Functionalities: Carousel (Bosch)
Scenario: TTP-328 - Automatic: Basic Functionalities: Carousel (Bosch)
GivenStories: localtests/basic_functionalities/steps/TTP-328.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
