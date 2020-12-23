/**
 * @author Abhishek.Mishra
 */
package frameworkUtility;

import org.json.JSONObject;
import org.json.JSONArray;

/**
 * @className JSONtoString
 * @summary This class have method which convert JSON content into String
 */
public class JSONtoString {
	
	/**
	 * @methodName getValueByJPath
	 * @param responsejson 
	 * @param jpath
	 * @return String content converted from JSON
	 */
	public static String getValueByJPath(JSONObject responsejson, String jpath){
		Object obj = responsejson;
		for(String s : jpath.split("/")) 
			if(!s.isEmpty()) 
				if(!(s.contains("[") || s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if(s.contains("[") || s.contains("]"))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		return obj.toString();
	}
}
