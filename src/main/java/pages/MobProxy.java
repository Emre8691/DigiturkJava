package pages;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Proxy;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
 
public class MobProxy {
    public static WebDriver driver;
    public static BrowserMobProxyServer proxy;
 
   public static void main(String[] args){
 
       System.setProperty("webdriver.chrome.driver","C:\\GridSetup\\chromedriver.exe");
       proxy = new BrowserMobProxyServer();
       proxy.start();
 
       Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
       try {
           String hostIp = Inet4Address.getLocalHost().getHostAddress();
           seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
           seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
       } catch (UnknownHostException e) {
           e.printStackTrace();
       }
 
        DesiredCapabilities seleniumCapabilities = new DesiredCapabilities();
        seleniumCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        ChromeOptions options = new ChromeOptions();
        options.merge(seleniumCapabilities);
        driver = new ChromeDriver(options);
 
       proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
 
 
       try {
 
           proxy.newHar("localhost:3000");
 
           driver.get("http://localhost:3000");
           try {
               Thread.sleep(10000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
 
           Har har = proxy.getHar();
 
           File harFile = new File("/Download/localhost.har");
           har.writeTo(harFile);
 
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        driver.quit();
        proxy.stop();
    }
}