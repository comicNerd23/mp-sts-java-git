package com.moulik.spring.security;

/**
 * LDAP (Light weight Directory Access Protocol) is a protocol for accessing and maintaining Directory Information services 
 * over an IP network. A typical usecase for LDAP is to store organizational information such as departments, managers,
 * people reporting etc. 
 * We want SpSec to connect to LDAP.
 * In order to connect to an LDAP Server, we need an LDAP Server. For our purpose, we are going to have an in-memory LDAP
 * dev server. We are going to add the following dependencies:
 * 	com.unboundid:unboundid-ldapsdk							an open source implementation to LDAP server.
 * 	org.springframework.ldap:spring-ldap-core				a spring integration library that works with LDAP.
 * 	org.springframework.security:spring-security-ldap		helps spring-security integrate with LDAP.							
 *
 * To configure Users for LDAP, we need to set these in application.properties
 * 	spring.ldap.embedded.port=8389							port number for embedded LDAP to run
 * 	spring.ldap.embedded.ldif=classpath:ldap-data.ldif		reference to the file that contains this seeded LDAP data
 * 	spring.ldap.embedded.base-dn=dc=springframework,dc=org	root node for embedded ldif
 * 
 * To configure authentication using ldap, we use the inbuilt method under configure(AuthenticationManagerBuilder auth)
 * 	
 * 	auth.ldapAuthentication()
 * 		.userDnPatterns("uid={0},ou=people")
 * 		.groupSearchBase("ou=groups")
 * 		.contextSource()
 * 		.url("ldap://localhost:8389/dc=springframework,dc=org")
 * 		.and()
 * 		.passwordCompare()
 * 		.passwordEncoder(new LdapShaPasswordEncoder())
 * 		.passwordAttribute("userPassword");
 * 
 * 
 */
public class SSWithLdap9 {

}
