/*
 File: Account.java
 Author: Keven Gary
 Date: 02-25-2015
 
 Description: This class is inherited by the Checking and Savings classes.
 */

package banking.primitive.core;

public abstract class Account implements java.io.Serializable {
    
    

    protected Account(String n, float b) {
        this(n); 
        balance = b;
    }
    
    public abstract String getType();
    
    protected final State getState() {
        return state;
    }
    
    protected final void setState(State s) {
        state = s;
    }
    
    protected enum State {
        OPEN, CLOSED, OVERDRAWN
    };

 
    protected Account(String n) {
        name = n;
        state = State.OPEN;
    }

    

    /**
     * @return name of the Account
     */
    public final String getName() {
        return name;
    }

    /**
     * @return balance in the Account
     */
    public final float getBalance() {
        return balance;
    }

    /**
     * Adds money to an account. May not be done if the account is CLOSED
     * 
     * @param parameter
     *            amount is a deposit and must be > 0
     * @return true if the deposit was successful, false if not due to amount or
     *         invalid state
     */
    public abstract boolean deposit(float amount);

    /**
     * Takes money out of an account. If the balance falls below 0 then the
     * account is moved to an OVERDRAWN state
     * 
     * @param parameter
     *            amount is a withdrawal and must be > 0
     * @return true if the deposit was successful, false if not due to amount or
     *         invalid state
     */
    public abstract boolean withdraw(float amount);

    /**
     * @return either "Checking" or "Savings"
     */
    

    public String toString() {
        return "Account " + name + " has $" + balance + "and is " + getState()
                + "\n";
    }
    
    protected float balance = 0.0F;
    protected String name;
    private State state;
    
    private static final long serialVersionUID = 1L;
    
}
