import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        slangWords sl = new slangWords();
        Scanner sc = new Scanner(System.in);
        int num;
        sl.readFile();
        do {
            System.out.print("Input number you want:");
            num = sc.nextInt();
            if(num==1)
            sl.findWithDef();
            else if(num==2)
            sl.takeHistoryList();
        }while (num!=0);

    }
}
