package entries;

import datalayer.Database;
import datalayer.DatabaseImpl;

import java.util.Scanner;

public class Main {
    private final Database d ;
    private final Scanner s;
    private final Bank b;

    public Main() {
        this.s = new Scanner(System.in);
        this.d = new DatabaseImpl();
        this.b = new Bank(d);
    }

    public void runProgram() {
        int choice = 0;

    }

    public static void main(String[] args) {


        //newBalance = account.depositAmount(325);
        //System.out.println(String.format("Ny balance: %d", newBalance));

    }
}
