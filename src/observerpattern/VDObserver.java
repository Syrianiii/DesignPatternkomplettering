package observerpattern;

public class VDObserver implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("VD: Order placed. Notifying CEO.");
    }

    @Override
    public void readyForDelivery() {
        System.out.println("VD: Clothing ready for delivery. Notifying CEO.");
    }
}
