# Lab 2 - Mocking Dependencies

## Mockito 

"Mockito is a mocking framework,a library that is used for  effective unit testing of Java apps. Mockito is used to mock  interfaces so that a dummy functionality can be added to a mock  interface that can be used in unit testing". For example, if we do not want to call external services directly, we mock some of their functionalities in the context of our tests

### Consider that we want to verify the AddressResolver#findAddressForLocation, which invokes a remote geocoding service, available in a REST interface, passing the site coordinates. Which is the service to mock? 

The right service to mock is the remote geocoding service, which specifically is the `ISimpleHttpClient` Interface.