package commandpattern;

import observerpattern.Clothing;

public class CutCommand implements Command {
    private Clothing clothing;
    private String cutType;

    public CutCommand(Clothing clothing, String cutType) {
        this.clothing = clothing;
        this.cutType = cutType;
    }

    @Override
    public void execute() {
        System.out.println("Cutting clothing: " + clothing.getDescription() + " with cut type: " + cutType);
    }
}
