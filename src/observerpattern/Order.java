package observerpattern;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Clothing> clothingList;

    public Order(Customer customer) {
        this.customer = customer;
        this.clothingList = new ArrayList<>();
    }

    public void addClothing(Clothing clothing) {
        this.clothingList.add(clothing);
    }

    public List<Clothing> getClothingList() {
        return clothingList;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Customer: ").append(customer.getName()).append("\n")
                .append("Address: ").append(customer.getAddress()).append("\n")
                .append("Email: ").append(customer.getEmail()).append("\n")
                .append("Items ordered:\n");
        for (Clothing clothing : clothingList) {
            details.append("- ").append(clothing.getDescription()).append("\n");
        }
        return details.toString();
    }
}
