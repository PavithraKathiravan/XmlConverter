package com.csw.converter;

import java.io.IOException;

/**
 * This interface provides methods that are required for creating a converter
 * from XML to JSON.
 */
public interface JsonToXmlConverter {

	/**
	 *
	 * @param json JSON data.
	 * @return XML data.
	 * @throws java.io.IOException
	 */
	public String convertJsonToXml(String json) throws IOException;
}
