package com.moulik.spring.security;

/**
 * Objectives:
 * 	Create a new authentication API endpoint
 * 	Examine every incoming request for valid JWT and authorize.
 * 
 * 1. Create a SB project with web, security.
 * Now setup a controller with a resource that needs to be secured.
 * Also setup the authentication using any mechanism. We will implement over own UserDetailsService that will take hard-coded
 * values, but you can also take it from the database/JPARepo.
 * 
 * 2. Now we need to add JWT to it.
 * First we add a JWTUtil class. It will basically have 2 functions:
 * 	generateToken(userDetails) to create a token when a user id is authenticated
 * 	validateToken(String token, userDetails)
 * 
 * Under generateToken(), we create a token using a builder object and set (map) claims, subject, issuedAtTime, expiration,
 * and then we sign it with an algorithm (HS256) and the secret.
 * Using extractClaim(String token, Function<Claim, T> claimsResolver), there is a claims resolver that uses the token to 
 * figure out what the claims are.
 * ValidateToken() uses extractUsername(token) to get the username and validates it. Along with the username check, it also
 * checks if the token is not expired
 * 
 * Step i. A /authenticate API endpoint: it accepts the username and password and returns JWT as response. 
 * First we create a AuthenticationRequest with username and password fields and AuthenticationResponse with jsonWebToken.
 * Next we create a controller which has /authenticate method with POST mapping (because user sends username and password
 * in a POST payload). This mapping is on a method which will validate the creds and send a token in the response.
 * So we call this method, createAuthenticationToken(AuthRequest). In this method, we first take username and password from
 * the authRequest and validate it using AuthManager. In case of incorrect creds, it throws BadCredentialsException.
 * In case of correct creds, we get the userDetails object from the userDetailsService and then use it to generateToken. 
 * Finally using this token, we return the AuthResponse.
 * Since, by default, all endpoints are automatically inaccessible, we need to make this /authenticate allowed in the 
 * configure() of WebSecurityConfigurerAdapter.
 * 
 * Step ii. Intercept all incoming requests: Extract JWT from the header and Validate and set in execution context.
 * 
 * To intercept these request, we need a filter. There is already a filter present. You just need to extend it and implement
 * the filter method yourself. We create a custom filter called JwtRequestFilter and have it extend OncePerRequestFilter.
 * In this filter, we extend doFilterInternal().
 * We extract the JWT token from the header, if it is valid and if SecurityContextHolder does not hold the already
 * authenticated authentication object, we get the userDetails object and set it under UsernamePasswordAuthenticationToken.
 * Finally this token is set under the SecurityContextHolder for it to use under Spring Security.
 * We also need to continue this filter chain, so at the end, we add filterChain.doFilter(request, response).
 * 
 * Just setting a filter is not enough. We need to tell Spring security to use this filter at a specific point in the 
 * filter chain. We do this in the spring security configuration class.
 * 
 * 	public void configure(HttpSecurity http) throws Exception {
 * 		...
 * 		and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
        and().addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
 * 
 * 
 * 
 * 
 *
 */
public class SSWithJWT12 {

}
