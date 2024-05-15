package commandpattern;

import observerpattern.Clothing;

public class SewCommand implements Command {
    private Clothing clothing;
    private String sewType;

    public SewCommand(Clothing clothing, String sewType) {
        this.clothing = clothing;
        this.sewType = sewType;
    }

    @Override
    public void execute() {
        System.out.println("Sewing clothing: " + clothing.getDescription() + " with sew type: " + sewType);
    }
}
