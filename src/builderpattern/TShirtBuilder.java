package builderpattern;

import observerpattern.Clothing;

public class TShirtBuilder {
    private String size;
    private String material;
    private String color;
    private String sleeves;
    private String neck;
    private double price; // New attribute for price

    public TShirtBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public TShirtBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public TShirtBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public TShirtBuilder setSleeves(String sleeves) {
        this.sleeves = sleeves;
        return this;
    }

    public TShirtBuilder setNeck(String neck) {
        this.neck = neck;
        return this;
    }

    public TShirtBuilder setPrice(double price) { // Method to set the price
        this.price = price;
        return this;
    }

    public Clothing build() {
        return new Clothing(size, material, color, sleeves, neck, price) {
            @Override
            public String getDescription() {
                return size + " " + color + " t-shirt made of " + material + ", " +
                        "sleeves: " + sleeves + ", neck: " + neck;
            }
        };
    }
}
