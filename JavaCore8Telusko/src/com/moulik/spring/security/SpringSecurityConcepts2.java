package com.moulik.spring.security;

/**
 *  There are 5 key concepts associated with Spring Security.
 *  1. Authentication
 *  2. Authorization
 *  3. Principal
 *  4. Granted Authorities
 *  5. Roles
 *  
 *  Assume a security guard outside a very secure building like a Bank Vault/Museum. The security guard usually asks these
 *  2 things: Who are you?   and	What do you want?
 *  Spring Security is the security guard for your application.
 *  Authentication is the process of identifying the person requesting a resource. (Answers Who are you?)
 *  Authorisation is the process of identifying the actions that an authenticated user can perform. (Answers What do you 
 *  want?)
 *
 *	Principal is the entity(person) that has been authenticated. A logged-in-user is the Principal.
 *	Granted Authority is the authority that an entity has. Each Principal can have one or more granted authorities.
 *	Role is a group of granted authorities to easily maintain the authorities associated with an entity.
 */
public class SpringSecurityConcepts2 {

	public static void main(String[] args) {

	}

}
