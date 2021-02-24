package com.csw.converter;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csw.utility.XmlFormatter;

/**
 * Converter Factory: For converting Json format to Xml format
 */

@Service
public class ConverterFactory implements JsonToXmlConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConverterFactory.class);
	@Autowired
	XmlFormatter formatter;

	@Override
	public String convertJsonToXml(String jsonInput) {
		Object jsonObject;

		try {
			LOGGER.info("Attempting To Convert JSON String To JSON Object");
			jsonObject = new JSONObject(jsonInput);

		} catch (Exception ex) {
			LOGGER.error("Exception When Converting Json Object");
			return null;
		}

		return formatter.format(convertToXml(null, jsonObject));
	}

	private String convertToXml(String name, Object data) {
		String nameValue = (name == null) ? "" : " name=\"" + name + "\"";
		if (data instanceof Number) {
			return "<number" + nameValue + ">" + data + "</number>";
		} else if (data instanceof String) {
			return "<string" + nameValue + ">" + data + "</string>";
		} else if (data instanceof Boolean) {
			return "<boolean" + nameValue + ">" + data + "</boolean>";
		} else if (data instanceof JSONArray) {
			StringBuilder builder = new StringBuilder("<array" + nameValue + ">");
			for (int i = 0; i < ((JSONArray) data).length(); i++) {
				builder.append(convertToXml(null, ((JSONArray) data).get(i)));
			}
			builder.append("</array>");
			return builder.toString();
		} else if (data instanceof JSONObject) {
			StringBuilder builder = new StringBuilder("<object" + nameValue + ">");
			Iterator<String> it = ((JSONObject) data).keys();
			while (it.hasNext()) {
				String key = it.next().toString();
				Object objData = ((JSONObject) data).get(key);
				builder.append(convertToXml(key, objData));
			}
			builder.append("</object>");
			return builder.toString();
		} else if (data == JSONObject.NULL) {
			return "<null" + nameValue + "/>";
		} else {
			throw new UnsupportedOperationException("Data type " + data.getClass() + " not yet supported");
		}
	}
}
