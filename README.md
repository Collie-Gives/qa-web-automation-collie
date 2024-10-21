### Test Automation for the application
### Description and context
---

You can choose the plan for the strategic planning and business intelligence software, these plans can be paid by monthly or annual period, also the plans come in basic and platinum. You only need a computer with an Internet connection and you will have everything at your fingertips at any time and any place.

To run the user story you can call each specific runner, the path of each runner class is as follows: “src/test/java/com/reto/runners/”

### Coding summary
---
The code is documented and the Document generation was done with JavaDoc.

### Command for Execution
---
For the execution of the automation the following command can be used for the execution of a particular runner:

gradle clean test --tests “RUNNER RUNNER” aggregate -i

Example:

gradle clean test --tests features.runner_examples.runners_register.RegisterRunner aggregate -i


### The framework
---
## BDD
BDD is used as an automation framework for the automation of the test scenarios, the idea is to write the tests before writing the source code, but instead of unit tests, we will write tests that verify that the behavior of the code is correct from the business point of view. After writing the tests we write the source code for the functionality that makes these tests pass correctly. Then we refactor the source code.
We start from user stories, following the model “As [role ] I want [ feature ] so that [benefits]”. From here, instead of describing in 'natural language' what that new functionality has to do, we are going to use a language that is going to allow us to describe all our functionality in the same way, a BDD-specific language.
## Gherkin
Gherkin is used as a language of development of the functionalities since it is a language understandable by humans and computers, with it we are going to define the behavior of the page that we are going to automate.
It is a language easy to read, easy to understand and easy to write. Using Gherkin will allow us to create a living documentation at the same time that we automate the tests, doing it with a language that business can understand.
The good thing about Gherkin is that to start making BDD we only need to know 5 words, with which we will build sentences with which we are going to describe the functionalities:
- Feature: indicates the name of the functionality we are going to test. It must be a clear and explicit title. We include here a description in the form of a user story: “As [role] I want [feature] so that [benefits]”. On this description we will start building our test scenarios.
- Scenario: Describes each scenario we will test.
- Given: Provides context for the scenario in which the test will be executed, such as where the test is executed, or prerequisites in the data. It includes the necessary steps to put the system in the state to be tested.
- When: Specifies the set of actions that launch the test. The user interaction that triggers the functionality to be tested.
- Then: Specifies the expected result of the test. We observe the changes in the system and see if they are the desired ones.
  It is normal to test different scenarios to check a certain functionality. In this way we are going from our user stories to automated behavioral tests.
## Cucumber
Cucumber is used as a tool to automate the tests in BDD. Cucumber will allow us to execute functional descriptions in plain text as automated software tests. Fully compatible with the Gherkin language.

### Compiler
---
The project is created on Gradle, it is a tool for automating the construction of our code, it is the improved version of Maven, but it tries to take everything one step further. To begin with, it relies on Groovy and a DSL (Domain Specific Language) to work with a simple and clear language when building the build compared to Maven. On the other hand, it has a great flexibility that allows working with it using other languages and not only Java. On the other hand, it has a solid dependency management system.

### Development patterns
---
The following development patterns were used for the development of the automation:
Variables: camelCase
Functions: camelCase
Classes: PascalCase
Packages: camelCase

Camel Case: The name comes because it resembles the two humps of a camel, and can be divided into two types:
- Upper Camel Case, when the first letter of each of the words is capitalized. Also called Pascal Case. Example: NomenclatureExample.
- Lower Camel Case, the same as the previous one with the exception that the first letter is lowercase. Example: exampleOfNomenclature.
  It is widely used in Twitter #hashTags or in languages such as Java, PHP, C#...

### Automation practices.
---
A project where the use of the serenity pattern is exemplified.
[screenplay](http://thucydides.info/docs/serenity-staging/#_serenity_and_the_screenplay_pattern) with cucumber and gradle.

The tests use tasks (tasks), interactions (interactions), questions (questions), page elements (user_interface) and basically have the following structure at the automation project level.

+ model
  Classes using the DTO pattern or related to the domain model.
+ tasks
  Classes that represent tasks performed by the actor at the business process level.
+ interaction
  Classes that represent the direct interactions with the user interface
+ user_interface
  Page Objects and Page Elements. They map the user interface objects
+ questions
  Objects used to query about the status of the application.

### Automation tool used
---
Intellij IDEA IDE is used for automation development. Intellij IDEA is a development platform, designed to be extended indefinitely through plug-ins. It was conceived from its origins to become a platform for integration of development tools. It does not have a specific language in mind, but is a generic IDE, although it enjoys great popularity among the Java language developer community using the JDT plug-in that is included in the standard IDE distribution.
It provides tools for workspace management, writing, deploying, running and debugging applications.

### Automation Strategy
---
Initially the flows of each transaction were collected, to know the business and to be clear about what should be automated.
Once the scope was clear, we proceeded with the automation of the transactions, for this it was decided to automate by front layers.

### The version used was Java and Gradle.
---
To run the project you need Java JDK 17 or higher and Gradle preferably with version 8.2 or higher.