public class Starter {

    public static void main(String[] args) {

        DifficultChooser difficultChooser = new DifficultChooser();
        difficultChooser.act();
        Main mn;

        while (true) {
            if (!Main.running) {
                difficultChooser.act();
                mn = new Main(difficultChooser.getDifficulty());
            }
        }
    }

}
