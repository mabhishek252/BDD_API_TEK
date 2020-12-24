/**
 * @author Abhishek.Mishra
 */
package stepDefination;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import frameworkUtility.FrameworkUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

/**
 * @className TC_07_FutureDateAPI
 * @summary This is contain step definition for feature file EuroLatestExchangeRateAPI.feature to test provided API
 */
public class TC_07_FutureDateAPI extends FrameworkUtils{

	/**
	 * @methodName setUpHttpConnection
	 * @summary Get data from configuration files
	 * @param 'LatestExchangeRateAPI' from config.properties file 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Given("API for Latest Exchange rates with future date")
	public void setUpHttpConnection() throws ClientProtocolException, IOException {
		setUpConnection("FutureDateAPI");
		log.info("Rest API Connection is stablish");
	}

	/**
	 * @methodName sendGetRequest
	 * @summary Send Get API request to client
	 */
	@When("Send Http Get Request for future date")
	public void sendGetRequest() {
		sendRequest();
	}

	/**
	 * @methodName validateResponse
	 * @summary Get response and assert response value
	 */
	@SuppressWarnings("deprecation")
	@Then("Validate the Latest Exchange rates for future date")
	public void validateResponse() {
			//Validation of Status Code from API response 
			Assert.assertEquals(validateAPIStatusCode(), readPropertyFile("SUCCESS_RESPONSE_STATUS_CODE"));
			log.info("API executed sucessfully with response status code : "+ validateAPIStatusCode());
		
		
			//Validation of Base value from API Response
			Assert.assertEquals(getBaseValue(), readPropertyFile("Base_Value"));
			log.info("Base Value of API is : " + getBaseValue() );
		
			//Latest Exchange rates available in website 
			log.info("Latest Exchange Rate against Euro Currency is: " +  exchangeRates());
		
		
			//Validation of Date from future Exchange Rates API response, Its should fetch current date Exchange Rates as on API response
			Assert.assertEquals(readPropertyFile("Current_Date"), getDate());
			log.info("API is getting Response of " + getBaseValue() +" Exchange rate available in website for Latest date : " + getDate() );
		 
		}
	
}
