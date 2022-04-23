package com.moulik.spring.security;

/**
 * OAuth was originally meant for Authorization. But it became so popular that people started using it for authentication.
 * So, to use it for authentication, we use a layer on top of OAuth 2.0 called OpenIdConnect.
 * For Authentication, instead of you building your own authentication mechanism from scratch, you use the authentication
 * mechanism of popular services like Google or Facebook or LinkedIn. Once the resource owner gives consent, your app can
 * access the profiles data of these services and store it in the securityContextHolder to simulate a logged-in user.
 * 
 * 
 * Create a SB project with dependencies: web, security, spring-security-oauth2-autoconfigure:2.1.8.RELEASE
 * Then add @EnableOAuth2SSO to your main class in SB app.
 * Also you need to tell the facebook or google app beforehand of the app that is going to access it for OAuth.
 * Then set up configuration in application.properties or yml regarding the google-api or facebook-api. 
 * 	security.oauth2.client.
 * 		clientId, clientSecret, accessTokenUri, userAuthorizationUri, tokenName, authenticationScheme
 * 	and security.oauth2.resource.userInfoUri
 * 
 * It might not always be a good idea to use OAuth. 
 * 	1. The access token may be used by 
 * 	2. The sign-in should happen every time because the account must be current.
 *
 */
public class SSWithOAuthFacebookGithub15 {

}
