* In this lab you’ll practice using Jdbc with Spring.
* Create a package __com.jpmc.lab04__

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


* Implement these classes using JDBC with Spring.

``` java
public interface AccountDao {
	void deposit(int accountNumber,int amount);
	void withdraw(int accountNumber,int amount);
}

public class AccountDaoImpl implements AccountDao {
  public void deposit(int accountNumber,int amount) {
	  //update balance in accounts table
  }
  public void withdraw(int accountNumber,int amount) {
	  //update balance in accounts table
  }
}

public class AccountService
{
	private AccountDao accountDao;
	public void deposit(int accountNumber, int amount) {
		//call AccountDao’s deposit method
	}
	public void withdraw(int accountNumber, int amount) {
		//call AccountDao’s withdraw method
	}
}
```

* Have a client say __AccountUser__ that creates application context and loads __AccountService__ to call the deposit and withdraw methods

* Use proper annotations wherever required.
* Remember: __AccountUser talks to AccountService and NOT account dao classes__

* Configure your beans in __lab04-beans.xml__ file and db information in a properties file
