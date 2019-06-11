import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import sweeper.Box;

public class Main extends JFrame {

    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 60;
    private JPanel panel;
    private Image[] boxNumbers = new Image[9];
    private static Random rand = new Random(1890);
    private int[][] field = new int[COLS][ROWS];

    public static void main(String[] args) {
        new Main();
    }

    private Main() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j] = -1;
            }
        }

        setImages();
        initPanel();
        initFrame();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e != null) {
                    int mI, mJ;
//                    initPanel();
//                    repaint();
                    mI = e.getX() / COLS;
                    mJ = e.getY() / ROWS;

                }
            }
        });
    }

    private void fieldInitiation() {
        int value;
        Random rand = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                value = rand.nextInt(5);
                field[i][j] = value;
                while (value != 0) {

                }

            }
        }
    }

    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                            g.drawImage( boxNumbers[rand.nextInt(9)],j * IMAGE_SIZE, i * IMAGE_SIZE, this);
                    }
                }

//                for (Box box : Box.values())
//                g.drawImage((Image) box.image,box.ordinal() * IMAGE_SIZE, 0, this);




//                g.drawImage(getImage("Num1"), IMAGE_SIZE, IMAGE_SIZE, this);
//                g.drawImage(getImage("Num1"), 0, IMAGE_SIZE, this);
            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private void setImages() {
        for (Box box : Box.values())
            box.image = getImage(box.name().toLowerCase());

            boxNumbers[0] = getImage("NoBomb".toLowerCase());
            boxNumbers[1] = getImage("Num1".toLowerCase());
            boxNumbers[2] = getImage("Num2".toLowerCase());
            boxNumbers[3] = getImage("Num3".toLowerCase());
            boxNumbers[4] = getImage("Num4".toLowerCase());
            boxNumbers[5] = getImage("Num5".toLowerCase());
            boxNumbers[6] = getImage("Num6".toLowerCase());
            boxNumbers[7] = getImage("Num7".toLowerCase());
            boxNumbers[8] = getImage("Num8".toLowerCase());

    }

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("pictures/" + name + ".png");
        return icon.getImage();
    }

}
