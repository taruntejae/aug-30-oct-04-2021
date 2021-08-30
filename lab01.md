* In this lab we will practice configuring your beans and accessing them using __ApplicationContext__. The objective of this lab is to get accustomed to the syntax.

* You want to schedule the sessions for a __Conference__. The Conference uses a __SessionPlanner__ for the same. The SessionPlanner loads the topics from a collection.

* The topics are given below.

```
Functional programming with Groovy - 60 min
Scala Tricks - 45 min
Spring unit testing - 50 min
Unit testing JavaScript - 50 min
Concurrency on the JVM - 60 min
Grails for MVC- 45 min
Server side JavaScript - 50 min
```

* The SessionPlanner splits the data to 60 min topics, 45 min topics and 50 min topics.
* Design the Conference and SessionPlanner classes and configure the beans. Configure the topics in a collection in the config file.
* Create a User class that will create an instance of the Conference object and print the total number of 60 min/50 min/45 min topics.

* You can use the __<util:map>__ with __&lt;entry key="" value=""&gt;__ for configuring the topics