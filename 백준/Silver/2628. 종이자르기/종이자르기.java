
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int N = sc.nextInt();

        List<Integer> wList = new ArrayList<>();
        List<Integer> hList = new ArrayList<>();

        wList.add(0);
        hList.add(0);
        wList.add(w);
        hList.add(h);


        for (int i = 0; i < N; i++) {
            int wh = sc.nextInt();
            int d = sc.nextInt();
            if (wh == 0) {
                hList.add(d);
            } else
                wList.add(d);
        }

        Collections.sort(wList);
        Collections.sort(hList);

        int maxH = Integer.MIN_VALUE;
        int maxW = Integer.MIN_VALUE;

        for (int i = 1; i < wList.size(); i++) {
            maxW = Math.max(maxW, (wList.get(i) - wList.get(i - 1)));
        }

        for (int i = 1; i < hList.size(); i++) {
            maxH = Math.max(maxH, (hList.get(i) - hList.get(i - 1)));
        }

        System.out.println(maxW * maxH);

    }
    // 10 8
    //3
    //0 3
    //1 4
    //0 2
}
