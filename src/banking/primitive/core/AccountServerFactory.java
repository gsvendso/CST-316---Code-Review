/*
 File: Account.java
 Author: Keven Gary
 Date: 02-25-2015
 
 Description: This class creates Account Server objects
 */

package banking.primitive.core;


public class AccountServerFactory {

	

	protected AccountServerFactory() {

	}

	public static AccountServerFactory getMe() {
		if (singleton == null) {
			singleton = new AccountServerFactory();
		}

		return singleton;
	}

	public AccountServer lookup() {
		return new ServerSolution();
	}
    
    protected static AccountServerFactory singleton = null;
}
