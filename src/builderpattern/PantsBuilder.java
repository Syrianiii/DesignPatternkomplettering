package builderpattern;

import observerpattern.Clothing;

public class PantsBuilder {
    private String size;
    private String material;
    private String color;
    private String fit;
    private String length;
    private double price; // Lägg till prisattributet

    public PantsBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public PantsBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public PantsBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public PantsBuilder setFit(String fit) {
        this.fit = fit;
        return this;
    }

    public PantsBuilder setLength(String length) {
        this.length = length;
        return this;
    }

    public PantsBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Clothing build() {
        return new Clothing(size, material, color, fit, length, price) {
            @Override
            public String getDescription() {
                return size + " " + color + " pants made of " + material + ", " +
                        "fit: " + fit + ", length: " + length + ", price: " + price; // Uppdatera beskrivningen för att inkludera priset
            }
        };
    }
}
