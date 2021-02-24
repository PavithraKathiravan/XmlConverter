package com.csw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csw.converter.ConverterFactory;

@RestController
@RequestMapping(value = "/api/v1/convertToXml", produces = MediaType.APPLICATION_XML_VALUE)
public class JsonToXmlController {

	@Autowired
	ConverterFactory converterFactory;

	/**
	 * Forwards The Requests to Service layer
	 * 
	 * @param in - jsonInput
	 * @return out - XmlOutput
	 */
	@PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> convertToXml(@RequestBody String jsonInput) {
		String xmlOutput = converterFactory.convertJsonToXml(jsonInput);
		if (xmlOutput == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(xmlOutput, HttpStatus.OK);
	}

	@GetMapping("/")
	public void hello() {
		String str = "{\r\n" + "    \"organization\" : {\r\n" + "        \"name\" : \"RiskSense\",\r\n"
				+ "        \"type\" : \"Inc\",\r\n" + "        \"building_number\" : 4,\r\n"
				+ "        \"floating\" : -17.4,\r\n" + "        \"null_test\": null\r\n" + "    },\r\n"
				+ "    \"security_related\" : true,\r\n"
				+ "    \"array_example0\" : [\"red\", \"green\", \"blue\", \"black\"],\r\n"
				+ "    \"array_example1\" : [1, \"red\", [{ \"nested\" : true}], { \"obj\" : false}]\r\n" + "}\r\n"
				+ "\r\n" + "";
		String xmlOutput = converterFactory.convertJsonToXml(str);
		System.out.println(xmlOutput);

	}

}
