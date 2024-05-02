package observerpattern;

public interface Observer {
    void update(Order order);

    void readyForDelivery();
}
