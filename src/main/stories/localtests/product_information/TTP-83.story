!-- ----------------
!-- TTP-83 - Automatic:Basic Functionalities:Category Flyout (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch greatbritain
Given is 'D2C' website for brand 'Bosch' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-83 - Automatic:Basic Functionalities:Category Flyout (Bosch)
Scenario: TTP-83 - Automatic:Basic Functionalities:Category Flyout (Bosch)
GivenStories: localtests/product_information/steps/TTP-83.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
