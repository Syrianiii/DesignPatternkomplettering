package commandpattern;

import observerpattern.Clothing;

// Kommando för att skapa ett plagg
public class CreateClothingCommand implements Command {
    private Clothing clothing;

    public CreateClothingCommand(Clothing clothing) {
        this.clothing = clothing;
    }

    @Override
    public void execute() {
        // Här kan du implementera logiken för att skapa ett plagg
        // Till exempel, skapa klädesplagget och utför de nödvändiga stegen för att skapa det
        System.out.println("Creating clothing: " + clothing.getDescription());
    }
}
