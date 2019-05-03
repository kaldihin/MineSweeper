import java.util.*;

public class TimeFormatter2 {
    public static void main(String[] args) {
        System.out.println(TimeFormatter2.formatDuration(5838583));
    }

    public static String formatDuration(int seconds) {

        int sec = 0, min = 0, hours = 0, days = 0, years = 0, singleValue = 0, count = 0, singleType = -1;

        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] ar = new int[5];

        StringBuilder result = new StringBuilder();

        if (seconds == 0)
            return "now";

        ar[0] = seconds % 60;
        seconds /= 60;
        ar[1] = seconds % 60;
        seconds /= 60;
        ar[2] = seconds % 24;
        seconds /= 24;
        ar[3] = seconds % 365;
        seconds /= 365;
        ar[4] = seconds;

        for (int i = 4; i >= 0; i--) {
            if (ar[i] != 0)
                count++;
        }

            if (ar[4] != 0 && count > 1) {
                if (ar[4] == 1)
                    result.append(ar[4] + " year, ");
                else result.append(ar[4] + " years, ");
                count--;
            } else if (ar[4] != 0 && count == 1) {
                if (ar[4] == 1)
                    result.append(ar[4] + " year");
                else result.append(ar[4] + " years");
                count--;
            }

        if (ar[3] != 0 && count > 1) {
            if (ar[3] == 1)
                result.append(ar[3] + " day, ");
            else result.append(ar[3] + " days, ");
            count--;
        } else if (ar[3] != 0 && count == 0) {
            if (ar[3] == 1)
                result.append("and " + ar[3] + " day");
            else result.append("and " + ar[3] + " days");
            count--;
        } else if (ar[3] != 0 && count == 1) {
            if (ar[3] == 1)
                result.append(ar[3] + " day");
            else result.append(ar[3] + " days");
            count--;
        }

        if (ar[2] != 0 && count > 1) {
            if (ar[2] == 1)
                result.append(ar[2] + " hour, ");
            else result.append(ar[2] + " hours, ");
            count--;
        } else if (ar[2] != 0 && count == 0) {
            if (ar[2] == 1)
                result.append("and " + ar[2] + " hour");
            else result.append("and " + ar[2] + " hours");
            count--;
        } else if (ar[2] != 0 && count == 1) {
            if (ar[2] == 1)
                result.append(ar[2] + " hour");
            else result.append(ar[2] + " hours");
            count--;
        }

        if (ar[1] != 0 && count > 1) {
            if (ar[1] == 1)
                result.append(ar[1] + " minute, ");
            else result.append(ar[1] + " minutes, ");
            count--;
        } else if (ar[1] != 0 && count == 0) {
            if (ar[1] == 1)
                result.append("and " + ar[1] + " minute");
            else result.append("and " + ar[1] + " minutes");
            count--;
        } else if (ar[1] != 0 && count == 1) {
            if (ar[1] == 1)
                result.append(ar[1] + " minute");
            else result.append(ar[1] + " minutes");
            count--;
        }

        if (ar[0] != 0 && count > 1) {
            if (ar[0] == 1)
                result.append(ar[0] + " second, ");
            else result.append(ar[0] + " seconds, ");
            count--;
        } else if (ar[0] != 0 && count >= 1) {
            if (ar[0] == 1)
                result.append("and " + ar[0] + " second");
            else result.append("and " + ar[0] + " seconds");
            count--;
        } else if (ar[0] != 0 && count == 1) {
            if (ar[0] == 1)
                result.append(ar[0] + " second");
            else result.append(ar[0] + " seconds");
            count--;
        }

        return result.toString();
    }
}
