package utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import entities.Users;

public class Utilities {

	static ObjectMapper mapper;

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

	public static String marshelling(Users entity) throws JsonGenerationException, JsonMappingException, IOException {

		// Marshelling
		mapper = new ObjectMapper();

		String oJsonString = mapper.writeValueAsString(entity);

		return oJsonString;

	}

	public static Users unmarshelling(Users expected, String objJSON)
			throws JsonParseException, JsonMappingException, IOException {

		mapper = new ObjectMapper();
		Users entity = mapper.readValue(objJSON, Users.class);

		return entity;

	}
}
