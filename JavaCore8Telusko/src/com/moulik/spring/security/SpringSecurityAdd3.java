package com.moulik.spring.security;

/**
 * 
 * To add spring security to your spring-boot web-app, you need to simply add one dependency:
 * (org.springframework.boot)spring-boot-starter-security
 * 
 * Spring Security adds security to your app using Filters. Filters are used to intercept the requests before they can
 * reach the controller to request a resource.
 * 
 * Default Spring Security behavior:
 * 	1. Adds mandatory authentications for URLs (excluding Error page)
 * 	2. Adds login form
 * 	3. Handles login error
 * 	4. Creates a user and generates a default password for that user
 * 
 * To configure the default username and default password, we need to set them in application.properties
 * Default username is 'user'. Password will be shown when the application starts.
 * 
 *
 */
public class SpringSecurityAdd3 {

}
