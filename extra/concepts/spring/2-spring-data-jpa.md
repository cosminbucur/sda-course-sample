### config
- write a command line runner to setup initial data
- setup persistence in the following ways:
    - override spring boot autoconfiguration in application yml (spring.datasource)
    - create a spring persistence jpa config using hibernate as implementation (@Configuration)
    - create a spring h2 config for the test scenarios
- setup a dev profile and a test profile in the spring configuration

### repository layer
- write an interface that extends JpaRepository and implement:
    - a derived query (findBy<Property>)
    - a native query (@Query)

### service layer
- write a service for and implement:
    - findAll paginated
    - findAll sorted by a property

### testing
- write a unit test for each service method (@Mock repository)
- write an integration test for each service method (no mocks)