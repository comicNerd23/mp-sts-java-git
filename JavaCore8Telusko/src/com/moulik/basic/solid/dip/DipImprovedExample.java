package com.moulik.basic.solid.dip;

/**
 * 	The interface has a connect method and the MySQLConnection class implements this interface. Also, instead of directly type-hinting MySQLConnection class in 
 * 	the constructor of the PasswordReminder, you instead type-hint the DBConnectionInterface and no matter the type of database your application uses, the
 * 	PasswordReminder class can connect to the database without any problems and open-close principle is not violated.
 *
 */
public class DipImprovedExample {

	public static void main(String[] args) {

	}

}
interface DbConnection {
	public Object connect();
}
class MySqlConnection1 implements DbConnection {
	
	public Object connect() {
		//Does connections
		return "dbConnection";
	}
	
	
}
class PasswordReminder1 {
	
    private Object dbConnection;

    public PasswordReminder1(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    
    
}