package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}

//Framework : collection of APIs that serves a related purpose
// Spring : for building java based application, simplifies java development using dependency injection, loose coupling
// SpringBoot : to create REST APIs (Representational State Transfer) based on Spring framework
// API : any method in java is an API
// REST API : method with mapping in Controller

// Why Spring boot ?
// It simplifies spring framework based development.
// comes with autoconfiguration approach
// It runs on a specific port of server --> someone which serves something
//Maven --> Project Management Tool --> manages the dependencies used in project --> pom.xml
// On compilation, maven will download all dependencies/libraries from mvn repository and puts in external Libraries directory

/*
 * Spring-MVC : Model View Controller
 * REST CALL -> GET, POST, PUT, DELETE
 * GET : to fetch existing resource
 * POST: to create a new resource
 * PUT : to update an existing resource
 * DELETE : to remove an existing resource
 *
 *
 * MVC Approach : Model View Controller
 * Controller : to accept request, route it to correct resource and return response
 * View : to show desired response in specific way
 * Model : data
 *
 * Vanilla, Cone shape
 *
 * client --> billing counter(Vanilla cone) --> 1 scoop vanilla(data)
 *                                          --> cone (view)
 *                client <-- billing counter(controller)<--> vanilla put in a cone
 * JSON : Javascript Object Notation
 */

