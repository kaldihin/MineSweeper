import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DifficultChooser extends JFrame {

    private int difficulty = 0;
    private boolean choosed = false;

    public void act() {

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
//                choosed = true;
                setVisible(false);
            }
        });
        middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                difficulty = 2;
//                choosed = true;
                setVisible(false);
            }
        });
        difficult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                difficulty = 3;
//                choosed = true;
                setVisible(false);
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