
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static int[] dx = {-1, 1};
    static boolean[] visited;
    static List<Wheel> wheels = new ArrayList<>();

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // dummy
        wheels.add(new Wheel());

        for(int i = 1; i <= 4; i++){
            String input = br.readLine();
            int[] su = new int[8];
            for(int j = 0; j < 8; j++){
                su[j] = input.charAt(j) - '0';
            }
            wheels.add(new Wheel(su, i));
        }


//        printWheels();



        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int no = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            solve(no, dir);
//            System.out.println("========================");
//            printWheels();

//            System.out.println();
        }

        int sum = 0;
        for(int i = 1; i <= 4; i++){
            if(wheels.get(i).nums[0] == 1){
                sum += (1 << (i -1));
            }
        }

        System.out.println(sum);

    }

    static void solve(int no, int dir){
        visited = new boolean[5];
        // 1-> 4
        Queue<Wheel> queue = new ArrayDeque<>();
        visited[no] = true;
        Wheel first = wheels.get(no);
        first.moveDirection = dir;
        queue.offer(first);

        List<Integer> lists = new ArrayList<>();
        lists.add(no);

        while(!queue.isEmpty()){
            Wheel cur = queue.poll();

            for(int i = 0; i < 2; i++){
                // -1, 1
                int next = cur.idx + dx[i];

                if(!isIn(next))
                    continue;

                if(visited[next])
                    continue;

                // <-
                Wheel nextWheel = wheels.get(next);

                //
                if(i == 0 && cur.left != nextWheel.right){
                    visited[next] = true;
                    nextWheel.moveDirection = cur.moveDirection * -1;
                    queue.offer(nextWheel);
                    lists.add(next);
                }

                if(i == 1 && cur.right != nextWheel.left){
                    visited[next] = true;
                    nextWheel.moveDirection = cur.moveDirection * -1;
                    queue.offer(nextWheel);
                    lists.add(next);
                }

            }

        }


        for(int wheelNo : lists){
            wheels.get(wheelNo).move();
        }

    }
    static boolean isIn(int x){
        return 1 <= x && x <= 4;
    }

    static class Wheel {
        int[] nums;
        int left, right, moveDirection, idx;
        public Wheel(){

        }

        public Wheel(int[] nums, int idx) {
            this.nums = nums;
            this.idx = idx;
            left = nums[6];
            right = nums[2];
        }

        void move(){
            if(moveDirection == 1){
                clockMove();
            }else{
                reverseClockMove();
            }
        }

        void clockMove() {
            // 시계 방향으로 움직이기
            int seven = nums[7];
            for(int i = 6; i >= 0; i--){
                nums[i + 1] = nums[i];
            }
            nums[0] = seven;
            left = nums[6];
            right = nums[2];


        }

        void reverseClockMove() {
            int zero = nums[0];
            for(int i = 1; i <=7; i++){
                nums[i - 1] = nums[i];
            }
            nums[7] = zero;

            left = nums[6];
            right = nums[2];

        }

        @Override
        public String toString() {
            return "Wheel{" +
                    "nums=" + Arrays.toString(nums) +
                    ", left=" + left +
                    ", right=" + right +
                    ", moveDirection=" + moveDirection +
                    '}';
        }
    }

    static void printWheels(){
       for(int i = 1; i <= 4; i++){
           System.out.println(wheels.get(i));
       }
    }
}

//10101111
//01111101
//11001110
//00000010
//2
//3 -1
//1 1
