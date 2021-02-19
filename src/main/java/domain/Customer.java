package domain;

import java.util.Objects;

public class Customer {

    private String name;
    private final int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ID idFromInd(int id) {
        return new ID(id);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getName(), customer.getName());
    }

    public static class ID {
        private final int rep;
        private ID(int rep) {
            this.rep = rep;
        }
        public int getRep() {
            return rep;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
