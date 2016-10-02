import java.util.Dictionary;
import java.util.Scanner;

public class HeadsAndTails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String resultList = scan.nextLine();
        String[] resultArr = resultList.split(", ");
        String head = "H";
        String tail = "T";
        int headLargestSeq = 0;
        int tailLargestSeq = 0;

        int headSeq = 0;
        int tailSeq = 0;
        for (int i = 0; i < resultArr.length; i++) {

            if (resultArr[i].equals(head)){
            headSeq++;
            tailSeq = 0;
            if (headSeq > headLargestSeq)
                headLargestSeq = headSeq;
            }
            else if(resultArr[i].equals(tail)){
                tailSeq++;
                headSeq = 0;
                if (tailSeq > tailLargestSeq)
                    tailLargestSeq = tailSeq;
            }
            else{
                System.out.println("Invalid input!");
                return;
            }
        }
        if (headLargestSeq > tailLargestSeq){
            System.out.println("H wins!");
        }
        else if(tailLargestSeq > headLargestSeq){
            System.out.println("T wins!");
        }
        else if(tailLargestSeq == headLargestSeq){
            System.out.println("Draw!");
        }
    }
}
