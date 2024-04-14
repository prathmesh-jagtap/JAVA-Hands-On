public class BankAccount {
  private String accountNumber;
  private String accountHolderName;
  private double balance;

  public BankAccount(String accountNumber, String accountHolderName) {
    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.balance = 0;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
    } else {
      System.out.println("Insufficient funds.");
    }
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }
}
