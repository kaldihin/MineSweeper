public class Starter {

    public static boolean running = false;

    public static void main(String[] args) {

        DifficultChooser difficultChooser = new DifficultChooser();
        difficultChooser.act();
        if (DifficultChooser.choosed) {
            new Main(3);
        }

        new Main(2);



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
