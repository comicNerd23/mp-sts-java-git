package com.moulik.spring.security;

/**
 * How Authentication happens is with the help of AuthenticationManagerBuilder. To get a hook to this builder, we need to
 * extend the WebSecurityConfigurerAdapter and override the configure(AuthenticationManagerBuilder auth).
 * To configure an inMemoryAuthenticationManager, we configure it as follows: (it uses builder pattern to achieve method 
 * chaining)
 * 
 * 	public void configure(AuthenticationManagerBuilder auth) {
 *		auth.inMemoryAuthentication()
 *			.withUser("moulik")
 *			.password("somepassword")
 *			.roles("USER")
 *			.and()
 *			.withUser("manthan")
 *			.password("somepassword")
 *			.roles("USER");
 * 	}
 * 
 * We also need to make sure of one thing. It is not a good practice to save passwords as clear texts. So we need to provide
 * the spring boot a mechanism to use hashing on the passwords before storing. We do that by providing it a bean
 * 
 * 	@Bean
 * 	public PasswordEncoder getPasswordEncoder() {
 * 		return NoOpPasswordEncoder.getInstance();		//Save it as normal text. Deprecated.
 * 			OR
 * 		return new BCryptPasswordEncoder();				//Hash it using this encoder before storing. Included Spring Security
 * 	}
 *
 */
public class SSAuthenticationConfig4 {

}
