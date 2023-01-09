
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []user = br.readLine().split(" ");

        String user1 = user[0].concat(user[1]);
        String user2 = user[2].concat(user[3]);
        System.out.println( (long)(Double.parseDouble(user1) + Double.parseDouble(user2)) );
    }
}
