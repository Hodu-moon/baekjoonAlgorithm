
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w , h, x, y, t;
        String[] split = br.readLine().split(" ");

        w = Integer.parseInt(split[0]);
        h = Integer.parseInt(split[1]);
        split = br.readLine().split(" ");

        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
        String s = br.readLine();
        t = Integer.parseInt(s);

        int end_x =  ( x + t ) %  (2*w);
        int end_y = (y + t ) %  (2*h);

        if(end_x > w ){
            end_x =  2 * w - end_x;
        }

        if(end_y > h){
            end_y =2 * h - end_y ;
        }

        System.out.println(end_x + " " + end_y);
    }
}
