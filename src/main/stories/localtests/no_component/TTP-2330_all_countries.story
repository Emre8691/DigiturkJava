!-- ----------------
!-- TTP-2330 - Homeconnect Webservice Test - RemoveALL Appliance
!-- ----------------

!-- Prepare location and parameters
Scenario: Set webservice url and type
Given is service type is REST
Given is rest base url is https://future-int.ws.d2cfarm.com
Given is webservice authentication

!-- ----------------
!-- TTP-2330 - Homeconnect Webservice Test - RemoveALL Appliance
Scenario: TTP-2330 - Homeconnect Webservice Test - RemoveALL Appliance
GivenStories: localtests/no_component/steps/TTP-2330.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
