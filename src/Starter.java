import javax.swing.*;

public class Starter {

    public static boolean running = false;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Main();
                }
            });

//        if (!difficultChooser.isChosen()) {
//            difficultChooser.init();
//        } else {
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    new Main(difficultChooser);
//                }
//            });
//        }

    }

}
