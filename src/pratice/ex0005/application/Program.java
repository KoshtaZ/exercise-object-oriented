package pratice.ex0005.application;

import pratice.ex0005.entities.Account;
import pratice.ex0005.entities.BussinessAccount;
import pratice.ex0005.entities.SavingsAccount;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        Account acc1 = new Account(1001, "Alex", 1000.0);
        acc1.withdraw(200.0);
        System.out.println(acc1.getBalance());

        Account acc2 = new SavingsAccount(1002, "Anna", 1000.0, 0.01);
        acc2.withdraw(200.0);
        System.out.println(acc2.getBalance());

        Account account = new BussinessAccount(1001, "Allex", 1000.0, 200.0);
        account.withdraw(200.0);
        System.out.println(account.getBalance());

    }
}
