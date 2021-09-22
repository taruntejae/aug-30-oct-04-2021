* Create lab13-app with Web, JPA and mysql/oracle drivers
* Let's use persons(id, name, age) table in training database
* Create entity, repo and PersonService classes
* You will build a __PeopleController class__ following the RESTful style design
* Implement the following url patterns

``` yml
GET: http://localhost:8080/people
POST: http://localhost:8080/people   (Use @RequestBody to pass person data)
PATCH: http://localhost:8080/people/id/{id}/age/{age}  (Update age)
DELETE: http://localhost:8080/people/id/{id} (Delete person)
GET: http://localhost:8080/people/age/gt/{age} (Age greater than the given value)
```