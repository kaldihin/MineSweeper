import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DifficultChooser {

    private static int difficulty = 1;
    private static boolean chosen = false;

    DifficultChooser() {

    }

    public static void init() {
        new DifficultChooserFrame();
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static boolean isChosen() {
        return chosen;
    }

    public static void setChosen(boolean chosen) {
        DifficultChooser.chosen = chosen;
        Main.setRunning();
    }

    public static void setDifficulty(int difficulty) {
        DifficultChooser.difficulty = difficulty;
    }
}
