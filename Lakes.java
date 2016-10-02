import java.util.Scanner;

public class Lakes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String lake = scan.nextLine();
        int rowNumber = 0;
        int collNumber = 0;
        double numberOfFullSquares = 0;
        for (int i = 0; i < lake.length(); i++){
            char letter = lake.charAt(i);
            if (letter == 'd'){
                if(rowNumber >= 0){
                    numberOfFullSquares += rowNumber + 0.5;
                }
                rowNumber++;
                collNumber++;
            }
            else if (letter == 'h'){
                if(rowNumber >= 0) {
                    numberOfFullSquares += rowNumber;
                }
                collNumber++;
            }
            else if(letter == 'u'){
                rowNumber--;
                collNumber++;
                if(rowNumber >= 0) {
                    numberOfFullSquares += rowNumber + 0.5;
                }
            }
            else{
                System.out.println("Invalid input");
                break;
            }
        }
        System.out.print(numberOfFullSquares * 1000);
    }
}
