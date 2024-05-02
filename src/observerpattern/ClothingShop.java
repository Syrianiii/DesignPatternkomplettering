package observerpattern;

import java.util.ArrayList;
import java.util.List;

public class ClothingShop {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void placeOrder(Order order) {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }

    public void notifyReadyForDelivery() {
        for (Observer observer : observers) {
            observer.readyForDelivery();
        }
    }
}
