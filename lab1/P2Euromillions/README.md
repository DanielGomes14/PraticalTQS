# Exercise 2 - EuroMillion Draw

In this exercise, along side the `JUnit` testing framework,  it was used the `JaCoCo` library which aims to perform what is denominated as **Code Coverage**: a software metric that is used to check  how many lines of code are being executed during our automated tests.

## JaCoCo Maven Configuration

In order to  use  JaCoCo, we need to specify a maven plugin in  the `pom.xml` file:

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.7.7.201606060606</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>prepare-package</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

 ## Generate Report

To generate the JaCoCo report we can simply run the following command:

```
mvn test jacoco:report
```

## Obtained Results 

After opening up  the `index.html` file in the Browser, present on the  directory `target/site/jacoco ` , that was generated,  I got the following Results.



![image2](/home/danielgomes/Desktop/TQS/Praticas/aula01/ex2/image2.png)

![image3](/home/danielgomes/Desktop/TQS/Praticas/aula01/ex2/image3.png)

![image4](/home/danielgomes/Desktop/TQS/Praticas/aula01/ex2/image4.png)

As we can see a really great part of the code  has been covered by the tests that were written.

