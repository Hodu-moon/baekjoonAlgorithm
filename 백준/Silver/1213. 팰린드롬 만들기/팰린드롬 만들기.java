

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();



        int[] arr = new int['z' + 1];


        for(int i = 0; i < input.length(); i++){
            arr[input.charAt(i)] += 1;
        }

        int oddCount = 0;
        char oddChar= 'A';

        StringBuilder left = new StringBuilder();
        for(int i = 'A'; i <= 'z'; i++){
            if(arr[i] % 2 == 1){
                oddCount++;
                if(oddCount > 1){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                oddChar = (char)i;
            }

            if(arr[i] != 0) {
                for(int j = 0; j < arr[i]/2; j++){
                    left.append((char)i);
                }
            }
        }


//        System.out.println(left.toString());
        if(oddCount == 1){
            System.out.println(left.toString() + oddChar +left.reverse().toString());
        }else {
            System.out.println(left.toString() + left.reverse().toString());
        }

    }
}
