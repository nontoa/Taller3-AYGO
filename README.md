# Taller3-AYGO

In the laboratory was implemented a simple web application with the following features:

- Is a secure application, running over HTTPS.
- Allow users to authenticate using a password.
- The application grants integrity and authorization.
- The application allows to create users, login, post and see messages in order of creation, see current users logged-in and all in real-time.

## Context diagram

<img src="https://lucid.app/publicSegments/view/2c432280-b319-48ce-969c-22e998e7422a/image.png">

## Description

The simple web application is made in react js, where the user can create users, login with the respective created user, create posts, see the latest posts in real time and the current active users. The web application is running over HTTPS. The app-service (backend) managed the users authentication and authorization using spring security. All data is persisted in a mongo data base.

## Example doing the exercise

First let's create 3 different users (this operation does't need authentication because at the begining we don't have any user)

<img src="web-app-service/resources/image1.png">
<img src="web-app-service/resources/image2.png">
<img src="web-app-service/resources/image3.png">

We can see that the users are already created in the data base

<img src="web-app-service/resources/image4.png">

Then we can proceed to login with the users created previously (in this step the web-app-service (frontend) is gonna authenticate the users and the app-service (backend) are gonna return a JWT that is gonna be active for 10 minutes)

<img src="web-app-service/resources/image5.png">
<img src="web-app-service/resources/image6.png">

Now we can post any message and the other users can see the message, creation date and the message's owner

<img src="web-app-service/resources/image7.png">
<img src="web-app-service/resources/image8.png">
<img src="web-app-service/resources/image9.png">

Finally we can logout

<img src="web-app-service/resources/image10.png">


## Technology Stack

- ![Java_version](https://img.shields.io/badge/Java-17-lightgrey)
- ![React_version](https://img.shields.io/badge/React-18.2.0-blue)
- ![Spring_Boot](https://img.shields.io/badge/SpringBoot-2.7.5-green)
- ![Spring_Security](https://img.shields.io/badge/Spring_Security-2.7.5-green)
- ![Spring_Boot](https://img.shields.io/badge/Mongo-4.0.8-green)
- ![Spring_Boot](https://img.shields.io/badge/Docker-20.10.17-blue)