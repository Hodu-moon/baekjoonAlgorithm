
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N, M, K, A, B, receptionDeskCount, repairDeskCount, finishCount;
    static Queue<Customer> receptionWaitingQueue;
    static Customer[] receptionDesk;
    static PriorityQueue<Customer> repairWaitingQueue;
    static Customer[] repairDesk;
    static List<Customer> customerList;
    static int[] receptionTime, repairTime;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 1based
            receptionDeskCount = repairDeskCount = finishCount = 0;
            receptionWaitingQueue = new ArrayDeque<>();
            repairWaitingQueue = new PriorityQueue<>();
            receptionDesk = new Customer[N + 1];
            repairDesk = new Customer[M + 1];
            receptionTime = new int[N + 1];
            repairTime = new int[M + 1];
            customerList = new ArrayList<>();
            // N만큼 reception time



            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= N; i++ ) {
                receptionTime[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= M; i++ ) {
                repairTime[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= K; i++) {
                Customer customer = new Customer(i, Integer.parseInt(st.nextToken()));
                receptionWaitingQueue.add(customer);
                customerList.add(customer);
            }


            solve();

            int result = 0;

//            System.out.println(" A : " + A + " B : " + B);
//            System.out.println("customer List ");

            for(Customer customer : customerList) {
//                System.out.println(customer);

                if(customer.usedReceptionNo == A && customer.usedRepairNo == B) {
                    result += customer.no;
                }
            }

            sb.append("#").append(t).append(" ").append(result == 0 ? -1 : result).append("\n");
        }

        System.out.println(sb);
    }

    static void solve() {

        int time = 0;

        while(true) {

            // 1. waitingQueue 에서 Reception Desk 로 데려오기

            // 2. Reception Desk  에서  시간 다된 놈 빼기

            for(int i = 1; i <= N; i++) {
                if(receptionDesk[i] != null) {

                    if(receptionDesk[i].receptionOutTime == time) {
                        repairWaitingQueue.add(receptionDesk[i]);
                        receptionDeskCount--;
                        receptionDesk[i] = null;

                    }
                }
            }


//			System.out.println("reception Desk Count : " + receptionDeskCount);
            for(int i = receptionDeskCount; i < N; i++) {

                if(!receptionWaitingQueue.isEmpty()
                        && receptionWaitingQueue.peek().inTime <= time
                ) {
                    // 이 친구를 reception Desk 에 넣어야함
                    Customer customer = receptionWaitingQueue.poll();

                    boolean flag = false;
                    for(int no = 1; no <= N; no++) {

                        if(flag)
                            break;


                        if(receptionDesk[no] == null) {
                            customer.usedReceptionNo = no;
                            customer.receptionOutTime = time + receptionTime[no];
                            receptionDeskCount++;
                            receptionDesk[no] = customer;
                            flag = true;
                        }
                    }

                }

            }



            // 4. repair Desk 나가기

            for(int i = 1; i <= M; i++) {
                if(repairDesk[i] != null) {

                    if(repairDesk[i].repairOutTime == time) {
                        repairDesk[i] = null;
                        repairDeskCount--;
                        finishCount++;
                    }
                }
            }



            // 3. RepairWatingQueue 에 넣기

            for(int i = repairDeskCount; i < M; i++) {

                if(!repairWaitingQueue.isEmpty() ) {
                    Customer customer = repairWaitingQueue.poll();
                    repairDeskCount++;


                    boolean flag = false;
                    for(int no = 1; no <= N; no++) {

                        if(flag)
                            break;

                        if(repairDesk[no] == null) {
//							System.out.println("here!!");
                            customer.usedRepairNo = no;
                            customer.repairOutTime = time + repairTime[no];
                            repairDesk[no] = customer;
                            flag = true;
                        }


                    }
                }

            }



//            System.out.println("time : " + time);
//
//            System.out.println(" reception Desk ");
//            for(int i = 1; i <= N; i++) {
//                System.out.println(receptionDesk[i]);
//            }
//
//            System.out.println(" repair Desk ");
//            for(int i = 1; i <= M; i++) {
//                System.out.println(repairDesk[i]);
//            }
//
//            System.out.println("finishCount : " + finishCount);
            if(finishCount == K ) {
                return ;
            }

//			System.out.println();
            time++;
        }






    }

    static class Customer implements Comparable<Customer>{
        int no;
        int inTime;
        int receptionOutTime;
        int repairOutTime;
        int usedReceptionNo;
        int usedRepairNo;



        public Customer(int no, int inTime) {
            super();
            this.no = no;
            this.inTime = inTime;
        }



        @Override
        public int compareTo(Customer o) {
            // TODO Auto-generated method stub
            if(this.receptionOutTime == o.receptionOutTime) {
                return Integer.compare(usedReceptionNo, o.usedReceptionNo);
            }
            return Integer.compare(receptionOutTime, o.receptionOutTime);
        }



        @Override
        public String toString() {
            return "Customer [no=" + no + ", inTime=" + inTime + ", receptionOutTime=" + receptionOutTime
                    + ", repairOutTime=" + repairOutTime + ", usedReceptionNo=" + usedReceptionNo + ", usedRepairNo="
                    + usedRepairNo + "]";
        }



    }

}
//1
//1 1 2 1 1
//5
//7
//7 10


//1
//2 2 6 1 2
//3 2
//4 2
//0 0 1 2 3 4