# UI Automation Assignment
Hello there !! Here is my assigment for engineering productivity. To run this test you need these already installed in your device :
- Java (Mandatory)
- Maven / gradle (Mandatory)

No need to download webDriver because it will be auto downloaded by Serenity


### Webdriver configuration
The WebDriver configuration is managed entirely from `serenity.properties`, as illustrated below:
```java
webdriver.driver = chrome
``` 

### How to run 
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

The test results will be recorded in the `target/site/serenity` directory.

### Running in browserstack 
To run in browsertack you have to update in `serenity.properties`
```json
browserstack.user= YOUR_BROWSERSTACK_USERNAME
browserstack.key=  YOUR_BROWSERSTACK_KEY
webdriver.driver = provided
```
Then type in terminal 
```json
 mvn verify -P parallel
```
`parallel` is a profile that has been defined for this project in POM.XML.


### Filter feature to be run
Choose feature to be run by tag that already defined. You can see the defined tag in the `.feature` file. 
To implement it, update runner class in `src/test/java/starter`
```json
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
plugin = {"pretty"},
features = "src/test/resources/features",
glue = "StepDefinition",
tags="@tags"
)
public class CucumberTestSuite {
}

```

# Getting started with Serenity and Cucumber

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

## Design Pattern : Page Object Model
Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements. It is useful in reducing code duplication and improves test case maintenance.
In Page Object Model, consider each web page of an application as a class file. Each class file will contain only corresponding web page elements. Using these elements, testers can perform operations on the website under test/step definitions.

**Advantages of Page Object Model** :
- **Helps with easy maintenance**: POM is useful when there is a change in a UI element or there is a change in an action. An example would be: a drop-down menu is changed to a radio button. In this case, POM helps to identify the page or screen to be modified. As every screen will have different java files, this identification is necessary to make the required changes in the right files. This makes test cases easy to maintain and reduces errors.
- **Helps with reusing code**: As already discussed, all screens are independent. By using POM, one can use the test code for one screen, and reuse it in another test case. There is no need to rewrite code, thus saving time and effort.
- **Readability and Reliability of scripts**: When all screens have independent java files, one can easily identify actions that will be performed on a particular screen by navigating through the java file. If a change must be made to a certain section of code, it can be efficiently done without affecting other files.


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

They reports are also integrated into the Maven build process: the following code in the `pom.xml` file causes the reports to be generated automatically once all the tests have completed when you run `mvn verify`

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

# Interview material 
The execution of this project can be seen in `https://streamable.com/b9u088`

My submitted report can be found in this repositories in `Report.7z`
