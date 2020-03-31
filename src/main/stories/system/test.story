
Scenario: Set parameters

Given is 'D2C' website for brand 'BOSCH' and country 'portugal'
Given are properties from url, urlsuffix, login, product, login, checkout, test
Given http authentication is provided

Scenario: Go to Registration via Login Page

When I open the page for following address <starturl>
Then I must wait '1' second

When I open the page product/Detergente/00311196
When I add the product of productpage to basket
Then the product was added to basket within '5' seconds

When I open the page for following address <basketurl>

When I click the button 'checkouttop'
Then I must wait '1' second

When I continue with 'checkoutanonymus'
When I click the button 'continuebutton'
Then I must wait '1' second

When I send keys <keytest1> to field 'taxfield' '100' times 
When I send keys <keytest2> to field 'taxfield' '100' times 
When I send keys <keytest3> to field 'taxfield' '100' times 
When I send keys <keytest4> to field 'taxfield' '100' times 
When I send keys <keytest5> to field 'taxfield' '100' times 
When I send keys <keytest6> to field 'taxfield' '100' times 
When I send keys <keytest7> to field 'taxfield' '100' times 
When I send keys <keytest8> to field 'taxfield' '100' times 
When I send keys <keytest9> to field 'taxfield' '100' times 
When I send keys <keytest10> to field 'taxfield' '100' times 


!-- SUCCESS


Scenario: Set parameters

Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, login, registration, address, test
Given http authentication is provided

Scenario: Go to Registration via Login Page

When I open the page for following address http://www.siemenscom.test:9001/ch/de/
Then I must wait '1' second

When I open the page for following address <loginurl>

When I enter <user> into 'username'
When I enter <password> into 'password'

When I click the button 'logInButton'
Then wait '1' second

When I open the page for following address <profile>
Then wait '1' second

When I click the button 'changePersonalData'

When I send keys <keytest1> to field 'firstname' '100' times 
When I send keys <keytest2> to field 'lastname' '100' times 
When I send keys <keytest3> to field 'firstname' '100' times 
When I send keys <keytest4> to field 'lastname' '100' times 
When I send keys <keytest5> to field 'street' '100' times 
When I send keys <keytest6> to field 'street' '100' times 
When I send keys <keytest7> to field 'zipcode' '100' times 
When I send keys <keytest8> to field 'street' '100' times 
When I send keys <keytest9> to field 'street' '100' times 
When I send keys <keytest10> to field 'street' '100' times 



!-- SUCCESS