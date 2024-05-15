package observerpattern;

public abstract class Clothing {
    private String size;
    private String material;
    private String color;
    private String attribute1;
    private String attribute2;
    private double price;

    public Clothing(String size, String material, String color, String attribute1, String attribute2, double price) {
        this.size = size;
        this.material = material;
        this.color = color;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
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

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
