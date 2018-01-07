$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Guru99 Application Testing",
  "description": "",
  "id": "guru99-application-testing",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Login Scenario",
  "description": "",
  "id": "guru99-application-testing;login-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "\"\u003cuser\u003e\" is on \"Home Page1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user selects item",
  "rows": [
    {
      "cells": [
        "ScreenName",
        "LogicalName"
      ],
      "line": 6
    },
    {
      "cells": [
        "Gmail",
        "gmail"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user loads page",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 9,
    "value": "Hello Mr. Jain"
  }
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "guru99-application-testing;login-scenario;",
  "rows": [
    {
      "cells": [
        "user"
      ],
      "line": 14,
      "id": "guru99-application-testing;login-scenario;;1"
    },
    {
      "cells": [
        "a"
      ],
      "line": 15,
      "id": "guru99-application-testing;login-scenario;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 15,
  "name": "Login Scenario",
  "description": "",
  "id": "guru99-application-testing;login-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "\"a\" is on \"Home Page1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user selects item",
  "rows": [
    {
      "cells": [
        "ScreenName",
        "LogicalName"
      ],
      "line": 6
    },
    {
      "cells": [
        "Gmail",
        "gmail"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user loads page",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 9,
    "value": "Hello Mr. Jain"
  }
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});