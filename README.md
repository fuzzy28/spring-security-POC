Spring-security-POC
----------------------------
A POC on spring-security which includes simple in memory authentication and authorization. Used tiles as view (simple implementation). JUnit for Unit testing.

Features:

* In memory authentication (will release with database layer)
* Allowed session concurrency = 1 (invalidate 1st session)
* Authorization using spring-security taglib
* Tiles as view layer
---------------------------
Deployment guide:

clone via git. build/deploy using maven

>mvn tomcat:run

Users:

u:admin p:admin roles: ROLE_USER, ROLE_ADMIN 
user:user roles: ROLE_USER

---------------------------

Screenshots:

> mvn tomcat:run

![Alt text](https://github.com/ultragaylord/spring-security-POC/tree/new/tiles/screenshot/mvntomcatrun.jpg?raw=true)
