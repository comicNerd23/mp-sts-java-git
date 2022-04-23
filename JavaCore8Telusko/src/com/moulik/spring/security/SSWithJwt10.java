package com.moulik.spring.security;

/**
 * JWT is a popular way to do user authorization. Used mostly with Micro-services.
 * Authorization Strategies can be using Session-based token or using JWT. These strategies are because of the stateless
 * property of HTTP.
 * When you try to access a resource, the server tries to authenticate. The server creates a session and keeps track of it.
 * It creates a session id and gives it to you and your browser saves it (mostly in a cookie). Then when you try to access 
 * the secured resources, this session-id is attached with every request and it knows that you are accessing the same 
 * session. This is a popular mechanism for authorization for a monolithic-server web application.
 * However, most modern web-apps have their services on multiple servers behind a load balancer. If we have a session on
 * server 1, then it can check the request and session-id but if it is routed to server 2 or server 3, the session id info
 * will not be there. One solution to this is a shared session cache (Redis) where all the servers can check for 
 * session info. The problem with this approach is that there is one single point of failure. If this redis system goes down
 * all the sessions are down. Instead of this, some implementations follow sticky session pattern. In this, the Load
 * balancer remembers which server the last request was sent to and hence has the session info saved for that request and it
 * will redirect the request to that session itself. This is not much scalable and also not feasible for microservice
 * architecture.
 * Consider that when a client requests a secured resource on the server, instead of the server saving the user session
 * details and giving the client a session-id, it gives the values itself in the form of JSON. This token should be signed
 * to verify that it is a correct token and not some malicious one.	This is how JSON Web Tokens work.
 * 
 * So Session tokens are 'Reference' token. You get a reference back as a session id.
 * JWT tokens are 'Value' tokens. You get the entire values of the session back as payload.
 *
 */
public class SSWithJwt10 {

}
