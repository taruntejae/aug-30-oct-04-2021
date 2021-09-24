## Asynchronous communication

* Let's implement two Spring Boot applications that communicate with each other asynchronously using __Messaging Queues__
* For training purpose, let's use a simple MoM __ActiveMQ__
* Two applications talk to each other asynchronously.
* __One application__ sends out a stock symbol say __GOOG__, __INFY__, __FB__
* The __other application__ receives it and displays the current market value
* But these two applications don't talk to each other directly
* __For the sake of simplicity, let's just generate a random number as stock value instead of going to Google Finance or Yahoo Finance__

### Setting up ActiveMQ

* Go to http://activemq.apache.org/activemq-5154-release.html
* Download the zip(for Windows) or tar(for Mac) file
* Extract the zip file
* In Terminal or Command-Prompt navigate to the bin folder 
* Enter **./activemq start**
* Go to the browser and enter *http://localhost:8161/admin/*
* If it prompts for a password enter *admin*

### Two Spring Boot Applications
* Create **Sender** project
* Include __Web, Messaging(Spring for Apache ActiveMQ 5)__ libraries 
* Make sender to run in port __9090__
* Create **Receiver** project with just __Messaging(Spring for Apache ActiveMQ 5)__ library added

#### Sender
* Create a **StockController** class
* Write a method with URL GET mapping **/stock/{symbol}**
* The method accepts a stock symbol like GOOG, APPL, or INTEL as argument
* Have a default response as **You'll receive the stock value soon**

```
@GetMapping("/stock/{symbol}")
public String getPrice(@PathVariable String symbol) {
	return "You'll receive the stock value soon";
}
```

* Autowire a **JmsTemplate** in **StockController**
```
@Autowired
private JmsTemplate jmsTemplate;

```
* Create a *queue* named **StockQueue** in ActiveMQ

* Go to **application.properties** and copy the following

```
server.port = 9090
spring.activemq.user=admin
spring.activemq.password=admin
spring.activemq.broker-url=tcp://localhost:61616

```

* Finally in the method in **StockController** add the following code to publish the stock symbol to StockQueue

``` java

@GetMapping("/stock/{symbol}")
public String getPrice(@PathVariable String symbol) {
	jmsTemplate.convertAndSend("StockQueue", symbol);
	return "You'll receive the stock value soon";
}
```


#### Receiver

* Go to **application.properties** and copy the following

```
spring.activemq.user=admin
spring.activemq.password=admin
spring.activemq.broker-url=tcp://localhost:61616
```

* Create a class **StockQuoteFinder**
* This class will listen for messages in **StockQueue** and whenever it receives a message it's going to print the stock value of that symbol. For the sake of simplicity, let's just generate a random number as a stock value and display it.

```java
@Component
public class StockQuoteFinder {

	@JmsListener(destination="StockQueue")
	public void receiveMessage(String symbol) {
		double price = Math.random() * 1000;
		System.out.println("Price of " + symbol + ": " + price);
	}
```

* Add the following method to the class

* Start sender and receiver applications. Access __http://localhost:9090/stock/{symbol}__ and pass some stock symbols
* Observe the console of the __receive__ application
