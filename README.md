# XmlConverter

JSONToXMLConverter

This is a simple spring boot program that converts json input to xml format

Getting Started
Instructions to clone to project and run in your local machine

https://github.com/PavithraKathiravan/XmlConverter.git
mvn spring-boot:run

To Test in console:
Go to http://localhost:8080/. Call the api /api/v1/convertToXml.
http://localhost:8080/api/v1/convertToXml/
Provided the input file in the code base itself to check the response in console.

Using RESTAPI
Method: POST Request with JSON input body
URL: http://localhost:8080/api/v1/convertToXml

Prerequisites
Java version 1.8
Maven version 3.x

**Input and Output Files**
_JSON_INPUT_
<?xml version="1.0"?>

-<object>
  -<object name="organization">
      <string name="name">RiskSense</string>
      <string name="type">Inc</string>
      <number name="building_number">4</number>
      <number name="floating">-17.4</number>
      <null name="null_test"/>
  </object>
  <boolean name="security_related">true</boolean>
  -<array name="array_example0">
      <string>red</string>
      <string>green</string>
      <string>blue</string>
      <string>black</string>
  </array>
  -<array name="array_example1">
        <number>1</number>
        <string>red</string>
    -<array>
    -<object>
      <boolean name="nested">true</boolean>
    </object>
 </array>
    -<object>
    <boolean name="obj">false</boolean>
    </object>
  </array>
</object>

_XML_OUTPUT_

<?xml version="1.0" encoding="UTF-8"?>
<object>
  <array name="array_example0">
    <string>red</string>
    <string>green</string>
    <string>blue</string>
    <string>black</string>
  </array>
  <array name="array_example1">
    <number>1</number>
    <string>red</string>
    <array>
      <object>
        <boolean name="nested">true</boolean>
      </object>
    </array>
    <object>
      <boolean name="obj">false</boolean>
    </object>
  </array>
  <object name="organization">
    <null name="null_test"/>
    <number name="floating">-17.4</number>
    <string name="name">RiskSense</string>
    <string name="type">Inc</string>
    <number name="building_number">4</number>
  </object>
  <boolean name="security_related">true</boolean>
</object>

Built With
Spring Boot - The web framework used
Maven - Dependency Management
Json - Used to parse and read json

Versioning
We use SemVer for versioning. For the versions available, see the releases on this repository.

License
This project is licensed under the Apache License - see the LICENSE.md file for details

TODO:

1. Order of the XML needs to be preserved.
