# graphql-demo
GraphQL Demo using Spring Boot


# Run project
1. Clone the project
2. Import into Intellij or Just run from command Line GraphqlDemoApplication.java main

#Debug Project
1. Make sure you see this URL working http://localhost:8080/graphql/schema.json
2. By default the Project uses H2 Database. You can connect to H2 using URL http://localhost:8080/h2-console/login.jsp ; ; JDBC URL: jdbc:h2:mem:testdb ; Username: sa; Password: EMPTY Nothing. ; 

#Test the project
1. curl "http://localhost:8080/graphql" -H "Content-Type: application/json" -d '{"query":"{findAllBooks{id title}}"}'
