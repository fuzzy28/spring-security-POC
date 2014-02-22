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

![Maven Screenshot](https://raw.github.com/ultragaylord/spring-security-POC/new/tiles/screenshot/mvntomcatrun.png)

---------------------------
Login Page
![Maven Screenshot](https://raw.github.com/ultragaylord/spring-security-POC/new/tiles/screenshot/loginpage.png)

---------------------------
Common Page - Admin user is currently logged. Admin Menu and User Menu available.
![Maven Screenshot](https://raw.github.com/ultragaylord/spring-security-POC/new/tiles/screenshot/commonpage.png)

---------------------------
User Page - Admin Menu not accessible
![Maven Screenshot](https://raw.github.com/ultragaylord/spring-security-POC/new/tiles/screenshot/userpage.png)

---------------------------
Denied Page - Using user account and attempt to access secured page.
![Maven Screenshot](https://raw.github.com/ultragaylord/spring-security-POC/new/tiles/screenshot/denied.png)

---------------------------
404 Page - Replace Tomcat generic 404 page with custom page
![Maven Screenshot](https://raw.github.com/ultragaylord/spring-security-POC/new/tiles/screenshot/404.png)



