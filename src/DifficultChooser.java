import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DifficultChooser extends JFrame {

    private static int difficulty = 0;
    public static boolean choosed = false;

    public void act() {

        choosed = false;
        setVisible(true);
//
//        while (true) {
//            if (choosed) {
//                setVisible(false);
//                choosed = false;
//            }
//        }
    }

    DifficultChooser() {
        JRadioButton easy = new JRadioButton("easy");
        JRadioButton middle = new JRadioButton("middle");
        JRadioButton difficult = new JRadioButton("difficult");

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                difficulty = 1;
                choosed = true;
                setVisible(false);
                dispose();
            }
        });
        middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                difficulty = 2;
                choosed = true;
                setVisible(false);
                dispose();
            }
        });
        difficult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                difficulty = 3;
                choosed = true;
                setVisible(false);
                dispose();
            }
        });

        setTitle("Choose difficulty level");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(easy);
        add(middle);
        add(difficult);
        setLocationRelativeTo(null);

    }

    public int getDifficulty() {
        return difficulty;
    }

}
