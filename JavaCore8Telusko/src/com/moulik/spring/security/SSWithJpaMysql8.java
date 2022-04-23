package com.moulik.spring.security;

/**
 * We are going to connect to a mysql database using JPA with Spring Boot and Spring Security Project
 * 
 * We need a new Spring Project with dependencies: web, security, spring-data-jpa, mysql (for drivers that connect to mysql)
 * 
 * To configure the authentication for in memory Authentication, we have auth.inMemoryAuthentication()
 * To configure the authentication for jdbc Authentication, we have auth.jdbcAuthentication()
 * But to configure the authentication for JPA, we don't have such a method.
 * Think of how authentication works, once an AuthProvider tries to authenticate, it gets the user using UserDetailsService.
 * In case of JPA, we will create an instance of UserDetailsService and hand it over to SpringSecurity. This instance will
 * lookup the user using JPA from DB. Since the instance of UserDetailsService that we create is not related to JPA, that's
 * why we don't have a similar method for JPA as we have for inmemory and jdbc.
 * We could have the userdetailsService return users from a text file or hard-coded.
 * 
 * First we are going to setup userdetailsservice instance. We need to implement all methods in MyUserDetailsService class.
 * 
 * 	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
 *
 * 	public class MyUserDetailsService implements UserDetailsService {
 * 
 * 	}
 * 
 * Now while implementing MyUserDetailsService, since everything is hardcoded, SpSec is going to check against this hard
 * coded instance.
 * 
 * But now we are going to see how can setup JPA. That is, how we are going to create a User entity class and a repository
 * and then have SpSec use this User object from repo and convert into UserDetails object which is expected by 
 * UserDetailsService class.
 *  
 * 
 *  @Entity
	@Table(uniqueConstraints={@UniqueConstraint(name = "UniqueNumberAndDob", columnNames={"username", "dateOfBirth"})})
	public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;
    private String password;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    private String role;

 * After this, we setup the repo
 * 
 * 	@Repository
	public interface UserRepository extends JpaRepository<User, Long> {

    	User findByUsername(String username);
	}
	
 * Then we setup UserDetails constructor to take in this User instance.
 * In below instance we get the User from repo and return a User instance that implements UserDetails interface.
 * 
 * 	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        List<SimpleGrantedAuthority> roles = null;

        User user = userRepository.findByUsername(username);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User not found with the name " + username);
    }	
 * 
 * Now we have created JPA connection as well. The only thing left is give the datasource to mysql database. We do that in
 * the application.properties
 * 
 * 	spring.datasource.url=jdbc:mysql://localhost:3306/springsecurity
 * 	spring.datasource.username=root
 * 	spring.datasource.password=harry23Potter
 * 	spring.jpa.hibernate.ddl-auto=update
 * 	spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy
 * 	spring.jpa.hibernate.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
 * 
 * That's it. We have connected to MySql along with Spring Data JPA
 * 
 */
public class SSWithJpaMysql8 {

}
