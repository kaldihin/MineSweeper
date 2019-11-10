import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

class Main extends JFrame {

    private static final int COLS = 18, ROWS = 18, IMAGE_SIZE = 30;
    private static int difficulty = 0;
    private static Image[] imagesArray = new Image[16];
    private static JPanel panel;
    private int[][] field = new int[COLS][ROWS];
    private int roundX = 0, roundY = 0, bombsCount;
    private static boolean initiator = false;

    private boolean running = false;

    Main(int diff) {

        running = true;
        setImages();
        startGame();
        difficulty = diff;
        bombsCount = difficulty * 20 * 2;

    }

    public boolean isRunning() {
        return running;
    }

    private void startGame() {
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
                        if (!initiator) {
                            fieldInitiation(e.getX() / IMAGE_SIZE, e.getY() / IMAGE_SIZE);
                            drawEmptys();
                            initiator = true;
                        }
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

    private void fieldInitiation(int firstX, int firstY) {

        /*
         *
         *   Making the field empty
         *
         * */

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                field[i][j] = 0;
            }
        }

        int value1, value2, quantity = difficulty * 20, cellBombs = 0;
        Random rand = new Random();

        /*
         *
         *   Random putting bombs in the field
         *
         * */
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i != firstX && j != firstY)
                    while (quantity != 0) {
                        value1 = rand.nextInt(COLS);
                        value2 = rand.nextInt(COLS);
                        if (field[value1][value2] == 0 && value1 != firstX && value2 != firstY) {
                            field[value1][value2] = 13;
                            quantity--;
                        }
                    }
            }
        }

        /*
         *
         *   Putting numbers between the bombs
         *
         * */

        boolean left = false, right = false, up = false, down = false;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                if (j == 0)
                    left = true;
                if (i == ROWS - 1)
                    down = true;
                if (i == 0)
                    up = true;
                if (j == COLS - 1)
                    right = true;

                if (left && up) {
                    if (field[i][j + 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j + 1] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                    field[i][j] = cellBombs;
                }

                else if (right && up) {
                    if (field[i][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j - 1] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                    field[i][j] = cellBombs;
                }

                else if (right && down) {
                    if (field[i][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j - 1] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                    field[i][j] = cellBombs;
                }

                else if (left && down) {
                    if (field[i][j + 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j + 1] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                    field[i][j] = cellBombs;
                }

                else if (left) {
                    if (field[i - 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j + 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i][j + 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j + 1] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                    field[i][j] = cellBombs;
                }

                else if (down) {
                    if (field[i][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i][j + 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j + 1] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                    field[i][j] = cellBombs;
                }

                else if (right) {
                    if (field[i + 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                    field[i][j] = cellBombs;
                }

                else if (up) {
                    if (field[i + 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i][j + 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j + 1] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                    field[i][j] = cellBombs;
                }

                else {

                    if (field[i - 1][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i - 1][j + 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i][j + 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j - 1] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j] == 13) {
                        cellBombs++;
                    }
                    if (field[i + 1][j + 1] == 13) {
                        cellBombs++;
                    }

                    if (field[i][j] == 0)
                        field[i][j] = cellBombs;

                }


                left = false;
                right = false;
                up = false;
                down = false;
                cellBombs = 0;
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
                        gr.drawLine(i, j * IMAGE_SIZE, (i + 1) * IMAGE_SIZE, j * IMAGE_SIZE);
                        gr.drawLine(j * IMAGE_SIZE, i, j * IMAGE_SIZE, ROWS * IMAGE_SIZE);

                    }
                }

            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
    }

    private void painter(int x, int y, int button) {
        if (button == 1) {
            if (field[x / IMAGE_SIZE][y / IMAGE_SIZE] == 13) {
                bombsPainter();
            }
            panel.getGraphics().drawImage(imagesArray[field[x / IMAGE_SIZE][y / IMAGE_SIZE]], x, y, IMAGE_SIZE, IMAGE_SIZE, this);
        } else if (button == 3) {
            panel.getGraphics().drawImage(imagesArray[11], x, y, IMAGE_SIZE, IMAGE_SIZE, this);
            --bombsCount;
            System.out.println(bombsCount);
            if (bombsCount == 40) {
                int resultButton = JOptionPane.showConfirmDialog(this, "You won! Do You want to play again?", "Congratulations", JOptionPane.YES_NO_OPTION);
                if (resultButton == JOptionPane.YES_OPTION) {
                    running = false;
                    setVisible(false);
                } else System.exit(0);
            }
        }

    }

    private void drawEmptys() {
        Random rand = new Random(23);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if ( rand.nextInt(ROWS) > 10 && field[i][j] != 13) {
                    panel.getGraphics().drawImage(imagesArray[field[i][j]], i * IMAGE_SIZE, j * IMAGE_SIZE, IMAGE_SIZE, IMAGE_SIZE, this);
                }
                if (field[i][j] == 0)
                panel.getGraphics().drawImage(imagesArray[field[i][j]], i * IMAGE_SIZE, j * IMAGE_SIZE, IMAGE_SIZE, IMAGE_SIZE, this);
            }
        }
    }

    private void bombsPainter() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                //panel.getGraphics().drawImage(imagesArray[13], i*IMAGE_SIZE, j*IMAGE_SIZE, IMAGE_SIZE, IMAGE_SIZE, this);
                panel.getGraphics().drawImage(imagesArray[field[i][j]], i * IMAGE_SIZE, j * IMAGE_SIZE, IMAGE_SIZE, IMAGE_SIZE, this);
            }
        }
        int buttonResult = JOptionPane.showConfirmDialog(this, "Do You want to start a new game?", "Continue the game",
                JOptionPane.YES_NO_OPTION);
        if (buttonResult == JOptionPane.NO_OPTION)
            System.exit(0);
        else {
            running = false;
            setVisible(false);
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

    private void redraw() {
        setVisible(false);
    }

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("pictures/" + name + ".png");
        return icon.getImage();
    }

}
