* Create a new Spring Boot project **lab012-app** and add __web__, __jpa__ and __mysql or oracle__ templates
* Create a database **accountsdb**
* Create a table __accounts__ with 3 columns

```
account_number varchar primary key
owner varchar
balance int
```

* insert two accounts directly into the database

```
INSERT INTO accountsdb.accounts VALUES('acc101', 'John', 20000);
INSERT INTO accountsdb.accounts VALUES('acc102', 'Ram', 10000);
```

* Given below is the skeleton of __AccountService__ class you need to implement
```java

public class AccountService {
 public void deposit(String accountNumber, int amount) {
	// throw AccountNotFoundException if account is not found
	// update balance in accounts table
 }

 public void withdraw(String accountNumber, int amount) {
	 // throw AccountNotFoundException if account is not found
	// update balance in accounts table
 }
}
```

* Inject **AccountService** in your **BankController** class
* **BankController** is given below

```java
@RestController
@RequestMapping("/bank")
public class BankController {
 @PostMapping("/deposit")
 public String deposit(@RequestParam("accountnumber") String accountNumber, @RequestParam int amount) {
 }
 @PostMapping("/withdraw")
 public String withdraw(@RequestParam("accountnumber") String accountNumber, @RequestParam int amount) {
 }
}
```

* Create the Entities, Repositories and modify the controller and service classes appropriately

