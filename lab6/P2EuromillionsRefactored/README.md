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

![image2](https://github.com/DanielGomes14/PraticalTQS/blob/main/lab1/P2Euromillions/image2.png)

![image3](https://github.com/DanielGomes14/PraticalTQS/blob/main/lab1/P2Euromillions/image3.png)

![image4](https://github.com/DanielGomes14/PraticalTQS/blob/main/lab1/P2Euromillions/image4.png)

###  Which classes/methods offer less coverage? Are all possible decision branches being covered?

The class that offered less coverage was the `CupponEuromillions` with only 40% coverage. The main reason for this was the fact that the `format()`method was not tested in any of the unit tests written. The `Dip` class had a coverage of 87%, which was not 100% just because the auto-generated methods like `hashCode()` or `equals` have not been tested. With exception of the lines 35 and  58 of the Dip class, which are if statements that only were covered in some of the possible decision branches, a  great amount of the decision branches have been covered totally.

As we can see a really great part of the code  has been covered by the tests that were written.

