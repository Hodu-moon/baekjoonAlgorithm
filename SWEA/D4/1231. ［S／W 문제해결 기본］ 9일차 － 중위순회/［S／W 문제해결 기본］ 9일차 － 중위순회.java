
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < 10; tc++){
            int N = Integer.parseInt(br.readLine());

            char[] tree = new char[N + 1];

            for(int i = 1; i <= N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int index = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                tree[i] = value.charAt(0);
            }

            StringBuilder temp = new StringBuilder();
            StringBuilder tempResult = inOrder(tree, 1, temp , N);

            sb.append("#").append(tc + 1).append(" ").append(tempResult).append("\n");
        }

        System.out.print(sb);

    }

    static StringBuilder inOrder(char[] tree, int index, StringBuilder sb, int N){
//        System.out.println("index : " + index);

        if(index * 2 <= N)
            inOrder(tree, index * 2, sb, N);
        sb.append(tree[index]);
        if(index * 2 + 1 <= N)
            inOrder(tree, index * 2 + 1, sb, N);

        return sb;
    }
}


//8
//1 W 2 3
//2 F 4 5
//3 R 6 7
//4 O 8
//5 T
//6 A
//7 E
//8 S