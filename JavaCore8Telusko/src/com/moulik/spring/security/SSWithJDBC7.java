package com.moulik.spring.security;

/**
 * For telling spring boot that you want jdbcAuthentication enabled, similar to previous, instead of inMemoryAuthentication,
 * use jdbcAuthentication. 
 * Now, next step is to tell the dataSource that will be powering the database connections etc. Since we added H2 database
 * in our application, SB will automatically configure this and autowire it in this class/component.
 * Now, we should tell SB how the schema of this database should be and the users that are populated in that schema.
 * SpSec has some opinionated behavior in this scenario. If we don't provide any data in the schema, then SpSec will create
 * all the users and authorities for us.
 * 
 * 	@Autowired
 * 	DataSource dataSource;
 * 
 * 	public void configure(AuthenticationManagerBuilder auth) {
 *		auth.jdbcAuthentication()
 *			.dataSource(myDataSource)		//Here datasource will be automatically provided by Spring Boot.
 *			.withDefaultSchema()
 *			.withUser(
 *				User.withUsername("user")
 *				.password("password")
 *				.roles("USER")
 *			)
 *			.withUser(
 *				User.withUsername("admin")
 *				.password("password")
 *				.roles("ADMIN")
 *			)
 *			
 * 	}
 * 
 * But this is not really the behavior of real world application. In a real world app, you would create a bunch of users
 * from a sql file. So in a SB app, we do it in a schema.sql file under resources folder. 
 * Similarly to insert the data into these tables, we put it in a data.sql file under resources folder.
 * 
 * In Prod apps, if the schema is different, then you can configure that in the configure().
 * 
 * 	public void configure(AuthenticationManagerBuilder auth) {
 *		auth.jdbcAuthentication()
 *			.dataSource(myDataSource)		//Here datasource will be automatically provided by Spring Boot.
 *			.usersByUsernameQuery("select username, password, enabled from users where username = ?")
 *			.authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
 *			
 * 	}
 * 	
 * If you need to use a new database, then all you need to do is configure it in the application.properties
 * 	spring.datasource.url=
 * 	spring.datasource.username=
 * 	spring.datasource.password=
 * 
 * 
 *
 */
public class SSWithJDBC7 {

}
