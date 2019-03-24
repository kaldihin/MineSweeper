import javax.swing.*;
import java.awt.*;
import sweeper.Box;

public class Main extends JFrame {

    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 60;
    private JPanel panel;

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box : Box.values())
                g.drawImage((Image) box.image,box.ordinal() * IMAGE_SIZE, 0, this);
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
    }

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("pictures/" + name + ".png");
        return icon.getImage();
    }

}
