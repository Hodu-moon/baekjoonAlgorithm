
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.next();

        String users[] = new String[user.length()];
        for(int i = 0; i < user.length(); i++){
            users[i] = user.substring(i);
        }


        Arrays.sort(users);

        StringBuilder sb = new StringBuilder();
       for(int i = 0; i < users.length; i++){
           sb.append(users[i]);
           sb.append("\n");
       }
        System.out.println(sb.toString());
    }
}
