package com.moulik.spring.security;

/**
 * OAuth was originally meant for Authorization and that too not for authorization between client(user) and server(service)
 * but for authorization between services.
 * Consider you have a photo printing business where user give you a digital photo and you make the physical copies and post
 * them to their address. Now consider that users want to have feature where they want to share the photos that they have
 * in their google drive. In this scenario, you app wants to access only the photo section of google drive.
 * This is the place where OAuth helps. It gives authorization access to your API where user is logged into two different
 * services but the two services don't know each other. If these services implement OAuth, then they can easily interact
 * with each other. Once you get access, you get a JWT token.
 * 
 *
 */
public class OAuthTutorial13 {

}
