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



















































