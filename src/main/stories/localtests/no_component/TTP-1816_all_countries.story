!-- ----------------
!-- TTP-1816 - Homeconnect Webservice Test Demo
!-- ----------------

!-- Prepare location and parameters
Scenario: Set webservice url and type
Given is service type is REST
Given is rest base url is https://future-int.ws.d2cfarm.com
Given is webservice authentication

!-- ----------------
!-- TTP-1816 - Homeconnect Webservice Test Demo
Scenario: TTP-1816 - Homeconnect Webservice Test Demo
GivenStories: localtests/no_component/steps/TTP-1816.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
