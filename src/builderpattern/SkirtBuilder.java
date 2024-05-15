package builderpattern;

import observerpattern.Clothing;

public class SkirtBuilder {
    private String size;
    private String material;
    private String color;
    private String waistline;
    private String pattern;
    private double price;

    public SkirtBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public SkirtBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public SkirtBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public SkirtBuilder setWaistline(String waistline) {
        this.waistline = waistline;
        return this;
    }

    public SkirtBuilder setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public SkirtBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Clothing build() {
        return new Clothing(size, material, color, waistline, pattern, price) {
            @Override
            public String getDescription() {
                return size + " " + color + " skirt made of " + material + ", " +
                        "waistline: " + waistline + ", pattern: " + pattern + ", price: " + price;
            }
        };
    }
}
