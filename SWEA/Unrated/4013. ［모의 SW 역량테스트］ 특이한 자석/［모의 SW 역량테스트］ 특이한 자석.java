
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int K;
    static List<Magent> magentList;
    static int[] dx = {-1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            K = Integer.parseInt(br.readLine());
            // 자석 정보 받기
            magentList = new ArrayList<>();
            magentList.add(new Magent()); // dummy

            // 입력 받기
            for(int i = 0; i < 4; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int[] nums = new int[8];
                for(int j = 0; j < 8; j++){
                    nums[j] = Integer.parseInt(st.nextToken());
                }

                magentList.add(new Magent(nums));
            }

            for(int k = 0; k < K; k++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int magnetIdx = Integer.parseInt(st.nextToken());
                int moveDirection = Integer.parseInt(st.nextToken());


                // 돌리기
                solve(magnetIdx, moveDirection);


            }

            // 1 2 4 8
            int sum = 0;
            for(int i = 1; i <=4; i++){
                sum += ( magentList.get(i).get12() <<  i - 1);
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static void solve(int magnetIdx, int moveDirection){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[5];
        queue.offer(magnetIdx);
        magentList.get(magnetIdx).moveDirection = moveDirection;
        visited[magnetIdx] = true;
        List<Integer> moveList = new ArrayList<>();
        moveList.add(magnetIdx);

        while(!queue.isEmpty()){
            int curIdx = queue.poll();

            for(int i = 0; i < 2; i++){
                int next = curIdx + dx[i];

                if(!isIn(next))
                    continue;

                if(visited[next])
                    continue;

//                System.out.println("next : " + next);

                if(i == 0){ // -1 인덱스
                    // 현재의 왼쪽과 -1 인덱스의 오른쪾을 봐야함

//                    System.out.println("cur.left: "  + magentList.get(curIdx).getLeft()
//                            +  "next.right: " + magentList.get(next).getRight());

                    if(magentList.get(curIdx).getLeft() != magentList.get(next).getRight()){


                        visited[next] = true;
                        queue.offer(next);

                        magentList.get(next).moveDirection =
                                magentList.get(curIdx).moveDirection * -1 ;

                        moveList.add(next);

                    }
                }else{ // + 1 인덱스

//                    System.out.println("cur.right: "  + magentList.get(curIdx).getRight()
//                            +  "next.left: " + magentList.get(next).getLeft());

                    if(magentList.get(curIdx).getRight() != magentList.get(next).getLeft()){
                        visited[next] = true;
                        queue.offer(next);

                        magentList.get(next).moveDirection =
                                magentList.get(curIdx).moveDirection * -1 ;

                        moveList.add(next);
                    }

                }
            }



        }


        for(int moveIdx : moveList){
//            System.out.println("moveIdx: " + moveIdx);
            magentList.get(moveIdx).move();
        }


    }

    static boolean isIn(int x){
        return 0 < x && x < 5;
    }

    // 왼쪽 오른쪽 돌리기
    static class Magent{
        int[] ns = new int[8];
        int moveDirection, pivot, left , right;

        Magent(){
        }

        public Magent(int[] ns) {
            this.ns = ns;
            this.pivot = 0;
        }

        public void move(){
            if(moveDirection == 1){
                moveClock();
            }else{
                moveReverseClock();
            }
        }

        public void moveClock(){
//            System.out.println("call moveClock  ");
            pivot = (pivot  - 1 + 8) % 8;
        }

        public void moveReverseClock(){
//            System.out.println("call reverseMoveClock  ");

            pivot = (pivot + 1) % 8;
        }

        public int getLeft(){
            return ns[(pivot -2 + 8) % 8];
        }

        public int getRight(){
            return ns[(pivot + 2) % 8];
        }

        public int get12(){
            return ns[pivot];
        }

        @Override
        public String toString() {
            return "Magent{" +
                    "ns=" + Arrays.toString(ns) +
                    ", moveDirection=" + moveDirection +
                    ", pivot=" + pivot +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
//10
//2
//0 0 1 0 0 1 0 0
//1 0 0 1 1 1 0 1
//0 0 1 0 1 1 0 0
//0 0 1 0 1 1 0 1
//1 1
//3 -1
