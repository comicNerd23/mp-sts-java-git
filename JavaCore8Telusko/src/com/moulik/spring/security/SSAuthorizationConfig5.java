package com.moulik.spring.security;

/**
 * Consider a Sb app which has Spring security and it has in-memory authentication for some users. (It does not matter
 * if these users are inmemory, or from database or Oauth users). We just need 2 types of users. One with some role that is
 * for accessing some resources and another with some role that is for accessing some other resources.
 * 
 * 		API				Roles
 *		/				All (unauthenticated)
 *		/user			USER and ADMIN roles
 *		/admin			ADMIN role
 *
 *	public void configure(HttpSecurity http) throws Exception {
 *
 *		http.authorizeRequests()
 *			.antMatchers("/admin").hasRole("ADMIN")
 *			.antMatchers("/user").hasAnyRole("USER", "ADMIN")
 *			.antMatchers("/").permitAll()
 *			.and()
 *			.formLogin();
 *			
 *	}
 *
 *	Spring Security also creates a logout page similar to login page.
 */
public class SSAuthorizationConfig5 {

}
