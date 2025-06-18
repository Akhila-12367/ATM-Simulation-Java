import java.util.Scanner;
class Customer {
    String name;
    int cid;
    int accno;
    String branch;
    String bank;
    int inibal = 0;
    int mypin = 5566;
    StringBuilder miniStatement = new StringBuilder();
    int depositCount = 0;
    int withdrawCount = 0;
    public Customer(String name, int cid, int accno, String branch, String bank) {
        this.name = name;
        this.cid = cid;
        this.accno = accno;
        this.branch = branch;
        this.bank = bank;
    }
    public void display() {
        System.out.println("Name is " + this.name);
        System.out.println("Cid is " + this.cid);
        System.out.println("AccNo is " + this.accno);
        System.out.println("Branch is " + this.branch);
        System.out.println("Bank is " + this.bank);
    }
    public void deposit(int amount) {
        if (amount > 0) {
            inibal += amount;
            System.out.println("Deposit successfully!");
            miniStatement.append("Deposited: ").append(amount).append("\n");
            depositCount++;
        }
    }

    public void withdraw(int pin, int amount) {
        if (pin == mypin && amount <= inibal) {
            inibal -= amount;
            System.out.println("Done Successfully!");
            miniStatement.append("Withdrawn: ").append(amount).append("\n");
            withdrawCount++;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void checkBalance(int pin) {
        if (pin == mypin) {
            System.out.println("Balance is: " + inibal);
            miniStatement.append("Checked Balance: ").append(inibal).append("\n");
        } else {
            System.out.println("Sorry Incorrect Pin");
        }
    }

    Scanner sc = new Scanner(System.in);

    public void changePin(int pin) {
        if (pin == mypin) {
            System.out.println("Enter your new pin: ");
            int newpin = sc.nextInt();
            mypin = newpin;
            System.out.println("Pin changed successfully to " + mypin);
            miniStatement.append("PIN changed\n");
        } else {
            System.out.println("Incorrect current PIN");
        }
    }

    public void printMiniStatement() {
        System.out.println("---- Mini Statement ----");
        System.out.println(miniStatement.toString());
        System.out.println("------------------------");
    }

    public void customerSummary() {
        System.out.println("---- Customer Summary ----");
        System.out.println("Name: " + name);
        System.out.println("CID: " + cid);
        System.out.println("Account Number: " + accno);
        System.out.println("Branch: " + branch);
        System.out.println("Bank: " + bank);
        System.out.println("Current Balance: " + inibal);
        System.out.println("Total Deposits Made: " + depositCount);
        System.out.println("Total Withdrawals Made: " + withdrawCount);
        System.out.println("--------------------------");
    }
}

class AtmApp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter branch: ");
        String branch = sc.nextLine();
        System.out.println("Enter bank: ");
        String bank = sc.nextLine();
        System.out.println("Enter cid: ");
        int cid = sc.nextInt();
        System.out.println("Enter accno: ");
        int accno = sc.nextInt();

        Customer c1 = new Customer(name, cid, accno, branch, bank);
        c1.display();

        c1.deposit(50000);
        c1.withdraw(5566, 25000);
        c1.checkBalance(5566);
        c1.changePin(5566);
        c1.checkBalance(8899);
        c1.printMiniStatement();   // Mini statement
        c1.customerSummary();      // Customer summary
    }
}
