# Lab 5 - Multi-layer application testing with SpringBoot

### Identify a couple of example on the use of AssertJ expressive methods chaining

In the testing file `EmployeeRestControllerIT` , we can find two examples of method chaining expressions allowed by AssertJ, where the first one is:

```java
assertThat(found).extracting(Employee::getName).containsOnly("bob");
```

And the other one, is the following:

```java
assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");
```

On the file `EmployeeRepositoryTest` , and more exactly in the method `givenSetOfEmployees_whenFindAll_thenReturnAllEmployees()`, we can find another example:

```java
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
```

### Identify an example in which you mock the behavior of the repository (and avoid involving a database). 

On the `EmployeeService_UnitTest` file, in the setup of each one of the tests of  it, `setUp()`, there are a couple example when the behaviour of the repository is mocked, one of them is the following:

```java
Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);
```

 ### What is the difference between standard @Mock and @MockBean?

On one hand the standard @Mock  anotation is used to mock the behaviour of a certan  class or an interface and to record and verify behaviours of it, during test executions. On the other hand, @MockBean anotation is used to mock objects in the context of SpringBoot Application, giving the behaviours need for the context( Dependency Injection):  "If a bean, compatible with the declared class exists in the context, it replaces it by the mock. If it is not the case, it adds the mock in the context as a bean."

### What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

This file  is used to implement all the properties needed, usually to connect with other  services to the context of the Application , like database credentials and urls. It can be used by our tests to connect to a real database.

