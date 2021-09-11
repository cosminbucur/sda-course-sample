### configuration
- write a HibernateUtil for a mysql db

### types
- map an entity using the most common annotations:
    - map a Long, String, LocalDate, int, boolean
    - map an enum field (@Enumerated)
    - map an embedded field (@Embedded)

### associations
- write examples of two objects with relationship:
    - on-to-one
    - one to many unidirectional (with join column)
    - one to many bi-directional
    - many to many
  
### CRUD
- implement a CRUD DAO using Hibernate Session:
    - create
    - findById
    - update
    - delete
- write integration tests for each CRUD method
- use for DAO methods:
    - try with resources
    - transaction management

### queries
- implement a CRUD DAO using HQL (hibernate query language)
- implement a CRUD DAO using native SQL queries
- implement a few methods using named queries

- write an integration test for each CRUD method