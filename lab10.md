* Create a servlet __UserRequestTrackerServlet__
* You can access it by using __http://localhost:8080/YOURAPPNAME/tracker__
* This servlet keeps track of number of requests sent by __per user__

* When you access this URL, from say Chrome, for the first time, the output will be

```
Total request count: 1
```	

* When you access this URL, say 100 times, from say Chrome, the output will be

```
Total request count: 100
```	

* When you access this URL, from say Edge or Firefox, for the first time, the output will be

```
Total request count: 1
```	

* When you access this URL, say 100 times, from say Edge or Firefox, the output will be

```
Total request count: 100
```	

* Close the browser and re-open it and check the output