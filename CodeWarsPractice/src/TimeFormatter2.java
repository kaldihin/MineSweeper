import java.util.*;

public class TimeFormatter2 {
    public static void main(String[] args) {
        System.out.println(TimeFormatter2.formatDuration(826234626));
    }

    public static String formatDuration(int seconds) {

        int sec = 0, min = 0, hours = 0, days = 0, years = 0, singleValue = 0, single = 0, singleType = -1;

        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        StringBuilder result = new StringBuilder();

        if (seconds == 0)
            return "now";

        list.add(seconds % 60);
        seconds /= 60;
        list.add(seconds % 60);
        seconds /= 60;
        list.add(seconds % 24);
        seconds /= 24;
        list.add(seconds % 365);
        seconds /= 365;
        list.add(seconds);

        for (Integer element : list) {
            if (element != 0) {
                single++;
                singleValue = element;
            }
            singleType++;
        }

        if (single == 1) {
            if (singleType == 4) {
                if (singleValue == 1)
                    result.append(singleValue + "second");
                else result.append(singleValue + "seconds");
            }

            if (singleType == 3) {
                if (singleValue == 1)
                    result.append(singleValue + "minute");
                else result.append(singleValue + "minutes");
            }

            if (singleType == 2) {
                if (singleValue == 1)
                    result.append(singleValue + "hour");
                else result.append(singleValue + "hours");
            }

            if (singleType == 1) {
                if (singleValue == 1)
                    result.append(singleValue + "day");
                else result.append(singleValue + "days");
            }

            if (singleType == 0) {
                if (singleValue == 1)
                    result.append(singleValue + "year");
                else result.append(singleValue + "years");
            }

        }

        for (Integer val : map.values()) {
            if (val != 0) {

            }
        }


            /*list.add(seconds % 60);
            seconds /= 60;
            list.add(seconds % 60);
            seconds /= 60;
            list.add(seconds % 24);
            seconds /= 24;
            list.add(seconds % 365);
            seconds /= 365;
            list.add(seconds);*/

        return result.toString();
    }
}
