package observerpattern;

public class CEOObserver implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("CEO: Order placed. Notifying VD.");
    }

    @Override
    public void readyForDelivery() {
        System.out.println("CEO: Clothing ready for delivery. Notifying VD.");
    }
}
