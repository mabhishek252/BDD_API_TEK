/**
 * @author Abhishek.Mishra
 *
 */
package StepDefination;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import frameworkUtility.FrameworkUtils;
import frameworkUtility.JSONtoString;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


/**
 * @className TC_01_LatestExchangeRates
 * @summary This is contain step definition for feature file EuroLatestExchangeRateAPI.feature to test provided API
 */
public class TC_01_LatestExchangeRates extends FrameworkUtils {
	
	/**
	 * @methodName setUpHttpConnection
	 * @summary Get data from configuration files
	 * @param 'LatestExchangeRateAPI' from config.properties file 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Given("API for Latest Exchange rates")
	public void setUpHttpConnection() throws ClientProtocolException, IOException {
		setUpConnection("LatestExchangeRateAPI");
		log.info("Rest API Connection is stablish");

	}

	/**
	 * @methodName sendGetRequest
	 * @summary Send Get API request to client
	 */
	@When("Send Http Get Request for API")
	public void sendGetRequest() {
		sendRequest();
	}

	/**
	 * @methodName validateResponse
	 * @summary Get response and assert response value
	 */
	@SuppressWarnings("deprecation")
	@Then("Validate the Latest Exchange rates")
	public void validateResponse() {
		String statuscode = Integer.toString(validateAPIStatusCode());
		Assert.assertEquals(statuscode, readPropertyFile("SUCCESS_RESPONSE_STATUS_CODE"));
		log.info("API executed sucessfully and with response status code : "+ statuscode);
		
		
		String baseValue = JSONtoString.getValueByJPath(validateAPIResponse(), "/base");
		log.info("Base Value of API : " + baseValue );
		Assert.assertEquals(baseValue, readPropertyFile("Base_Value"));
		
		String exchangeRates = JSONtoString.getValueByJPath(validateAPIResponse(), "/rates");
		log.info("Latest Exchange Rate against Euro Currency is: " + exchangeRates );
		
		String date = JSONtoString.getValueByJPath(validateAPIResponse(), "/date");
		Assert.assertEquals(date, readPropertyFile("Current_Date"));
		log.info("API is getting Response of Euro Exchange rate available in website for Latest date : " + date );
					
		}
}
