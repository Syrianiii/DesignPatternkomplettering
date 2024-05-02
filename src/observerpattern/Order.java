package observerpattern;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Clothing> clothingList = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addClothing(Clothing clothing) {
        clothingList.add(clothing);
    }

    public List<Clothing> getClothingList() {
        return clothingList;
    }

    public String getOrderDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer: ").append(customer.getName()).append("\n");
        builder.append("Address: ").append(customer.getAddress()).append("\n");
        builder.append("Email: ").append(customer.getEmail()).append("\n");
        builder.append("Items ordered:\n");
        for (Clothing clothing : clothingList) {
            builder.append("- ").append(clothing.getDescription()).append("\n");
        }
        return builder.toString();
    }
}
