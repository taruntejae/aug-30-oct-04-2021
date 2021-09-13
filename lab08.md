* In this lab you’ll practice relationships in JPA.
* This lab is an extension of __Lab04__
* Create a package __com.jpmc.lab08__

* Create a database __'accountsdb'__
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

* Create a table __statements__ with 4 columns

```
id number primary key
account_number varchar  (Foreign key)
amount int
type varchar
```

* Create Account and Statement Entity classes. Relate them using @OneToMany and @ManyToOne


* Implement these classes using JPA with Spring.

``` java
public interface AccountRepository {
}


public class AccountService
{
	private AccountRepository accountDao;
	public void deposit(String accountNumber, int amount) {
		//update balance in accounts table
	  	//INSERT A RECORD IN Statements table with type as 'CREDIT'
	}
	public void withdraw(String accountNumber, int amount) {
		  //update balance in accounts table
		  //INSERT A RECORD IN Statements table with type as 'DEBIT'
	}
}
```

* From main() call the deposit and withdraw methods. 


