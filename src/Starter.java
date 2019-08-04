import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Starter {

    public static void main(String[] args) {
        JFrame chooser;
        JRadioButton easy = new JRadioButton("easy");
        JRadioButton middle = new JRadioButton("middle");
        JRadioButton difficult = new JRadioButton("difficult");

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Main(1);
            }
        });
        middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Main(2);
            }
        });
        difficult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Main(3);
            }
        });

        chooser = new JFrame("Choose difficulty level");
        chooser.setSize(200, 100);
        chooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chooser.setLayout(new BoxLayout(chooser.getContentPane(), BoxLayout.X_AXIS));
        chooser.add(easy);
        chooser.add(middle);
        chooser.add(difficult);
        chooser.setLocationRelativeTo(null);

        chooser.setVisible(true);


    }
}
