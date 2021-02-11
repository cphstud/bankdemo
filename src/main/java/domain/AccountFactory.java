package domain;

import java.time.LocalDate;

public interface AccountFactory {
    Account createAccount(Customer customer, int id, String type);
}
