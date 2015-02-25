package banking.primitive.core;

import java.io.IOException;
import java.util.List;

public interface AccountServer {

    /**
     Method: newAccount
     Inputs: type must be one of Savings or Checking
     name leading or trailing whitespace is removed
     balance must be non-negative
     Returns: boolean true if the account was created and stored, false otherwise
     
     Description: Create a new account object in the server. if an account already exists with the given name
     then a new account is not created and stored.
     */
	public boolean	newAccount(String type, String name, float balance) throws IllegalArgumentException;

    /**
     Method: closeAccount
     Inputs: name leading or trailing whitespace is removed
     Returns: boolean true if there was an account with this name and close was successful
     
     Description: Close an account
     */
	public boolean	closeAccount(String name);

	/**
	 * @param
	 * @return Account object or null if not found. 
	 */
	public Account	getAccount(String name);

	/** 
	 * @return a list of all Accounts inside the server 
	 */
	public List<Account> getAllAccounts();

	/** 
	 * @return a list of Accounts inside the server that are not CLOSED
	 */
	public List<Account> getActiveAccounts();

    /**
     Method: saveAccounts
     Inputs: None
     Returns: None
     
     Description: Saves the state of the server
     */
	public void	saveAccounts() throws IOException;
}
