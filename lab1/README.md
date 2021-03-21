# JUnit 

## What's JUnit about?
JUnit is an open-source Unit testing framework. However JUnit5, the current version, has some differences from the previous version, which means that it is needed to be careful about its using. We should use this framework to create our unit tests according to a TTD(Test-driven deveploment), and therefore we should create our tests before we write the code that will be tested.

## How to Use It?

If we are using IntelliJ as our IDE, we can simply add the following  **dependency** to our `pom.xml`:

```xml
  <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
    </dependency>
```

However, this will not work by running on CLI(Command-Line), so make sure to add the following **plugin**, if you intent to do so:

```xml
 <!-- JUnit 5 requires Surefire version 2.22.1 or higher -->
  <plugin>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>2.22.2</version>
  </plugin>
```

