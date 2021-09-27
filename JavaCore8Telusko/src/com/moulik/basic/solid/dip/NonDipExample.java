package com.moulik.basic.solid.dip;

/**
 * 	Dependency inversion principle states: Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the 
 * 	low-level module, but they should depend on abstractions.
 * 	This principle allows for decoupling.
 * 	
 * 	Here is an example of a PasswordReminder that connects to a MySQL database:
 * 	
 * 	First, the MySqlConnection is the low-level module while the PasswordReminder is high level, but according to the definition of D in SOLID, which states to 
 * 	Depend on abstraction, not on concretions. This snippet above violates this principle as the PasswordReminder class is being forced to depend on the 
 * 	MySqlConnection class.
 * 	Later, if you were to change the database engine, you would also have to edit the PasswordReminder class, and this would violate the open-close principle.
 *	
 *	The PasswordReminder class should not care what database your application uses. To address these issues, you can code to an interface since high-level and 
 *	low-level modules should depend on abstraction:
 */
public class NonDipExample {

	public static void main(String[] args) {

	}

}
class MySqlConnection {
	
	public Object connect() {
		//Does connections
		return "dbConnection";
	}
	
	
}
class PasswordReminder {
	
    private Object dbConnection;

    public PasswordReminder(MySqlConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    
    
}
