import builderpattern.PantsBuilder;
import builderpattern.SkirtBuilder;
import builderpattern.TShirtBuilder;
import commandpattern.Command;
import commandpattern.CutCommand;
import commandpattern.SewCommand;
import model.Customer;
import observerpattern.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Läs in kundinformation
        System.out.println("ditt namn:");
        String name = scanner.nextLine();
        System.out.println("din address:");
        String address = scanner.nextLine();
        System.out.println("din email:");
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
                    System.out.println("Enter material: Exempel: Bomull");
                    String materialPants = scanner.nextLine();
                    System.out.println("Enter color:");
                    String colorPants = scanner.nextLine();
                    System.out.println("Enter fit:");
                    String fitPants = scanner.nextLine();
                    System.out.println("Enter length:");
                    String lengthPants = scanner.nextLine();
                    System.out.println("Enter price:");
                    double pricePants = Double.parseDouble(scanner.nextLine()); // Read the price

                    PantsBuilder pantsBuilder = new PantsBuilder();
                    Clothing pants = pantsBuilder.setSize(sizePants)
                            .setMaterial(materialPants)
                            .setColor(colorPants)
                            .setFit(fitPants)
                            .setLength(lengthPants)
                            .setPrice(pricePants)
                            .build();
                    order.addClothing(pants);

                    Command cutPants = new CutCommand(pants, "Regular Cut");
                    Command sewPants = new SewCommand(pants, "Regular Sew");
                    cutPants.execute();
                    sewPants.execute();

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
                    System.out.println("Enter price:");
                    double priceTShirt = Double.parseDouble(scanner.nextLine());

                    TShirtBuilder tShirtBuilder = new TShirtBuilder();
                    Clothing tShirt = tShirtBuilder.setSize(sizeTShirt)
                            .setMaterial(materialTShirt)
                            .setColor(colorTShirt)
                            .setSleeves(sleevesTShirt)
                            .setNeck(neckTShirt)
                            .setPrice(priceTShirt)
                            .build();
                    order.addClothing(tShirt);

                    Command cutTShirt = new CutCommand(tShirt, "Regular Cut");
                    Command sewTShirt = new SewCommand(tShirt, "Regular Sew");
                    cutTShirt.execute();
                    sewTShirt.execute();

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
                    System.out.println("Enter price:");
                    double priceSkirt = Double.parseDouble(scanner.nextLine());

                    SkirtBuilder skirtBuilder = new SkirtBuilder();
                    Clothing skirt = skirtBuilder.setSize(sizeSkirt)
                            .setMaterial(materialSkirt)
                            .setColor(colorSkirt)
                            .setWaistline(waistlineSkirt)
                            .setPattern(patternSkirt)
                            .setPrice(priceSkirt)
                            .build();
                    order.addClothing(skirt);

                    Command cutSkirt = new CutCommand(skirt, "Regular Cut");
                    Command sewSkirt = new SewCommand(skirt, "Regular Sew");
                    cutSkirt.execute();
                    sewSkirt.execute();

                    break;
                case 4:
                    System.out.println("Are you sure you want to place the order? (yes/no)");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("yes")) {
                        addMoreClothing = false;
                    } else {
                        System.out.println("Order cancelled.");
                        return;
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

        // Dekorera klädesplaggen med kommandon
        for (Clothing clothing : order.getClothingList()) {
            Command cutCommand = new CutCommand(clothing, "Regular Cut");
            Command sewCommand = new SewCommand(clothing, "Regular Sew");
            cutCommand.execute();
            sewCommand.execute();
        }

        shop.notifyReadyForDelivery();
    }
}
