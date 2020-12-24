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
 * @className TC_12_IncompleteAPI
 * @summary This is contain step definition for feature file
 *          ErrorMessage_ExchangeRateAPI.feature to test provided API
 */
public class TC_12_IncompleteAPI extends FrameworkUtils {
	/**
	 * @methodName setUpHttpConnection
	 * @summary Get data from configuration files
	 * @param 'IncorrectAPI' from config.properties file
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Given("Incomplete API for Exchange rates")
	public void setUpHttpConnection() throws ClientProtocolException, IOException {
		setUpConnection("IncorrectAPI");
		log.info("Rest API Connection is stablish");

	}

	/**
	 * @methodName sendGetRequest
	 * @summary Send Get API request to client
	 */
	@When("Send Http Get Request for Incomplete API")
	public void sendGetRequest() {
		sendRequest();
	}

	/**
	 * @methodName validateResponse
	 * @summary Get response and assert response value
	 */
	@SuppressWarnings("deprecation")
	@Then("Validate the error message")
	public void validateResponse() {

		// Validation of Status Code from API response
		Assert.assertEquals(validateAPIStatusCode(), readPropertyFile("ERROR_RESPONSE_STATUS_CODE"));
		log.info("API executed sucessfully with response status code : " + validateAPIStatusCode());

		// Validation of Error Message from incorrect API Response
		Assert.assertEquals(getErrorMessage(), readPropertyFile("ErrorMsg"));
		log.info("Error message for incomplete API  < " + readPropertyFile("IncorrectAPI") + " >  is : "
				+ getErrorMessage());

	}
}
