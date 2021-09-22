#ToDo
* Composite key in ORM
* Proxy (Lazy loading) in ORM

### JSE 
* Install jdk
* Core java classes 
* Java Standard Edition
* java.nio, java.util, java.io, java.net, java.lang
* Enterprise applications

### Enterprise applications
* banking, e-commerce applications

* Talk to several databases; 
* Talk to several other applications
* Security related features
* Messaging
* High concurrency needs

### JEE

* Web service; library to build
* You can either use this library or a third party library for this
* Library for building transactions support; You can also a third party library
* Library for security; You can use a third party library
* I am going to release specifications or standards; You can use any third party library that CONFORMS to the specifications

* Web applications in Java -> Servlet and JSPs
* Enterprise services like transaction, messaging -> EJB


### Need for spring

``` java
class Account {
	accountNumber, balance;
	deposit(amount) {} //talk to DB, update the balance
	withdraw(amount) {}
	transferFund(to, amount) {}//deducts balance from your account; and credits amount to XYZ account
}
```

* Every time an user logs in to the application, you create an Account object and assign it to him/her.
* When the user logs out, the account object becomes eligible to be GC.

* Object Pooling __Create a pool of Account objects and maintain them__
* Provide Transaction functionality to __transferFund__ method
* Check for credentials and perform another round of security check with __withdraw__ is called

* You have a class called __Customer__. We need these services for Customer class also
* EJB - Enterprise Java Beans
* 

``` java

	interface Account extends Remote {}
	interface AccountHome extends Home {}
	class AccountBean implements EntityBean {
		deposit()
		withdraw()
		transferFund()
		//no constructors
		//no final methods
		//no static methods
		//no private methods
		//no throws keyword
		//no threading code
		//no extending some other class 
	}
	//ejb-jar.xml (specify what services you need)
	
	//create a jar file and then drop them inside the EJB container	

```

* Heavyweight container


### Enters Spring

* Lightweight container that provides all the enterprise level services needed for your code
* NO SERVERS INSTALLED OR CONFIGURED
* POJO framework
* Makes your code very simple, easy to maintain and test
* __Dependency Injection__
* Simple mechanism by which you avoid writing unneccesary creation and lookup code

* __You want to execute a simple SQL query__
* Connection
* Statement
* __Executing query__
* Clean up resources
* Exception Handling

* __Collection of jars__
* 5.x is the latest version

### Usual activity in Spring

* Create a Maven project
* Add Spring 5.x dependency
* Create your classes
* Create __configuration files__
* Start your container


### Java beans

* A Java bean refers to a class with private variables, public getter/setters and a no-args constructor
* Spring framework's only requirement is all classes have to be __Java beans__

### Lifecycle

* ApplicationContext is an active container. It instantiates ALL the beans configured during STARTUP
* All the beans configured in Spring are __SINGLETON__ by default
* __scope__ of the bean can be changed to prototype || request || session
* Managing the lifecycle of the beans
* __lazy-init__ used to defer the instantiation of the beans
* 2 types of DI -> Constructor-based and Property-based
* property-based DI is more often used than constructor-based DI


### Annotations

* Mark the bean as __@Component__
* XML file needs just one liner __context:component-scan__
* Autowire using __@Autowired__
* Can specify the bean you want to autowire by using __@Qualifier__
* __@Value__ for specifying the values
* Change the scope using __@Scope__


### Template classes

* Spring framework provides a lot of __xyzTemplate__ classes
* These template classes encapsulate all the plumbing work required to work with some functionality
* Our code needs to just use these template classes
* JdbcTemplate, JpaTemplate, JmsTemplate, KafkaTemplate, RabbitMQTemplate, RestTemplate, TransactionTemplate
* Wire the template classes in your code


### Jdbc with Spring

* __JdbcTemplate__ is the core
* Use all the methods in this class for CRUD operations
* JdbcTemplate is wired with the data source(connection details)
* This class takes care of all the plumbing work required to talk to a database
* Handles all the checked exceptions and throws unchecked exceptions
* You just need to have a catch for _DataAccessException_



### artifactID

* Every maven project will have a artifactID and groupID and version number
* groupId represents say the project -> __com.jpmc.insurance__
* artifactId represents say the module -> __health__
* version number is say 1.0.1
* __groupId:artifactID:version__ is unique

```
	 <dependency>
		 <groupId>com.jpmc.insurance</groupId>
         <artifactId>health</artifactId>
		 <version>1.0.1</version>
	 </dependency>	 
```


### ORM

* ORM is a concept in CS
* Persisting objects in Databases
* ie., take the data out of the objects and store them in database
* Every object represents a __row__ in a particular table

