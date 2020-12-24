/**
 * @author Abhishek.Mishra
 *
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
 * @className TC_01_LatestExchangeRates
 * @summary This is contain step definition for feature file
 *          EuroLatestExchangeRateAPI.feature to test provided API
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

		//Validation of Status Code from API response 
		Assert.assertEquals(validateAPIStatusCode(), readPropertyFile("SUCCESS_RESPONSE_STATUS_CODE"));
		log.info("API executed sucessfully with response status code : "+ validateAPIStatusCode());

		//Validation of Base value from API Response
		Assert.assertEquals(getBaseValue(), readPropertyFile("Base_Value"));
		log.info("Base Value of API is : " + getBaseValue() );
		
		//Validation of Date from API response
		Assert.assertEquals(getDate(), readPropertyFile("Current_Date"));
		log.info("API is getting Response of " + getBaseValue() +" Exchange rate available in website for Latest date : " + getDate() );
		
		//Latest Exchange rates available in website 
		log.info("Latest Exchange Rate against Euro Currency is: " +  exchangeRates());
		  
		 
	}
}
