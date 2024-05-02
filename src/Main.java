import java.util.Scanner;
import builderpattern.*;
import model.*;
import observerpattern.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Läs in kundinformation
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your address:");
        String address = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        // Skapa kundobjekt
        Customer customer = new Customer(name, address, email);
        Order order = new Order(customer);

        boolean addMoreClothing = true;
        while (addMoreClothing) {
            System.out.println("Choose a clothing item to add:");
            System.out.println("1. Pants");
            System.out.println("2. T-Shirt");
            System.out.println("3. Skirt");
            System.out.println("4. Finish and place order");

            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.println("Choose Pants attributes:");
                    System.out.println("Enter size (S, M, L):");
                    String sizePants = scanner.nextLine();
                    System.out.println("Enter material:");
                    String materialPants = scanner.nextLine();
                    System.out.println("Enter color:");
                    String colorPants = scanner.nextLine();
                    System.out.println("Enter fit:");
                    String fitPants = scanner.nextLine();
                    System.out.println("Enter length:");
                    String lengthPants = scanner.nextLine();
                    System.out.println("Enter price:");
                    double pricePants = Double.parseDouble(scanner.nextLine()); // Read the price
                    // Använd byggaren för att skapa byggaren
                    PantsBuilder pantsBuilder = new PantsBuilder();
                    // Använd byggaren för att bygga byggnaden steg för steg
                    Clothing pants = pantsBuilder.setSize(sizePants)
                            .setMaterial(materialPants)
                            .setColor(colorPants)
                            .setFit(fitPants)
                            .setLength(lengthPants)
                            .setPrice(pricePants) // Set the price
                            .build();
                    order.addClothing(pants);
                    break;
                case 2:
                    System.out.println("Choose T-Shirt attributes:");
                    System.out.println("Enter size (S, M, L):");
                    String sizeTShirt = scanner.nextLine();
                    System.out.println("Enter material:");
                    String materialTShirt = scanner.nextLine();
                    System.out.println("Enter color:");
                    String colorTShirt = scanner.nextLine();
                    System.out.println("Enter sleeves:");
                    String sleevesTShirt = scanner.nextLine();
                    System.out.println("Enter neck:");
                    String neckTShirt = scanner.nextLine();
                    System.out.println("Enter price:"); // Ask for the price
                    double priceTShirt = Double.parseDouble(scanner.nextLine()); // Read the price
                    // Använd byggaren för att skapa byggaren
                    TShirtBuilder tShirtBuilder = new TShirtBuilder();
                    // Använd byggaren för att bygga byggnaden steg för steg
                    Clothing tShirt = tShirtBuilder
                            .setSize(sizeTShirt)
                            .setMaterial(materialTShirt)
                            .setColor(colorTShirt)
                            .setSleeves(sleevesTShirt)
                            .setNeck(neckTShirt)
                            .setPrice(priceTShirt) // Set the price
                            .build();
                    order.addClothing(tShirt);
                    break;
                case 3:
                    System.out.println("Choose Skirt attributes:");
                    System.out.println("Enter size (S, M, L):");
                    String sizeSkirt = scanner.nextLine();
                    System.out.println("Enter material:");
                    String materialSkirt = scanner.nextLine();
                    System.out.println("Enter color:");
                    String colorSkirt = scanner.nextLine();
                    System.out.println("Enter waistline:");
                    String waistlineSkirt = scanner.nextLine();
                    System.out.println("Enter pattern:");
                    String patternSkirt = scanner.nextLine();
                    System.out.println("Enter price:"); // Ask for the price
                    double priceSkirt = Double.parseDouble(scanner.nextLine()); // Read the price
                    // Använd byggaren för att skapa byggaren
                    SkirtBuilder skirtBuilder = new SkirtBuilder();
                    // Använd byggaren för att bygga byggnaden steg för steg
                    Clothing skirt = skirtBuilder.setSize(sizeSkirt)
                            .setMaterial(materialSkirt)
                            .setColor(colorSkirt)
                            .setWaistline(waistlineSkirt)
                            .setPattern(patternSkirt)
                            .setPrice(priceSkirt) // Set the price
                            .build();
                    order.addClothing(skirt);
                    break;
                case 4:
                    // Fråga om bekräftelse innan kvittot skrivs ut
                    System.out.println("Are you sure you want to place the order? (yes/no)");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("yes")) {
                        addMoreClothing = false;
                    } else {
                        System.out.println("Order cancelled.");
                        return; // Avbryt programmet om ordern avbryts
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        // Skriv ut kvitto med beställningens detaljer
        System.out.println("Order Summary:");
        System.out.println(order.getOrderDetails());

        // Skicka beställning till butiken och notifiera
        ClothingShop shop = new ClothingShop();
        CEOObserver ceoObserver = new CEOObserver();
        VDObserver vdObserver = new VDObserver();
        shop.addObserver(ceoObserver);
        shop.addObserver(vdObserver);

        shop.placeOrder(order);
        shop.notifyReadyForDelivery(); // Notify when the order is ready for delivery
    }
}
