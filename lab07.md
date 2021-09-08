* Create or work with an existing Spring boot project. Add JPA and mysql/oracle driver dependencies

* Create a table __topics__ with the following fields
* id int(primary key), title(varchar) and duration (number)
* Implement an Entity class __Topic__ and map it with topics table
* Define __TopicDao__ interface

* Implement a __ConferenceService__ class that uses TopicDao to insert and get the topics

``` java 

public class ConferenceService {
	public boolean addTopic(String title, int duration) {
		//true if succesfully inserted
		//false if insertion fails
	}
	public List<Topic> getAllTopics() {
	
	} 
}

```

* Inject __ConferenceService__ in your main class and add few topics and display them on the console. Handle exceptions wherever required

