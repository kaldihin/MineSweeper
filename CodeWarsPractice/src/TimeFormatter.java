import java.util.ArrayList;

public class TimeFormatter {
    public static void main(String[] args) {
        System.out.println(TimeFormatter.formatDuration(826234626));
    }

    public static String formatDuration(int seconds) {

        int sec = 0, min = 0, hours = 0, days = 0, years = 0, last = 0, single = 0;

        ArrayList<Integer> arrayList = new ArrayList();

        StringBuilder result = new StringBuilder();

        if (seconds == 0)
        return "now";

            arrayList.add(seconds % 60);
            seconds /= 60;
            arrayList.add(seconds % 60);
            seconds /= 60;
            arrayList.add(seconds % 24);
            seconds /= 24;
            arrayList.add(seconds % 365);
            seconds /= 365;
            arrayList.add(seconds);

            for (int i = 0; i < 5; i++) {
                if (arrayList.get(i) != 0) {
                    last = i;
                    break;
                }
            }

        for (int i = 0; i < 5; i++) {
            if (arrayList.get(i) != 0) {
                single++;
            }
        }

        sec = arrayList.get(0);
        min = arrayList.get(1);
        hours = arrayList.get(2);
        days = arrayList.get(3);
        years = arrayList.get(4);

        if (years != 0) {

            if (single == 1 && last == 4) {
                if (years == 1)
                    result.append(years + " year");
                else result.append(years + " years");
            } else {
                if (years == 1 && last <= 2)
                    result.append(years + " year, ");
                else if (last <= 2)
                    result.append(years + " years, ");
                else if (years == 1)
                    result.append(years + " year, ");
                else {
                    result.append(years + " years, ");
                }
            }
        }

        if (days != 0) {

            if (single == 1 && last == 3) {
                if (days == 1)
                    result.append(days + " day");
                else result.append(days + " days");
            } else {
                if (days == 1 && last <= 1)
                    result.append(days + " day, ");
                else if (last <= 1)
                    result.append(days + " days, ");
                else if (days == 1 && result.length() != 0) {
                    result.deleteCharAt(result.length()-2);
                    result.append("and " + days + " day");
                }
                else if (result.length() != 0) {
                    result.deleteCharAt(result.length()-2);
                    result.append("and " + days + " days");
                }
            }
        }

        if (hours != 0) {

            if (single == 1 && last == 2) {
                if (hours == 1)
                    result.append(hours + " hour");
                else result.append(hours + " hours");
            } else {
                if (hours == 1 && last <= 0)
                    result.append(hours + " hour, ");
                else if (last <= 0)
                    result.append(hours + " hours, ");
                else if (hours == 1 && result.length() != 0) {
                    result.deleteCharAt(result.length()-2);
                    result.append("and " + hours + " hour");
                }
                else if (result.length() != 0) {
                    result.deleteCharAt(result.length()-2);
                    result.append("and " + hours + " hours");
                }
            }
        }

        if (min != 0) {

            if (single == 1 && last == 1) {
                if (min == 1)
                    result.append(min + " minute");
                else result.append(min + " minutes");
            } else {
                if (min == 1)
                    result.append(min + " minute, ");
                else if (min > 1)
                    result.append(min + " minutes, ");
                else if (min == 1 && result.length() != 0) {
                    result.deleteCharAt(result.length()-2);
                    result.append("and " + min + " minute");
                }
                else if (result.length() != 0) {
                    result.deleteCharAt(result.length()-2);
                    result.append("and " + min + " minutes");
                }
            }
        }

        if (sec != 0) {

            if (single == 1 && last == 0) {
                if (sec == 1)
                    result.append(sec + " second");
                else result.append(sec + " seconds");
            } else {
                if (sec == 1 && last != 0)
                    result.append(sec + " second, ");
                else if (last != 0)
                    result.append(sec + " seconds, ");
                else if (sec == 1 && result.length() != 0) {
                    result.deleteCharAt(result.length()-2);
                    result.append("and " + sec + " second");
                }
                else if (result.length() != 0) {
                    result.deleteCharAt(result.length()-2);
                    result.append("and " + sec + " seconds");
                }
            }

        }

        return result.toString();
    }
}
