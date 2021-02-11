import domain.Account;
import domain.Customer;

public class Main {

    public static void main(String[] args) {

        Customer c1 = new Customer("Jon");
        Account account = new Account(c1,1);
        Account account2 = new Account(c1,2);
        //domain.Account account = new domain.Account(c1);

        int newBalance = account.depositAmount(125);
        System.out.println(String.format("Ny balance: %d", newBalance));

        newBalance = account.depositAmount(325);
        System.out.println(String.format("Ny balance: %d", newBalance));

    }
}
