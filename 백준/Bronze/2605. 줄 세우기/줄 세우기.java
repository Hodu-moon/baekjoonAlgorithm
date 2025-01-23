import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] student = new int[100];
        
        for(int i = 0; i < student.length; i++){
            student[i] = i + 1;
        }


        int[] number = new int[N];

        for(int i = 0; i < N; i++){
            number[i] = sc.nextInt();
        }

        for(int i = 1; i < N; i++){
            int start = i - number[i];
            int studentNum = student[i];

            for(int j = i ; j > start; j--  ){
                student[j] = student[j - 1];

            } 

            student[start] = studentNum;
            
        }

        for(int i = 0; i < N; i++){
            System.out.print( student[i] + " ");
        }


        
    }
}
