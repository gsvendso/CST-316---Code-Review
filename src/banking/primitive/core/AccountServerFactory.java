package banking.primitive.core;


public class AccountServerFactory {

	protected static AccountServerFactory singleton = null;

	protected AccountServerFactory() {

	}

	public static AccountServerFactory getMe() {
		if (singleton == null) {
			singleton = new AccountServerFactory();
		}

		return singleton;
	}

    /**
     Method: lookup
     Inputs: None
     Returns: ServerSolution Object
     
     Description: Creates a new ServerSolution Object
     */
	public AccountServer lookup() {
		return new ServerSolution();
	}
}
