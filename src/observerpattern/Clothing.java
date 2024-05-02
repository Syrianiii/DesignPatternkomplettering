package observerpattern;

public abstract class Clothing {
    private String size;
    private String material;
    private String color;
    private String fit;
    private String length;
    private double price;

    public Clothing(String size, String material, String color, String fit, String length, double price) {
        this.size = size;
        this.material = material;
        this.color = color;
        this.fit = fit;
        this.length = length;
        this.price = price;
    }

    public abstract String getDescription();

    // Getter och setter-metoder här...

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
