package com.moulik.spring.security;

/**
 * Structure of JWT:Token with JSON Value
 * It has 3 parts: header, payload, signature
 * If you go to jwt.io website, you can actually see how a JWT in an encoded and decoded format looks like.
 * It is encoded in Base64 format. 
 * The payload contains the session info like the id, name, iat(issuedAtTime) etc.
 * The header contains info like which algorithm is used to sign and the type of token.
 * The header and the signature together are what gives authenticity to JWT. The signature signs the header+'.'+payload with
 * a secret key. So the signature is basically tied to Header and payload. A malicious hacker can try to change the header 
 * or payload, but they would not be able to change the corresponding signature because they would have to have the secret 
 * key.
 * So, in essence, this JWT token is open for everyone to see kind of like a certificate you get after giving an exam. It
 * has all the information open but this data has been verified by a competent authority.
 * 
 * Mechanism:	
 * 1. The client sends username/password for authentication to the server. It can be userid-password/token-based/possession-
 * based or any other authentication.
 * 2. Authentication happens at the server. 
 * 3. The server creates a JWT for future authorization. JWT has the header and payload and it signs it using header and 
 * payload.
 * 4. Server sends the JWT to the client.
 * 5. The client saves the JWT. It can either store it in a local storage or it can store it in a cookie.
 * 6. The client sends it with every subsequent request to the API in the HTTP Header to the server. Http Header is a key-
 * value pair. Key here is 'Authorization' and value is 'Bearer JWT'.
 * 7. The server validates the signature of JWT. For validation, it uses the header and payload and decodes it and computes
 * the signature using the Secret key that it has and compares it with the signature it gets in the token. If it matches,
 * then it allows access. 
 * 
 * Q1: How secure is a JWT if it is readable by anyone?
 * A: There does not need to so much sensitive information about the client like SSN or tax id or birthdate etc. It needs 
 * just another information to know who the user is.
 * 
 * Q2: Since JWT has all the value in it, what if someone steals my JWT and uses it themselves?
 * A: Yes, it can be stoled by some malicious hacker and added into his http-header and sent to the server. The server only
 * checks the authenticity of the JWT token. It does not check who the client is. That is why it needs to be sent over
 * HTTPS and also needs to be used with other authentication and authorization mechanisms like OAuth.
 * 
 * Q3: How do you disable a JWT in case it is stolen by some hacker?
 * A: Compared to session-based authorization, this is disadvantageous with JWT. In case of session-based, if a token is
 * stolen, a session can simply be terminated and then that token will not work. But a JWT cannot be disabled.
 * A workaround is that the server maintains a blacklist of Invalid JWTs. In case the hacker tries with this JWT, it will
 * be checked at the server and won't be able to access.
 * https://gist.github.com/soulmachine/b368ce7292ddd7f91c15accccc02b8df
 * 
 * How to handle JWT expiration:
 * A JWT token that never expires is dangerous if the token is stolen then someone can always access the user's data.
 * So the answer is obvious, set the expiration date in the exp claim and reject the token on the server side if the date 
 * in the exp claim is before the current date.
 * 
 * For Web Apps: If you set the expiration time to 1 week, do not use the token for 1 week. Use it less than a week and get
 * a new token before the old token expires. For example, make the browser send out a request to exchange for a new token 
 * at the sixth day. This is not different than the normal concept of session and cookies.
 * 
 * Accordingly, on the server side, create a restful API named /token/extend which will return a new token if given a valid
 * token.
 * If the user does not use your application for a week, next time he goes to your app, he will have to login again and 
 * this is fine and widely accepted.
 * 
 * How to revoke a JWT token:
 * Sometimes users need to revoke a token, for example, clicking the logout button, or changing the password.
 * 	1. Changing the secret key.
 * 	This will revoke all tokens of all users, which is not acceptable.
 * 	
 * 	2. Make each user has his own secret and just change the secret of a specified user.
 * 	Now the RESTful backend is not stateless anymore. Every time a request comes in the server needs to query the database 
 * 	to get the secret of a user.
 * 
 * 	3. Store the revoked JWT tokens in Redis.
 * 	Use the token as the key and the value is always a boolean true.
 * 	The token will be stored only for a specific amount of time, which is the time in the exp claim, after the expiration 
 * 	time it will be deleted from Redis.
 * 	This way only revokes just one token at a time, perfect!
 * 
 * 
 *
 */
public class JwtStructure11 {

}
