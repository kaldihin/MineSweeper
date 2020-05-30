import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultChooserFrame extends JFrame {

    DifficultChooserFrame() {
        JRadioButton easy = new JRadioButton("easy");
        JRadioButton middle = new JRadioButton("middle");
        JRadioButton difficult = new JRadioButton("difficult");

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DifficultChooser.setDifficulty(1);
                DifficultChooser.setChosen(true);
                dispose();
            }
        });
        middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DifficultChooser.setDifficulty(2);
                DifficultChooser.setChosen(true);
                dispose();
            }
        });
        difficult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DifficultChooser.setDifficulty(3);
                DifficultChooser.setChosen(true);
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
        setVisible(true);
    }

}
