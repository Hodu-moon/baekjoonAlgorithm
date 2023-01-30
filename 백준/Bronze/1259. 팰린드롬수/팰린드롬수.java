
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String user = br.readLine();
            if(user.equals("0")){
                break;
            }
            char []a = user.toCharArray();
            boolean y = true;
            for(int i = 0; i < a.length/2 ;i++){
                if(a[i] != a[a.length - (i + 1) ]){
                    y = false;
                }
            }
            if(y){
                sb.append("yes").append("\n");
            }else
                sb.append("no").append("\n");
        }
        System.out.println(sb.toString());
    }
}
