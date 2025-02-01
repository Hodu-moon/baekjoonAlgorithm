
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int[] A = new int[5];
            int[] B = new int[5];
            String aInput = br.readLine();

            String[] aSplit = aInput.split(" ");

            for(int j = 1; j < aSplit.length; j++){
                A[Integer.parseInt(aSplit[j])] += 1;
            }

            String bInput = br.readLine();
            String[] bSplit = bInput.split(" ");
            for(int j = 1; j < bSplit.length; j++){
                B[Integer.parseInt(bSplit[j])] += 1;
            }

            for(int j = 4; j >= 1; j--){
                if(A[j] > B[j]){
                    sb.append("A").append("\n");
                    break;
                }else if(A[j] == B[j]){
                    if(j == 1){
                        sb.append("D").append("\n");
                    }

                }else{
                    sb.append("B").append("\n");
                    break;
                }

            }

        }

        System.out.println(sb);
    }
}

//5
//1 4
//4 3 3 2 1
//5 2 4 3 2 1
//4 4 3 3 1
//4 3 2 1 1
//4 2 3 2 1
//4 4 3 2 1
//3 4 3 2
//5 4 4 2 3 1
//5 4 2 4 1 3