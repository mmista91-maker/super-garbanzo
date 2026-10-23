class BankAccount {

    private int balance;
    private boolean isOpen;
    
    synchronized void open() throws BankAccountActionInvalidException {
        if (!isOpen) {
            isOpen = true;
            return;
        }
        throw new BankAccountActionInvalidException("Account already open");
    }
    
    synchronized void close() throws BankAccountActionInvalidException {
        if (isOpen) {
            balance = 0;
            isOpen = false;
            return;
        }
        throw new BankAccountActionInvalidException("Account not open");
    }
    
    synchronized int getBalance() throws BankAccountActionInvalidException {
        if (isOpen) {
            return balance;
        }
        throw new BankAccountActionInvalidException("Account closed");
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
            if (!isOpen) {
        throw new BankAccountActionInvalidException("Account closed");
    }
            else if (amount < 0){
                throw new BankAccountActionInvalidException ("Cannot deposit or withdraw negative amount");     
            }
        balance += amount;
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
            if (!isOpen) {
        throw new BankAccountActionInvalidException("Account closed");
    }
        if (amount > balance){
            throw new BankAccountActionInvalidException ("Cannot withdraw more money than is currently in the account");            
        }
        else if (amount < 0){
            throw new BankAccountActionInvalidException  ("Cannot deposit or withdraw negative amount");
        }
         balance -= amount;
    }

}