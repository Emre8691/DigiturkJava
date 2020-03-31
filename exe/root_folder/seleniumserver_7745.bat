echo. Selenium is starting for Execution User.
echo. start Selenium grid
start cmd /k "cd Selenium && java -jar selenium-server-standalone-2.39.0.jar -port 7745 -role hub"
SLEEP 20
echo.
echo.
echo.
echo.
echo.
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7746 -nodeConfig 7746.json && pause"
echo.
echo.
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7747"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7748"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7749" 
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7750"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7751"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7752"
CALL 
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7753"
CALL
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7755"
CALL
echo.
SLEEP 3
start cmd /k "cd C:\BSHWebTests\Selenium && java -jar selenium-server-standalone-2.39.0.jar -role node  -hub http://localhost:7745/grid/register -port 7777"