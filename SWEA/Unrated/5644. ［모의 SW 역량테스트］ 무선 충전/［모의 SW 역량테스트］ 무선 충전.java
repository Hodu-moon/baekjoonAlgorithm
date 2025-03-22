
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int MOVE, AP_COUNT , Ax, Ay, Bx, By, result;

    // 안움, 상 우 하 좌

    // 2 2 3
    // 4 4 1
    static int[] dx = {0,  0 ,1, 0, -1 };
    static int[] dy = {0, -1 ,0 , 1, 0 };

    static int[] A_MOVE, B_MOVE;
    static List<AccessPoint> accessPointList;


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine(), " ");
            MOVE = Integer.parseInt(st.nextToken());
            AP_COUNT = Integer.parseInt(st.nextToken());
            A_MOVE = new int[MOVE];
            B_MOVE = new int[MOVE];
            result = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < MOVE; i++){
                A_MOVE[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < MOVE; i++){
                B_MOVE[i] = Integer.parseInt(st.nextToken());
            }

            accessPointList = new ArrayList<>();

            for(int i = 0; i < AP_COUNT; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int chargeRange = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                accessPointList.add(new AccessPoint(x, y, chargeRange, power));
            }

            solve();

//            System.out.println();



            sb.append("#").append(t).append(" ").append(result).append("\n");

        }

        System.out.println(sb);
    }

    static void solve(){


        for(int i = 0; i <= MOVE; i++){
            List<AccessPoint> A = new ArrayList<>();
            List<AccessPoint> B = new ArrayList<>();

            // 1. 움직이기
            if(i == 0){
                Ax = Ay = 1;
                Bx = By = 10;
            }else{
                Ax = Ax + dx[ A_MOVE[i - 1] ];
                Ay = Ay + dy[ A_MOVE[i - 1] ];
                Bx = Bx + dx[ B_MOVE[i - 1] ];
                By = By + dy[ B_MOVE[i - 1] ];
            }

//            System.out.println("Ax : " + Ax + " Ay :" + Ay +" Bx : " + Bx + " By : " + By  );
            // 2. Access Point 돌면서 해당하는 엑세서 포인트 찾기
            for(AccessPoint ap : accessPointList){
                if(calcDistance(0, ap)){
                    A.add(ap);
                }

                if(calcDistance(1, ap)){
                    B.add(ap);
                }
            }

            // 3. Access Point 끼리 해서 최대값 얻기
            int temp = 0;



            if(A.isEmpty()){ // A가 비어있다면 B만 보기
                for(AccessPoint b : B){
                    temp = Math.max(temp, b.power);
                }
            }else if(B.isEmpty()){ // B가 비어있다면 A만 보기
                for(AccessPoint a : A){
                    temp = Math.max(temp, a.power);
                }
            }else{
                int Atemp = 0;
                int Btemp = 0;
                //
                for(AccessPoint a : A){
                    for(AccessPoint b : B){
                        // 1. 같은곳
                        if(a.equals(b)){
                            temp = Math.max(temp, a.power);
                        }else{
                            Atemp = a.power;
                            Btemp = b.power;

                            temp = Math.max(temp, Atemp + Btemp);
                        }


                        // 2. 다른곳

                    }
                }

            }

//            System.out.print(temp + " ");
            result += temp;

        }


    }

    static boolean calcDistance(int AB, AccessPoint ap){
        //0 - A
        // 1 - B
        int x, y;
        if(AB == 0){
            x = Ax;
            y = Ay;
        }else{
            x = Bx;
            y = By;
        }

        return Math.abs(x - ap.x) + Math.abs(y - ap.y) <= ap.chargeRange;

    }

    static class AccessPoint{
        int x, y, chargeRange, power;

        public AccessPoint(int x, int y, int chargeRange, int power) {
            this.x = x;
            this.y = y;
            this.chargeRange = chargeRange;
            this.power = power;
        }

        @Override
        public boolean equals(Object o){

            return this.x == ((AccessPoint)(o)).x
                    && this.y == ((AccessPoint)(o)).y
                    ;
        }
    }


}
//
//5
//        20 3
//        2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
//        4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
//        4 4 1 100
//        7 10 3 40
//        6 3 2 70
