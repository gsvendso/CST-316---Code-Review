package banking.primitive.core;

public class Checking extends Account {

	private static final long serialVersionUID = 11L;
	private int numWithdraws = 0;
	
	private Checking(String name) {
		super(name);
	}

    public static Checking createChecking(String name) {
        return new Checking(name);
    }

	public Checking(String name, float balance) {
		super(name, balance);
	}

    /**
     Method: deposit
     Inputs: a float amount < 0
     Returns: true if account is open and amount < 0
     
     Description: A deposit may be made unless the Checking account is closed
     */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
			return true;
		}
		return false;
	}

    /**
     Method: withdraw
     Inputs: amount < 0
     Returns: true if account if open and amount < 0
     
     Description:  Withdrawal. After 10 withdrawals a fee of $2 is charged per transaction You may
     continue to withdraw an overdrawn account until the balance is below -$100
     */
	public boolean withdraw(float amount) {
		if (amount > 0.0f) {		
			// KG: incorrect, last balance check should be >=
			if (getState() == State.OPEN || (getState() == State.OVERDRAWN && balance > -100.0f)) {
				balance = balance - amount;
				numWithdraws++;
				if (numWithdraws > 10)
					balance = balance - 2.0f;
				if (balance < 0.0f) {
					setState(State.OVERDRAWN);
				}
				return true;
			}
		}
		return false;
	}

	public String getType() { return "Checking"; }

    /**
     Method: toString
     Inputs: None
     Returns: String of type, name and balance
     
     Description: Prints account type name and balance in a string
     */
	public String toString() {
		return "Checking: " + getName() + ": " + getBalance();
	}
}
