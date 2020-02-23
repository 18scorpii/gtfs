# DB Model

## API

- Using Spring Data REST, the repo is directly exposed on HTTP
- Security and access controls are to be added
- Swagger is available @ []()
    - springfox Bug fixed in [3.0.0-SNAPSHOT](https://github.com/springfox/springfox/issues/2581)
- API Docs @ [http://localhost:8090/gtfs/v2/api-docs](http://localhost:8090/gtfs/v2/api-docs)
- Swagger UI @ [http://localhost:8090/gtfs/swagger-ui.html](http://localhost:8090/gtfs/swagger-ui.html) 

## Data Loading

- On start up the data is loaded using a Command Line Runner
- Annotated declaration of data files are to be added  

## Persistance

- Data is stored in a In-memory H2 database
- This is available @ [http://localhost:8090/gtfs/h2-console](http://localhost:8090/gtfs/h2-console)
- Permanent persistance to be added  

## Sample Usecase

- The data used is [NJT - New Jersey Transit](https://transitfeeds.com/p/nj-transit)

 