import java.util.*;

public class StringsAndNumbers {
    public static Scanner scan = new Scanner(System.in);
    public static String input = scan.nextLine();
    public static void main(String[] args) {

        int len = input.length();
        Map<Character, Integer> numChars = new HashMap<Character, Integer>(Math.min(len, 26));

        for (int i = 0; i < len; ++i) {
            char charAt = input.charAt(i);

            if (!numChars.containsKey(charAt)) {
                numChars.put(charAt, 1);
            } else {
                numChars.put(charAt, numChars.get(charAt) + 1);
            }
        }
        System.out.println(numChars);
        String[] result = findMaxChar(numChars);
        String maxValueChar = result[0];
        int charMaxOcc = Integer.parseInt(result[1]);

        System.out.println(result[1]);

        for (Map.Entry<Character, Integer> entry : numChars.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()== charMaxOcc-1) {
                input = input.replaceAll(entry.getKey().toString(), "8");
            }
            if (entry.getValue()== charMaxOcc-2) {
                input = input.replaceAll(entry.getKey().toString(), "7");
            }
            if (entry.getValue()== charMaxOcc-3) {
                input = input.replaceAll(entry.getKey().toString(), "6");
            }
            if (entry.getValue()== charMaxOcc-4) {
                input = input.replaceAll(entry.getKey().toString(), "5");
            }
            if (entry.getValue()== charMaxOcc-5) {
                input = input.replaceAll(entry.getKey().toString(), "4");
            }
            if (entry.getValue()== charMaxOcc-6) {
                input = input.replaceAll(entry.getKey().toString(), "3");
            }
            if (entry.getValue()== charMaxOcc-7) {
                input = input.replaceAll(entry.getKey().toString(), "2");
            }
            if (entry.getValue()== charMaxOcc-8) {
                input = input.replaceAll(entry.getKey().toString(), "1");
            }
            if (entry.getValue()== charMaxOcc-9) {
                input = input.replaceAll(entry.getKey().toString(), "0");
            }
        }
        System.out.println(input);
    }

    public static String[] findMaxChar(Map<Character, Integer> numChars){
        int maxValueInMap=(Collections.max(numChars.values()));  // This will return max value in the Hashmap
        for (Map.Entry<Character, Integer> entry : numChars.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                String[] result = new String[2];
                result[0] = entry.getKey().toString();
                result[1] = entry.getValue().toString();
                input = input.replaceAll(entry.getKey().toString(), "9");
                return result;
            }
        }

        return null;
    }
}