* .NET uses Entity framework; RoR uses ActiveRecord
* Java uses libraries like Hibernate, Toplink, JDO to implement ORM
* Since we have several libraries to implement ORM in the Java world, the then __Sun Microsystems__ developed a standard
* The standard is called __JPA__
* Now, if you want to use ORM in Java the library should be __JPA compliant__
* Using JPA from Java directly makes us write a lot of code; lot of plumbing work;
* Now, Spring boot makes it easy

#### Some insights into ORM libraries
* Caching; Data and queries are cached; they are not generated or loaded everytime from the database;
* ORM like Hibernate have a very solid caching mechanism


#### Proxy class

``` java
package com.sun.proxy;

class $Proxy65 implements PersonDao {
	//findById
	//deleteById
	//save
	//delete
	
}
```


### Web world

* Frontend (FE) and Backend(BE)
* Frontend development - HTML, CSS, JavaScript(React, Angular, jQuery, Vue)
* Backend development - Python, Java, PHP, ASP.DotNET, JavaScript

* Frontend code -> Code that is executed by the browser environment
* Backend code -> Code that is executed by the server environment (Java)

* __ALL THE CODE resides in the server__
* The frontend is sent to the browser and executed by the browser
* The backend is executed by the server and the output is sent to the browser

* Fullstack = FE + BE

#### Backend code in Java

* Code written in Java resides in the server
* It's executed by the Tomcat container;
* That piece of code is called __Servlet__
* BE or web development in Java involves writing __Servlet code__
* Writing servlet code involves some amount of __plumbing__ :)
* Spring Boot makes writing backend code or servlet code also very easy

```
[project-name]
	pom.xml
	[src]
		[main]
			[java]
			[webapp]	
			[resources]	
	[test]	
		[java]
		[resources]
```

* __webapp__ folder contains html, js, css, images, jsp files 
* __java__ folder contains all the Java code including __Servlets__

* Web applications are packaged as __.war__ files

* Servlets are usually singleton. The same instance of the servlet handles the requests for all clients


#### Java / JavaScript

* Java is a programming language
* JavaScript is a programing language

<br/>

* Java gets executed in the backend. ie., a machine with JDK installed which executes Java code

* Javascript can be executed in the backend as well as in the Frontend. ie., Similar to JDK you need a JavaScript runtime installed to execute javascript code
* What is that JavaScript runtime? __NodeJS__ 
* Every browser has a JS runtime installed. So JavaScript can be executed in the browser or in the backend also

* What is ReactJS or Angular?; It is a framework or collection of libraries to build Frontend javascript applications 
* What is Spring boot?: It is a framework or a collection of libraries to build Java applications 


* __Docker__



### Spring Boot Web

* Create a spring boot application and add "Web" dependency
* This automatically creates an embedded tomcat
* Creates a DispatcherServlet which acts as the main controller. It receives requests from the users and dispatches the request to appropriate controller classes
* As a developer, our job is to just create __RestController__ classes with url mappings _GetMapping, PostMapping, DeleteMapping, PutMapping_ etc
* You don't have to worry about creating servlets, getting the parameters, writing responses; Packaging the application, deploying it in tomcat etc.


#### Service

* Spring boot is used to build services
* A __service__ is a independently running, self-sufficient application on the __web__. It can be accessed using simple mechanisms like HTTP and exchange data in formats like JSON.  
* You don't really need to have a web server or application server to run them. They can run on their own
* They can be scaled up and down. ie., Scalability is the ability to handle more requests. 
* Services can be scaled up by launching more instances of them to handle the increase in requests


* XML-based services or RESTful services
* REST is a style with few semantics that you follow to design your services
* HTTP and JSON data and HTTP verbs as url mapping
* HTTP verbs; get, post, put, delete, patch


### Exception handling in services

* A custom exception is a class that extends __Exception__ or __RuntimeException__
* JVM doesn't care!!! It treats both the same.
* It's the compiler that discriminate. 
* If you throw __Exception__ compiler will force you to have try-catch or throws keyword. __RECOMMENDED and WIDELY USED IN PROJECTS__
* If you throw __RuntimeException__ compiler will just keep quiet. __FOR LAZY PROGRAMMERS LIKE PRABHU__

* In Spring boot you want to generate meaningful information when an error occurs and send it to the user. A mere __try-catch__ block will just handle the exception, but will not be enough to send meaningful responses to the user

* Create a method with the annotation __@ExceptionHandler(<ExceptionType>.class)__
* This method will automatically be called when the particular type exception is thrown in the application


































