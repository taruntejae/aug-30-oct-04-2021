* Create a table __topics__ with the following fields
* id int(primary key), title(varchar) and duration (number)
* Implement __TopicDao__ that has the following methods

``` java

	void addTopic(String title, int duration); //DOES NOT ALLOW DUPLICATION
	List<Topic> getTopics(String title);
	boolean topicExists(String title); //true if exists, false if not present	

```

* Implement a __ConferenceService__ class that uses TopicDao to insert and get the topics

``` java 

public class ConferenceService {
	public true addTopic(String title, int duration) {
		//true if succesfully inserted
		//false if insertion fails
	}
	public List<Topic> getAllTopics() {
	
	} 
}

```

* Inject __ConferenceService__ in your main class and add few topics and display them on the console. Handle exceptions wherever required

