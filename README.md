# UI Automation Assignment
Hello there !! Here is my assigment for engineering productivity. To run this test you need these already installed in your device :
- Java (Mandatory)
- Maven / gradle (Mandatory)
- Docker (Not Mandatory, used to test multi platform/ OS)

## How to run 
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```
Or
```json
$ gradle clean test -Pdriver=firefox
```

The test results will be recorded in the `target/site/serenity` directory.

### Running in browserstack 
To run in browsertack you have to update `browserstack.user` and `browserstack.key` in `serenity.properties`
Then type in terminal 
```json
 mvn verify -P parallel
```
`parallel` is a profile that has been defined for this project in POM.XML .

### Filter feature to be run
Choose feature to be run by tag that already defined. You can see the detail in the `.feature` file
```json
mvn verify -Pit -Dcucumber.filter.tags="@tags"
```

# Getting started with Serenity and Cucumber

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.


### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
      +Pages                      Represent application page
      +Starter                    Test runner and set up
      +StepDefinition             Glue gherkin scenario to java 
      +Utility                    Helper class
    + resources
      + features                  Feature files
```

## Generating the reports
Since the Serenity reports contain aggregate information about all of the tests, they are not generated after each individual test (as this would be extremenly inefficient). Rather, The Full Serenity reports are generated by the `serenity-maven-plugin`. You can trigger this by running `mvn serenity:aggregate` from the command line or from your IDE.

They reports are also integrated into the Maven build process: the following code in the `pom.xml` file causes the reports to be generated automatically once all the tests have completed when you run `mvn verify`?

```
             <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.maven.version}</version>
                <configuration>
                    <tags>${tags}</tags>
                </configuration>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
```

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```java
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

Serenity uses WebDriverManager to download the WebDriver binaries automatically before the tests are executed.

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = "https://example.com"
  }
  dev {
    webdriver.base.url = "https://example.com/dev"
  }
  staging {
    webdriver.base.url = "https://example.com/staging"
  }
  prod {
    webdriver.base.url = "https://example.com/prod"
  }
}
```

You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```

### Platform/ OS independent
Serenity can be run in multiple operating system since it is running in Java. You can also use Serenity to run your WebDriver tests on a remote machine, such as a Selenium Grid or a remote service such as provided by SauceLabs or BrowserStack. This allows you to run your web tests against a variety of different browsers and operating systems, and also benefit from faster test execution when running the tests in parallel.
Futher setup need to be done in `serenity.properties`
