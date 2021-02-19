package datalayer;

import domain.Customer;

import java.util.List;

public interface CustomerDAO {
    public Customer createCustomer(String name, int id);
    public List<Customer> getAllCustomers();
    public Customer getCustomerFromId(int id);
}
