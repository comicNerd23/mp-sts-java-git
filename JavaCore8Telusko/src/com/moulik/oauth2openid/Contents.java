package com.moulik.oauth2openid;

/**
 * OAuth 2.0 and Open ID Connect:
 * 
 * The basic forms of authentication and authorization are simple login or forms authentication. In this, once the user 
 * enters the creds, it goes to a db. The creds are authenticated (Since the password is stored in a hash format, Hash the
 * password, Verify Hash, Lookup user info, Look up Authorization Info). After successful authentication, the application 
 * will create a cookie in the web browser for the session to store the session info of the user.
 * 
 * This type of doing authentication like this inside your application (like in a homegrown way) has some flaws. 
 * 
 * 1. Security: You will have to manage all the security associated with the users
 * 2. Maintenance: You should keep up to date with the best practices in security industry such as storing user info 
 * secured or store passwords in a hashed way.
 * 
 * OAuth 2.0 and OpenId Connect are becoming the industry best practices for solving these problems.
 * 
 * At its core, OAuth 2.0 is just an authorization framework, granting clients access to protected resources via an 
 * authorization server.
 * 
 * Identity use-cases (Pre-2010)
 * 	Simple Login (Forms and Cookies)				Authentication
 * 	Single Sign-on across sites (SAML)				Authentication
 * 	Mobile App Login								Authentication
 * 	Delegated Authorization: How can i let a website access my data (without giving it my password)? Authorization
 * 
 * Delegated Authorization works like this:
 * 
 * On the application (like Yelp), you will have a button like "Connect with Google/Link to Google". You click the button 
 * and you are redirected to the google website, where you are prompted to login to your google account. After logging in,
 * you get a prompt box that an application (Yelp) is trying to access your information in Google account. Once user 
 * consents to this, you will redirected to your starting application (Yelp) and now your application (Yelp) can access 
 * the apis from Google. 
 * 
 * 
 * OAuth 2.0 terminology:
 * 
 * 	1. Resource Owner: The user who owns the data that the application (Yelp) wants to get to
 * 	2. Client: The application (Yelp) that is trying to access the data
 * 	3. Authorization Server: The authorization entity (accounts.google.com) that will be used to authenticate the info
 * 	4. Resource Server: The server that holds the data that application wants to get to. E.g Google Contacts API
 * 	5. Authorization Grant: This is an entity that client is trying to get from the authorization server. That means, when
 *  the resource owner gives the consent, this grant is given to the client application.
 *  6. Redirect URI: This is the callback URL or the URL to go to when the users allows access.
 *  7. Access Token: This is the actual thing that the client gets when it gets the authorization grant.
 *  
 * OAuth 2.0 authorization Code flow:
 * 
 * A resource owner is sitting at a desk and logged into yelp website. Once he clicks on the "Connect with Google" button, 
 * he is redirected to the authorization server like accounts.google.com. When this redirect is happening, already some 
 * data is also being passed like Redirect URL, that is, considering the user gives the consent, this is the URL that the
 * user should be redirected to "yelp.com/callback". Other type of data is also being passed such as a Response Type:Code 
 * to tell what type of Auth-grant needs to be passed. E.g Authorization Code Grant. After consent, the flow is redirected
 * back to the redirect URI with the authorization code. Now the client can't do much with this auth code. But what it can
 * do is go to the authorization server and exchange it for an access token. Once it does that, whenever the client wants 
 * to access the resource server, e.g contacts.google.com, it can attach this access token with the request. Normally, a 
 * client won't be able to access the contacts but with this access token, the client can't do just anything with the 
 * contacts. Maybe the client can read-only.
 * 
 * 
 * 	8. Scope: The granular entity which decides the level of access that the client wants or the authorization server gives.
 * 	The authorization server might understand a specific list of scopes. e.g contacts-read, contacts-write, email-read, 
 * 	email-delete etc.
 * 	9. Consent: The entity that is created by the auth server to ask for the consent of data based on the scope(s) 
 * 	requested by the client.
 * 
 * So the access token that the client gets is specifically scoped to the particular scopes like profile contacts.
 * 
 * Ques: Why do we have two entities? One authorization code and one access token?
 * We have two places where we are having our data. Back Channel (highly secure channel) e.g Google API is highly secure 
 * with HTTPS and SSL and can't  be intercepted. Then we have Front Channel (less secure channel) e.g. The browser is 
 * secure but someone can check the data stored in the browser using the developer tools or look over the shoulder of a 
 * user and check the password being entered in the browser. 
 * So the way this flow is designed is it utilizes the best things about the front channel and the best things about the 
 * back channel and combines them to make sure that the flow is highly secure. So, all the transactions till we get the 
 * authorization code happen on the front channel (browser), but the exchange of authorization code for the access token 
 * happens on the back channel so that no one can intercept it. Then the communication with the resource server with the 
 * access token is also done on the back channel. The back channel is made secure with the help of a secret key. This is 
 * a one-time thing where we go to the google server, we create a client. So a client will get a client id and a client 
 * secret.
 * 
 * O Auth 2.0 Flows:
 * 
 * 1. Authorization Code (Front channel and Back Channel)
 * 2. Implicit (Front Channel Only): In this case, skip the exchange step and get the token directly instead of auth code.
 * E.g in case of Pure JS app like a SPA in Angular App or React App. A little bit less secure than Auth Code flow.
 * 
 * 3. Resource Owner Password Credentials (Back Channel only)
 * 4. Client Credentials (Back Channel only): machine to machine or service based.
 * 
 * OAuth was originally invented to solve the delegation problem. But it became so popular that people started using it 
 * for Authentication as well.
 * Using OAuth 2.0 for authentication is bad because in OAuth there is no standard way of getting the user's information, 
 * every implementation of OAuth is a little different, no common set of scopes.
 * To mitigate this authentication issue, a new Protocol was designed on top of OAuth 2.0 called OpenId Connect.
 * 
 * What OpenId Connect adds:
 * 	1. ID Token
 * 	2. UserInfo endpoint for getting more user information
 * 	3. Standard set of scopes
 * 	4. Standardized implementation
 * 
 * So the OAuth 2.0 flow when requires authentication adds in the scope 'openid' as well.
 * This ID Token is also called JWT Json Web Token. JWT has 2 parts: header, payload and signature. Signature is to verify
 * that the token was not modified in flight. Payload contains the info about the user. If the info in the payload is not
 * enough, then application can call the userinfo endpoint using the Access Token.
 * 
 * Use OAuth 2.0 for: Granting access to your API, Getting access to user data in other systems (Authorization)
 * Use OpenID Connect for: Logging the user in, Making your accounts available in other systems (Authentication)
 * 
 * Ques: Which grant type (flow) should i use:
 * 	1. Web application with server backend: Authorization code flow
 * 	2. Native mobile app: authorization code flow with PKCE (Proof Code for Key Exchange)
 * 	3. Javascript app (SPA) with API Backend: implicit flow
 *	4. Microservices and API: client credentials flow 
 *
 */
public class Contents {

}
