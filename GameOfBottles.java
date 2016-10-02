import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;

public class GameOfBottles {
    public static void main(String[] args) {

        int countPoints = 3;

        String[] points = new String[countPoints];
        points[0] = "1 1";
        points[1] = "1 2";
        points[2] = "3 3";
        String letters = generateLetterString(countPoints);

        int shortestPath = Integer.MAX_VALUE;
        ArrayList<String> permutations = permutation(letters);
        for (int i = 0; i < permutations.size(); i++) {
            int distance = calcDistance(permutations.get(i), points);
            if (distance < shortestPath){
                shortestPath = distance;
            }
        }
        System.out.println(shortestPath);


    }

    private static int generateLetterToIndex(char letter){
        int index = -1;
        switch (letter) {
            case 'A':  index = 0;
                break;
            case 'B':  index = 1;
                break;
            case 'C':  index = 2;
                break;
            case 'D':  index = 3;
                break;
            case 'E':  index = 4;
                break;
            case 'F':  index = 5;
                break;
            case 'G':  index = 6;
                break;
            case 'H':  index = 7;
                break;
            case 'I':  index = 8;
                break;
        }
        return index;
    }

    private static void findMinDistance(){

    }

    private static int calcDistance(String permutation, String[] points){
        char[] permLetters = permutation.toCharArray();
        int distance = 0;
        for (int i = 0; i < permLetters.length-1; i++) {
            char letter1 = permLetters[i];
            char letter2 = permLetters[i+1];
            int index1 = generateLetterToIndex(letter1);
            int index2 = generateLetterToIndex(letter2);
            String pointOne = points[index1];
            String pointTwo = points[index2];
            int x1 = Integer.parseInt(pointOne.substring(0,1));
            int y1 = Integer.parseInt(pointOne.substring(2));
            int x2 = Integer.parseInt(pointTwo.substring(0,1));
            int y2 = Integer.parseInt(pointTwo.substring(2));
            int currentDistance = Math.abs((x1 - x2) + (y1 - y2));
            distance += currentDistance;
        }
        return  distance;
    }

    private static int calcDistBetweenTwoPoints(String pointOne, String pointTwo){
        String[] point1 = pointOne.split(" ");
        String[] point2 = pointTwo.split(" ");
        int pointOneX = Integer.parseInt(point1[0]);
        int pointOneY = Integer.parseInt(point1[1]);
        int pointTwoX = Integer.parseInt(point2[0]);
        int pointTwoY = Integer.parseInt(point2[1]);

        int distance = (pointTwoX - pointOneX) + (pointTwoY - pointOneY);
        return distance;
    }

    private static String generateLetterString(int countPoints){
        String letters = "";
        for (int i = 0;i < countPoints;i++){
            char upper = (char) ('A' + i);
            letters += upper;
        }
        return letters;
    }


    public static ArrayList<String> permutation(String s) {
        // The result
        ArrayList<String> res = new ArrayList<String>();
        // If input string's length is 1, return {s}
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            // Find out the last character
            String last = s.substring(lastIndex);
            // Rest of the string
            String rest = s.substring(0, lastIndex);
            // Perform permutation on the rest string and
            // merge with the last character
            res = merge(permutation(rest), last);
        }
        return res;
    }

    /**
     * @param list a result of permutation, e.g. {"ab", "ba"}
     * @param c    the last character
     * @return     a merged new list, e.g. {"cab", "acb" ... }
     */
    public static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<String>();
        // Loop through all the string in the list
        for (String s : list) {
            // For each string, insert the last character to all possible postions
            // and add them to the new list
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }

}
