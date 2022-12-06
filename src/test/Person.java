package test;

public class Person {
    private Status status;
    private String fullName;
    private BankAccount bankAccount;


    public Person(Status status, String fullName, BankAccount bankAccount) {
        this.status = status;
        this.fullName = fullName;
        this.bankAccount = bankAccount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Status: "+ status+" "+
                "fullName='" + fullName + '\'' +
                ", bankAccount=" + bankAccount +
                "}\n";
    }
}
