package com.moulik.spring.security;

/**
 * 
 * If it is not Spring Boot project but a normal Spring project, then you have to configure the DelegatingFilterProxy by 
 * yourself in the web.xml file. In spring boot it is automatically configured. You just need to add the dependency.
 * 
 * One of the filters that intercepts the request is an AuthenticationFilter which initiates the authorisation process.
 * Think of authentication process that takes some inputs (credentials) and gives some outputs (boolean?). It returns a 
 * Principal, that is the information about the logged-in user.
 * When Spring-Security performs authentication, it keeps track of both the input and output using an object of type
 * Authentication. You can think of it as Data Transfer Object. 
 * The thing that does the actual authentication in Sp-Sec is Provider.
 * An AuthenticationProvider interface has a method called authenticate().
 * So Authentication has methods like 
 * 	getAuthorities(): to check the authorities that this object holds
 * 	getCredentials(): to get the credentials like username, password etc before the authentication has been done
 * 	getPrincipal(): to get the principal object after the authentication has been done
 * 	isAuthenticated(): to check if the request has been authenticated or not
 * 
 * A single app can have multiple authentication strategies. For e.g, username-password, LDAP, SSO based authentication or
 * OAuth based authentication. How Spring handles it is it can have multiple AuthenticationProviders. Each provider can
 * only authenticate based on its own strategy. 
 * In order to deal with multiple authentication provider, there is a special entity called AuthenticationManager. It is 
 * similar to AuthenticationProvider in the sense that it too has authenticate(). A ProviderManager implements 
 * AuthenticationProvider so when we have a request for authentication, it goes through different providers and finds 
 * the one that suits the authentication. It then 'delegates' the authenticate task to this provider. 
 * However in order to tell the ProviderManager what kind of authentication it can support, every AuthenticationProvider 
 * also has supports(). Supports(Authentication auth) takes in an auth object and returns true if it supports this kind of
 * authentication.
 * 
 * What information does a AuthProvider need to do the authentication in general?
 * For Authentication, an auth-provider needs to verify the creds against an Identity store and then provide the user 
 * details such as if user is valid, acct is locked, credential information etc. This is abstracted out in Spring in
 * a UserDetailsService
 * So each auth-provider will have its own way of getting the user, but after the validation, the info that it retrieves
 * will be same. This info is stored in a UserDetails.
 * 	getAuthorities()
 * 	getPassword()
 * 	getUsername()
 * 	isAccountNonExpired()
 * 	isAccountNonLocked()
 * 	isCredentialsNonExpired()
 * 	isEnabled()
 * 
 * In case, the authentication process finds that user is not valid, an AuthenticationException is thrown. This can either
 * be handled at the filter level or it shows on the error page. 
 * 
 * After the authentication process is successful and the authenticationManager provides the auth object with principal, it 
 * takes this auth object and saves it in a ThreadLocal object. This is done so that every subsequent request can use this
 * object. There is a way to associate it in a user session object. That work is done by another filter.
 *
 */
public class HowSSWorks6 {

}
