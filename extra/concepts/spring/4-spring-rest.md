### config
- use @ConfigurationProperties to load properties from resources
- create a CorsConfig to allow an Angular application to call the backend

### repository layer
- implement a CRUD repository by extending JpaRepository

### service layer
- implement a CRUD service
- use DTOs of type Request, Response
- use a mapper to convert from DTO to entity and vice versa

### security
- configure an in-memory authentication and http basic authorization
- configure a database authentication and http basic authorization

### testing
- write a unit test for each method in service
- write an integration test for each method in the service
- write an integration test for each method in the controller:
    - using mock mvc (@MockMvc)
    - using rest template (RestTemplate)
    - using rest assured (RestAssured)
