public class Starter {

    public static void main(String[] args) {

        DifficultChooser difficultChooser = new DifficultChooser();
        difficultChooser.act();
        Main mn = new Main(difficultChooser.getDifficulty());

        while (true) {
            if (!mn.isRunning()) {
                difficultChooser.act();
                mn = new Main(difficultChooser.getDifficulty());
            }
        }
    }

}
