package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SapExecutionService {

	public static void main(String[] args) {
		//test code
		
		try {
			Calendar cal = Calendar.getInstance();
  		  	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  		  	dt.format(cal.getTime());
  		  	
			addExecutionInfo("9999", "TTP-99", "futureint", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addExecutionInfo(String orderId, String issueKey, String testedSystem, Boolean success) throws Exception{
		
		  String url = "http://localhost:8079/rest/api/add/sap/result";
		  
		  if (testedSystem.equals("futureint")) {
			  url = "http://test.ciiorg.com/rest/api/add/sap/result";
		  } else {
			  url = "http://test.ciiorg.com/rest/api/add/sap/result";
		  }
		  
		  //url = "http://localhost:8079/rest/api/add/sap/result";
		  
		  URL obj = new URL(url);
		  HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		  con.setRequestMethod("POST");
		  con.setRequestProperty("Content-Type","application/json");

		  Calendar cal = Calendar.getInstance();
		  
		  SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		  String postJsonData = "{\"date\":\""+dt.format(cal.getTime())+"\",\"orderId\":\"" + orderId + "\",\"testId\":\""+issueKey+"\",\"success\":\""+success+"\"}";
		  System.out.println(postJsonData);
		  con.setDoOutput(true);
		  DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		  wr.writeBytes(postJsonData);
		  wr.flush();
		  wr.close();

		  int responseCode = con.getResponseCode();
		  System.out.println("nSending 'POST' request to URL : " + url);
		  System.out.println("Post Data : " + postJsonData);
		  System.out.println("Response Code : " + responseCode);

		  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		  String output;
		  StringBuffer response = new StringBuffer();

		  while ((output = in.readLine()) != null) {
			  response.append(output);
		  }
		  in.close();
		  
		  System.out.println(response.toString());
	}
}
