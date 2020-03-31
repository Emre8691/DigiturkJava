!-- ----------------
!-- TTP-367 - Automatic: Staffsales Checkout - Checkout Logged User (new DeliveryAddress)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-367 - Automatic: Staffsales Checkout - Checkout Logged User (new DeliveryAddress)
Scenario: TTP-367 - Automatic: Staffsales Checkout - Checkout Logged User (new DeliveryAddress)
GivenStories: localtests/staff_sales/steps/TTP-367.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
