package datalayer;

import domain.Account;
import domain.Customer;
import domain.Transaction;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class DatabaseImpl implements Database{
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/bank";
    private static final String DB_USER = "root";


    @Override
    public List<Account> getAllAccounts() {
        try (Connection conn = getConnection()) {
            // sql for create user

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account getAccountById(int id) {
        Account acc = null;
        Customer c  = null;
        try (Connection conn = getConnection()) {
            PreparedStatement pst = null;
            ResultSet res = null;
            String sql = "SELECT customerID FROM accounts WHERE accountID = ?";
            pst = conn.prepareStatement(sql,1);
            pst.setInt(1,id);
            res = pst.executeQuery();
            // sql for create user
            while(res.next()) {
                int custID = res.getInt(1);
                c = this.getCustomerFromId(custID);
            }
            acc = new Account(id,c);
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return acc;
    }

    @Override
    public Account createAcc(int id, Customer c) {
        Account acc = null;
        try (Connection conn = getConnection()) {
            PreparedStatement pst = null;
            ResultSet res = null;
            String sql = "INSERT INTO accounts(customerID) VALUES(?)";
            pst = conn.prepareStatement(sql,1);
            pst.setInt(1,c.getId());
            pst.executeUpdate();
            // sql for create user
            res.next();
            res = pst.getGeneratedKeys();
            int aid = res.getInt(1);
            acc = new Account(aid,c);
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }

    public Transaction createTra(Account acc, int amount, LocalDateTime lt) {
        Transaction t = null;
        try (Connection conn = getConnection()) {
            PreparedStatement pst = null;
            ResultSet res = null;
            String sql = "INSERT INTO transaktion(account_id,beløb,dato) VALUES(?,?,?)";
            pst = conn.prepareStatement(sql,1);
            pst.setInt(1,acc.getId());
            pst.setInt(2,amount);
            pst.setTimestamp(3,Timestamp.valueOf(lt));
            pst.executeUpdate();
            res = pst.getGeneratedKeys();
            res.next();
            int tid = res.getInt(1);
            t = new Transaction(tid,amount,lt);
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public void delete(Account acc) {

    }

    @Override
    public Customer createCustomer(String name, int id) {
        Customer c = null;
        try (Connection conn = getConnection()) {
            PreparedStatement pst = null;
            ResultSet res = null;
            String sql = "INSERT INTO kunde(kunde_id,kunde_navn) VALUES(?,?)";
            pst = conn.prepareStatement(sql,1);
            pst.setString(2,name);
            pst.setInt(1,id);
            pst.executeUpdate();
            // sql for create user
            pst.close();
            c = new Customer(name,id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getCustomerFromId(int id) {
        Customer c = null;
        try (Connection conn = getConnection()) {
            PreparedStatement pst = null;
            ResultSet res = null;
            String sql = "SELECT kunde_navn FROM kunde WHERE kunde_id = ?";
            pst = conn.prepareStatement(sql,1);
            pst.setInt(1,id);
            res = pst.executeQuery();
            // sql for create user
            while(res.next()) {
                String name = res.getString(1);
                c = new Customer(name,id);
            }
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return c;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, "root123");
    }
}
