import sweeper.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewMS extends JFrame {

    private static final int COLS = 9, ROWS = 9, IMAGE_SIZE = 50;
    private GridLayout grid = new GridLayout(COLS, ROWS);
    private static Image[] imagesArray = new Image[16];
    private int pointX = 0, pointY = 0;

    public static void main(String[] args) {
        new NewMS();
    }

    private NewMS() {
        initializer();
        setLayout(grid);
        setSize(700, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setImages();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e != null) {
                    pointX = e.getX() / IMAGE_SIZE;
                    pointY = e.getY() / IMAGE_SIZE;
                }
            }
        });

//        painter();
    }

    private void initializer() {

        JPanel panel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        g.drawImage(imagesArray[10], i * IMAGE_SIZE, j * IMAGE_SIZE, this);
                    }
                }
            }
        };
        panel.setSize(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE);
        add(panel);
    }

    private void painter() {

    }

    private void setImages() {
        int i = 0;
        for (Box box : Box.values())
            imagesArray[i++] = getImage(box.name().toLowerCase());

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
