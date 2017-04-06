# EGIS Coding Challenge:: Food Trucks

A web application that uses [DataSF](http://www.datasf.org/) service to tell users what types of food trucks might be found near a specific location on a San Francisco Map.

#### The Application is hosted on: https://achavanga-foodtruck.herokuapp.com/

#### The Repository is Hosted on: https://github.com/achavanga/FoodTruck_Challenge/

### The Solution.

This web application is design to assist residence in San Francisco to search for approved Food Trucks information around their location. The application helps the users to search for Food Trucks based on the food type of their choice. The following happen when the user visits the web application:

- When the web page is initialised and it will show the San Francisco map.
- When the user types in the food type of their choice and press Search button, the application will call the [DataSF](http://www.datasf.org/) service to perform the search to get top 20 approved food truck with an expiration date greater than today.
- The map will be updated by the results of the search, showing markers of where the Food Trucks are located on the map.
- The application will show more details on the Food trucks if you click on the marker.
- The application sidebar will show the more details of the result return from the search.
- Each time a new search is performed the map is refreshed with new results.


### Development.

The application was developed using these open source technologies:
- Spark Java Web Framework
- Javascript
- Bootstrap template
- Freemaker
- CSS3
- Google Map Javascript API
- Maven
- Heroku PaaS. [![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

I decided to use the above technologies because:
- I wanted to learn how to use Spark Java Web Framework and Freemaker.
- The application is hosted on Heroku Cloud Platform as I wanted to learn how to Deploy to Heroku.
  
I also used Spark Java because it is easy to use and to deploy to Heroku. The application focuses on the front-end as it takes advantage of using the [DataSF](http://www.datasf.org/) datasource directly. 
I decided to download the bootstrap CSS so as to speed up my development as they are freely available bootstrap templates on google. I used Google Mapp API because I am familiar with it and is easy to use.

The application uses single page with the main page located in src/main/resources/spark/template/freemarker/index.ftl. I am calling the [DataSF] (http://www.datasf.org/) service inside the foodtruck.js loccated in src/main/resources/public/js

### What I would have done better if I had time.

To make the application faster I could have written a service that automatically downloads the copy of DataSF Food Truck data once a day and save it in a local database or a .json file. In this way, the application will just query the database when a user performs a search instead of calling the DataSF each time one searches on the application. I was thinking of using [Apache Camel](http://camel.apache.org/) to do scheduling and save the data in Postgres DB or file.

I could have taken advantage of the WebSQL in HTML5 to cache the copy of DataSF data.  

I could have added filters on the screen so that users can add more search parameters that can help in improving the results that the get back from the service.

I could have added a Help menu so that user learn on how to use the application.

I could have added Unit, Front-end and integration tests using JUnit, Mockito or Selenium.

### NOTE

I didn't add the function to locate the user's current location as it was causing issues if the user was not in San Francisco.

### Conclusion

I enjoyed taking part in this challenge as I was able to use new tools that I haven't used before like Spark and Heroku. I will continue to refactor and perfect this application to include the above shortfalls.

## Documentation

For more information about me

- [Chavanga Abel](https://www.linkedin.com/in/achavanga/)
