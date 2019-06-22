import sweeper.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class NewMS extends JFrame {

    private static final int COLS = 9, ROWS = 9, IMAGE_SIZE = 60;
//    private GridLayout grid = new GridLayout(COLS, ROWS);
    private static Image[] imagesArray = new Image[16];
    private int roundX = 0, roundY = 0;
    private static JPanel panel;
    private static int[][] field = new int[COLS][ROWS];
//    private static ActionListener act;
//    private static JButton[][] buttons = new JButton[COLS][ROWS];

    public static void main(String[] args) {
        new NewMS();
    }

    private NewMS() {
        setImages();
//        setLayout(grid);
        initializer();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        setVisible(true);
//        setResizable(false);
//        pack();
        setLocationRelativeTo(null);
        field[0][0] = 3;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e != null) {
                    roundX = e.getX() / IMAGE_SIZE;
                    roundY = e.getY() / IMAGE_SIZE;
                    System.out.println(e.getX() + " " + e.getY());
                    painter(e.getX(), e.getY());
                }
            }
        });
        System.out.println(this.getContentPane().getPreferredSize().height);
    }

    private void initializer() {

        Random rand = new Random(4574);

        panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        g.drawImage(imagesArray[1], i * IMAGE_SIZE, j * IMAGE_SIZE, this);
                    }
                }
            }
        };

//        for (int i = 0; i < ROWS; i++) {
//                    for (int j = 0; j < COLS; j++) {
//                        buttons[i][j] = new JButton();
//                        buttons[i][j].setSize(30, 30);
//                        buttons[i][j].setMargin(new Insets(0,0,0,0));
//                        buttons[i][j].setIcon(imagesArray[7]);
//
//                        panel.add(buttons[i][j]);
//                    }
//                }
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(panel);
    }

    private void painter(int x, int y) {

//        buttons[x][y].setIcon(imagesArray[5]);
//        repaint();
        panel.getGraphics().drawImage(imagesArray[field[roundX][roundY]], x , y , null);
        System.out.println(x + " " + y);

    }

    private void setImages() {
        int i = 0;
        for (Box box : Box.values())
            imagesArray[i++] = getImage(box.name().toLowerCase());

    }

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("pictures/" + name + ".png");
        return icon.getImage();
    }
}
