public class Starter {

    public static boolean running = false;

    public static void main(String[] args) {

        DifficultChooser difficultChooser = new DifficultChooser();

        while (true) {
            while (!DifficultChooser.choosed) {
                difficultChooser.act();
            }

            if (!running)
            new Main(difficultChooser.getDifficulty());

        }


//            if (DifficultChooser.choosed) {
//                running = true;
//                mn = new Main(difficultChooser.getDifficulty());
//            }
//            else {
//                mn.dispose();
//                difficultChooser.act();
//            }

    }

}
