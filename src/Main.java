import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import sweeper.Box;

public class Main extends JFrame {

    private static final int COLS = 9, ROWS = 9, IMAGE_SIZE = 60;
    private static Image[] imagesArray = new Image[16];
    private static JPanel panel;
    private int[][] field = new int[COLS][ROWS];
    private int roundX = 0, roundY = 0;


    public static void main(String[] args) {
        new Main();
    }

    private Main() {

        fieldInitiation();
        setImages();
        System.out.println();
        initPanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        getContentPane().add(panel);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e != null) {
                    int button = e.getButton();
                    roundX = e.getX() % IMAGE_SIZE;
                    roundY = e.getY() % IMAGE_SIZE;
                    if (button == 3) {
                        painter(e.getX() - roundX, e.getY() - roundY, button);
                    } else if (e.getButton() == 1) {
                        painter(e.getX() - roundX, e.getY() - roundY, button);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (e != null) {
                    int button = e.getButton();
                    roundX = e.getX() % IMAGE_SIZE;
                    roundY = e.getY() % IMAGE_SIZE;
                    if (button == 3) {
                        painter(e.getX() - roundX, e.getY() - roundY, button);
                    } else if (e.getButton() == 1) {
                        painter(e.getX() - roundX, e.getY() - roundY, button);
                    }
                }
            }

        });
    }

    private void fieldInitiation() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j] = 0;
            }
        }

        int value, quantity;
        Random rand = new Random();
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                field[i][j] = rand.nextInt(7);
                quantity = field[i][j];
                while (quantity != 0) {
                    value = rand.nextInt(8);
                    switch (value) {
                        case 0: if (field[i-1][j-1] == 0) {
                            field[i-1][j-1] = 13;
                        }
                        case 1: if (field[i-1][j-1] == 0) {
                            field[i-1][j] = 13;
                        }
                        case 2: if (field[i-1][j-1] == 0) {
                            field[i-1][j+1] = 13;
                        }
                        case 3: if (field[i-1][j-1] == 0) {
                            field[i][j-1] = 13;
                        }
                        case 4: if (field[i-1][j-1] == 0) {
                            field[i][j+1] = 13;
                        }
                        case 5: if (field[i-1][j-1] == 0) {
                            field[i+1][j-1] = 13;
                        }
                        case 6: if (field[i-1][j-1] == 0) {
                            field[i+1][j] = 13;
                        }
                        case 7: if (field[i-1][j-1] == 0) {
                            field[i+1][j+1] = 13;
                        }
                    }
                    quantity--;
                }
            }
        }
    }

    private void initPanel() {

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        g.drawImage(imagesArray[9], i * IMAGE_SIZE, j * IMAGE_SIZE, IMAGE_SIZE, IMAGE_SIZE, this);
                        Graphics2D gr = (Graphics2D) g;
                        gr.setBackground(Color.WHITE);
                        gr.setStroke(new BasicStroke(2));
                        gr.drawLine(i, j * IMAGE_SIZE, (i+1) * IMAGE_SIZE, j * IMAGE_SIZE);
                        gr.drawLine(j * IMAGE_SIZE, i, j * IMAGE_SIZE, ROWS * IMAGE_SIZE);

                    }
                }

            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
    }

    private void painter(int x, int y, int button) {
        if (button == 1) {
            panel.getGraphics().drawImage(imagesArray[field[x / IMAGE_SIZE][y / IMAGE_SIZE]], x, y,IMAGE_SIZE, IMAGE_SIZE, this);
        } else if (button == 3) {
            panel.getGraphics().drawImage(imagesArray[11], x, y,IMAGE_SIZE, IMAGE_SIZE, this);
        }

    }

    private void setImages() {

        imagesArray[0] = getImage("Zero".toLowerCase());
        imagesArray[1] = getImage("Num1".toLowerCase());
        imagesArray[2] = getImage("Num2".toLowerCase());
        imagesArray[3] = getImage("Num3".toLowerCase());
        imagesArray[4] = getImage("Num4".toLowerCase());
        imagesArray[5] = getImage("Num5".toLowerCase());
        imagesArray[6] = getImage("Num6".toLowerCase());
        imagesArray[7] = getImage("Num7".toLowerCase());
        imagesArray[8] = getImage("Num8".toLowerCase());
        imagesArray[9] = getImage("Closed".toLowerCase());
        imagesArray[10] = getImage("Opened".toLowerCase());
        imagesArray[11] = getImage("Flagged".toLowerCase());
        imagesArray[12] = getImage("BombBang".toLowerCase());
        imagesArray[13] = getImage("Bomb".toLowerCase());
        imagesArray[14] = getImage("icon".toLowerCase());

    }

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("pictures/" + name + ".png");
        return icon.getImage();
    }

}
