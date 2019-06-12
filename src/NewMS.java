import sweeper.Box;

import javax.swing.*;
import java.awt.*;

public class NewMS extends JFrame {

    private static final int COLS = 9, ROWS = 9;
    private GridLayout grid = new GridLayout();

    public static void main(String[] args) {
        new NewMS();
    }

    private NewMS() {
        setLayout(grid);
        setSize();
    }

    private void setImages() {
        for (sweeper.Box box : Box.values())
            box.image = getImage(box.name().toLowerCase());

//        boxNumbers[0] = getImage("NoBomb".toLowerCase());
//        boxNumbers[1] = getImage("Num1".toLowerCase());
//        boxNumbers[2] = getImage("Num2".toLowerCase());
//        boxNumbers[3] = getImage("Num3".toLowerCase());
//        boxNumbers[4] = getImage("Num4".toLowerCase());
//        boxNumbers[5] = getImage("Num5".toLowerCase());
//        boxNumbers[6] = getImage("Num6".toLowerCase());
//        boxNumbers[7] = getImage("Num7".toLowerCase());
//        boxNumbers[8] = getImage("Num8".toLowerCase());

    }

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("pictures/" + name + ".png");
        return icon.getImage();
    }
}
