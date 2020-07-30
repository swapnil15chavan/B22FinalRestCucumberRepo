$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/basic/compareEntireJson/comparejson.feature");
formatter.feature({
  "line": 1,
  "name": "compare entire json",
  "description": "",
  "id": "compare-entire-json",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Test my Delete request",
  "description": "",
  "id": "compare-entire-json;test-my-delete-request",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user compare two json string",
  "keyword": "Given "
});
formatter.match({
  "location": "TestCompareJson.user_compare_two_json_string()"
});
formatter.result({
  "duration": 353302300,
  "error_message": "java.lang.AssertionError: \nUnexpected: mobile\n\r\n\tat org.skyscreamer.jsonassert.JSONAssert.assertEquals(JSONAssert.java:417)\r\n\tat org.skyscreamer.jsonassert.JSONAssert.assertEquals(JSONAssert.java:394)\r\n\tat com.basic.compareEntireJson.TestCompareJson.user_compare_two_json_string(TestCompareJson.java:36)\r\n\tat ✽.Given user compare two json string(com/basic/compareEntireJson/comparejson.feature:5)\r\n",
  "status": "failed"
});
});