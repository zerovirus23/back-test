# Back-test

By Hernan Tenjo

### Conventions
* PROJECT_PATH: Path where the project is located in the local file system

### How to build
    $ cd ${PROJECT_PATH}
    $ mvn clean package

### How to run 
    $ cd ${PROJECT_PATH}
    $ sh target/back-test/bin/webapp
    
### How to authenticate
Basic authentication was configured with the user `admin` and password `123456`

### How to call endpoints:
If you want, you can import the backtest.postman_collection.json located inside the project at root location.
 
 * List (no authentication required)  
 `GET http://localhost:8080/back-test/api/transactions`
 * List by type (Basic Authentication required)  
 `GET http://localhost:8080/back-test/api/transactions/SANDBOX_TAN`   

 * Count by type (Basic Authentication required)  
 `GET http://localhost:8080/back-test/api/transactions/SANDBOX_TAN/count`
 
 * Swagger Docs (no authentication required)  
 `GET http://localhost:8080/back-test/swagger-ui.html`
 
 
 
 ### Comments:
 * SpringBoot was forbidden, however, I used the JavaConfig approach without any web.xml.
 * I understand the requirement for unit test (and I absolutely know the importance of that) but I prefer to spend time doing some of the nice to have requirements.
 * If you want a WAR file to deploy in a external server, just change the pom packaging to war and build again.  
 