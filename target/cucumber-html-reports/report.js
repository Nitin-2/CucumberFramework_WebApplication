$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LoginTest.feature");
formatter.feature({
  "line": 2,
  "name": "Login function for Magnushealth Application",
  "description": "",
  "id": "login-function-for-magnushealth-application",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "To verify Login function",
  "description": "",
  "id": "login-function-for-magnushealth-application;to-verify-login-function",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@LoginTest"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "magnushealth Application is Launch",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User enters valid UserName \"\u003cusername\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User enters valid Password \"\u003cpassword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User click on Login button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User close the Browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "login-function-for-magnushealth-application;to-verify-login-function;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 13,
      "id": "login-function-for-magnushealth-application;to-verify-login-function;;1"
    },
    {
      "cells": [
        "n.sharma-reseller",
        "Magnushealth@123"
      ],
      "line": 14,
      "id": "login-function-for-magnushealth-application;to-verify-login-function;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "To verify Login function",
  "description": "",
  "id": "login-function-for-magnushealth-application;to-verify-login-function;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@LoginTest"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "magnushealth Application is Launch",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User enters valid UserName \"n.sharma-reseller\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User enters valid Password \"Magnushealth@123\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User click on Login button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User close the Browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTestCase.magnushealth_Application_is_Launch()"
});
formatter.result({
  "duration": 16841383800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "n.sharma-reseller",
      "offset": 28
    }
  ],
  "location": "LoginTestCase.user_enters_valid_UserName(String)"
});
formatter.result({
  "duration": 333740400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Magnushealth@123",
      "offset": 28
    }
  ],
  "location": "LoginTestCase.user_enters_valid_Password(String)"
});
formatter.result({
  "duration": 216589300,
  "status": "passed"
});
formatter.match({
  "location": "LoginTestCase.user_click_on_Login_button()"
});
formatter.result({
  "duration": 2873240100,
  "status": "passed"
});
formatter.match({
  "location": "LoginTestCase.user_close_the_Browser()"
});
formatter.result({
  "duration": 114451400,
  "status": "passed"
});
});