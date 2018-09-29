package utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utilities {

	public static String JSONparser(JSONObject oJson, String jsonKey) {
		Object obj = oJson;

		for (String s : jsonKey.split("/")) {

			if (!s.isEmpty()) {
				if (!((s.contains("[")) || (s.contains("]"))))
					obj = ((JSONObject) obj).get(s);
				else if ((s.contains("[")) || (s.contains("]")))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0]))
							.get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));

			}
		}
		return obj.toString();

	}
}
