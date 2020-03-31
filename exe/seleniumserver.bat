echo. start Selenium grid
start cmd /k "cd Selenium && java -jar selenium-server-standalone-2.39.0.jar -port 4445 -role hub"
SLEEP 20
echo.
echo.
echo.
echo.
echo.
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 4446"
echo.
echo.
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 4447"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 4448"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 4449" 
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 4450"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 4451"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 4452"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 4453"
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:4445/grid/register -port 5555"