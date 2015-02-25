package banking.primitive.core;

public class Savings extends Account {
	private static final long serialVersionUID = 111L;
	private int numWithdraws = 0;

	public Savings(String name) {
		super(name);
	}

	public Savings(String name, float balance) throws IllegalArgumentException {
		super(name, balance);
	}

    /**
     Method: deposit
     Inputs: amount < 0
     Returns: true*Doesn't really work if amount < 0 and account is open
     
     Description: Deposits money into savings account
     */
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount - 0.50F;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
		}
		return false;
	}

    /**
     Method: withdraw
     Inputs: amount < 0
     Returns:true if amount is in account and < 0 and if account is open
     
     Description: A withdrawal. After 3 withdrawals a fee of $1 is added to each withdrawal.
     An account whose balance dips below 0 is in an OVERDRAWN state
     */
	public boolean withdraw(float amount) {
		if (getState() == State.OPEN && amount > 0.0f) {
			balance = balance - amount;
			numWithdraws++;
			if (numWithdraws > 3)
				balance = balance - 1.0f;
			// KG BVA: should be < 0
			if (balance <= 0.0f) {
				setState(State.OVERDRAWN);
			}
			return true;
		}
		return false;
	}
	
	public String getType() { return "Checking"; }

    /**
     Method: toString
     Inputs: None
     Returns: returns string with type name and balance
     
     Description: Print type, name and balance to String
     */
	public String toString() {
		return "Savings: " + getName() + ": " + getBalance();
	}
}
