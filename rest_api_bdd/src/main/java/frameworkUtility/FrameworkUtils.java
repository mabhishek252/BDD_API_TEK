/**
 * @author Abhishek.Mishra
 * @version 1.0.0
 */
package frameworkUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import httpClients.RestClient;

/**
 * @className FrameworkUtils
 * @Description This class is created to add common method used in framework and
 *              it could be enhanced in future to add common utility methods.
 */
public class FrameworkUtils {

	/**
	 * @description Variables declaration in below section.
	 */
	static String projectPath = System.getProperty("user.dir");
	static Properties prop = new Properties();
	public Logger log = Logger.getLogger(FrameworkUtils.class);
	String exchangeRate;
	public RestClient restclient;
	protected CloseableHttpResponse httpResponse;
	public String reponseInString;

	/**
	 * @methodName readPropertyFile
	 * @summary Read configuration property file
	 * @param key
	 * @return value of key
	 */
	public static String readPropertyFile(String key) {

		String value = "";
		try {
			InputStream input = new FileInputStream(projectPath + "/src/main/resources/config/config.properties");
			prop.load(input);
			value = prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * @methodName setUpConnection
	 * @summary Get API from config.properties file
	 * @param API
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public void setUpConnection(String API) throws ClientProtocolException, IOException {
		exchangeRate = readPropertyFile(API);
		log.info("API to get Exchange Rate: " + exchangeRate);
	}

	/**
	 * @methodName sendRequest
	 * @summary Send Get API request to client
	 */
	public void sendRequest() {
		restclient = new RestClient();
		try {
			httpResponse = restclient.get(exchangeRate);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @methodName validateAPIStatusCode
	 * @summary Fetch API response status code from client
	 * @return Status Code of API as String
	 */
	public String validateAPIStatusCode() {
		int statusCodeinInt = httpResponse.getStatusLine().getStatusCode();
		String statusCode = Integer.toString(statusCodeinInt);

		return statusCode;
	}

	/**
	 * @methodName validateAPIResponse
	 * @summary Fetch API All response from client
	 * @return API response in JSON format
	 */
	public JSONObject apiResponseInJSON() {
		try {
			reponseInString = EntityUtils.toString(httpResponse.getEntity(), readPropertyFile("ResponseFormat"));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject responseInJSON = new JSONObject(reponseInString);
		return responseInJSON;
	}

	/**
	 * @methodName getBaseValue
	 * @summary Fetch Base Value from API response
	 * @return String
	 */
	public String getBaseValue() {
		String baseValue = JSONtoString.getValueByJPath(apiResponseInJSON(), "/base");
		return baseValue;
	}

	/**
	 * @methodName getDate
	 * @summary Fetch Date from API response
	 * @return
	 */
	public String getDate() {
		String date = JSONtoString.getValueByJPath(apiResponseInJSON(), "/date");
		return date;
	}

	/**
	 * @methodName exchangeRates
	 * @summary Fetch Exchange Rates from API response
	 * @return
	 */
	public String exchangeRates() {
		String exchangeRates = JSONtoString.getValueByJPath(apiResponseInJSON(), "/rates");
		return exchangeRates;
	}

	/**
	 * @methodName getErrorMessage
	 * @summary Fetch Error message from incorrect API response
	 * @return
	 */
	public String getErrorMessage() {
		String errorMsg = JSONtoString.getValueByJPath(apiResponseInJSON(), "/");
		return errorMsg;
	}

}