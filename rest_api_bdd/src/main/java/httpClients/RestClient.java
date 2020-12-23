/**
 * @author Abhishek.Mishra
 */
package httpClients;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @className RestClient
 * @summary Stable connection with client and get response 
 *
 */
public class RestClient {

	/**
	 * @methodName CloseableHttpResponse
	 * @param url
	 * @return httpResponse
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		return httpResponse;

	}

}
