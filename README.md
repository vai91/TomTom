# TomTom
Tomtom is an application to view Tomcat logs through the browser.

## Installation
This is a Maven project, it will take care of the jars for you.
To run this application, you need a web container (since the application is about viewing the Tomcat logs, I used Tomcat).

### Tomcat configuration
You need to set/find a user name and password to access to the manager panel of Tomcat. 
You can do so by adding it to this file:
```$xslt
$CATALINA_HOME/conf/tomcat-user.xml
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

