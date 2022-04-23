package com.moulik.spring.security;

/**
 * OAuth Terminologies: (In context of a scenario of a photo printing service and google drive service)
 * 
 * 1. Resource: aka Protected Resource, something that is being sought/something that a user wants to access. E.g the photos
 * on the Google Drive.
 * 2. Resource Owner: An entity (user) capable of granting access to a protected resource. 
 * 3. Resource Server: The server hosting the protected resources. (Google Drive)
 * 4. Client: An application making protected resource requests on behalf of the resource owner and with its authorization.
 * Here it is the photo printing service.
 * 5. Authorization Server: The server issuing access tokens to the client. Here it is google auth-service.
 * 
 * Flows:
 *  OAuth Flow 1: Authorization Code Flow (Safest)
 *  1. The resource owner logs in to the client and tells it to access the resource.
 *  2. The client goes to the Authorization Server to access the resource.
 *  3. The Authorization Service goes to the resource owner to give consent to access.
 *  4. The Resource owner gives consent for access to the auth service.
 *  5. The authorization service gives a Authorization Token to the client.
 *  6. The client contacts the authorization service with this auth token to get the access token
 *  7. The authorization service gives the access token to the client.
 *  8. The client request the resource server to access the resource using the access token.
 *  9. The resource server validates the token (either on its own or by connecting to the authorization server). After
 *  successful authentication, it provides the resource to the client.
 *  
 *  OAuth Flow 2: Implicit Flow
 *  1. The resource owner logs in to the client and tells it to access the resource.
 *	2. The client goes to the Authorization Server to access the resource.
 *  3. The Authorization Service goes to the resource owner to give consent to access.
 *  4. The Resource owner gives consent for access to the auth service.
 *  5. The authorization service gives a Access Token to the client.
 *  6. The client request the resource server to access the resource using the access token.
 *  7. The resource server validates the token (either on its own or by connecting to the authorization server). After
 *  successful authentication, it provides the resource to the client.
 *  
 *  Drawback of Implicit Flow: Not as secure. (If somebody (hacker) gets the access token, they can access the resource)
 *  Primarily used with short-lived access tokens
 *  Used with Javascript apps
 *  
 *  OAuth Flow 3: Client Credentials Flow (Useful for Authorization between micro-services)
 *  Here the client is well trusted (confidential clients)
 *  1. MicroService1 wants to connect to Microservice2 to get profile info from the database. So it goes to the auth server
 *  and provides a key.
 *  2. The auth server validates using the key and gives an access token for the access the profile in the database.
 *  3. MS1 goes to MS2 with access token to access profiles info.
 *  4. MS2 validates the token and gives the resource, ie profiles info.
 */
public class OAuthTermsFlows14 {

}
