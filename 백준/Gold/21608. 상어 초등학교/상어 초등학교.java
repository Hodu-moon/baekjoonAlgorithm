
import java.util.*;

public class Main {
    static int[][] students;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Map<Integer, Set<Integer>> studentMap;
    static List<Integer> studentOrder;
    static int N;

    static int result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        students = new int[N][N];
        studentMap = new HashMap<>();
        studentOrder = new ArrayList<>();

        for (int i = 0; i < N * N; i++) {
            int studentNo = sc.nextInt();

            Set<Integer> likes = new HashSet<>();

            // 좋아하는 학생 4명
            for (int j = 0; j < 4; j++) {
                likes.add(sc.nextInt());
            }
            studentMap.put(studentNo, likes);
            studentOrder.add(studentNo);
        }

        // 규칙 들어감

        // 들어가는 학생 순서가 중요 -> list로
        for(int studentNo : studentOrder){
            batch(studentNo);
//            printStudents();
        }
        calc();

        System.out.println(result);


    }

    static void calc(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                int likes = 0;

                for(int d = 0; d < dx.length ; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(!isIn(nx, ny))
                        continue;

                    if(studentMap.get(students[i][j]).contains(students[nx][ny])){
                        likes++;
                    }
                }

                switch (likes) {
                    case 1:
                        result += 1;
                        break;
                    case 2:
                        result += 10;
                        break;
                    case 3:
                        result += 100;
                        break;
                    case 4:
                        result += 1000;
                        break;

                }


            }
        }
    }
    static void printStudents(){
        System.out.println();
        for(int[] xx : students){
            for(int x : xx){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static  void batch(int studentNo){
//        System.out.println(studentNo);
        // students -> 0으로 초기화된 N * N 배열이 있을것이고
        int best_r = -1;
        int best_c = -1;
        int max_likes_count = -1; // -> 친한 친구들
        int max_near_empty = -1;

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                //
                if(students[r][c] != 0)
                    continue;

                int likesCount = 0;
                int emptyCount = 0;
                // 규칙

                // 좋아하는 학생 , 비어있는 곳 체크
                for(int d = 0; d < 4; d ++){
                    int nr = r + dx[d], nc = c + dy[d];
                    if(!isIn(nr, nc))
                        continue;
                    // 변수명을 잘 좀 적자
                    // studentMap -> <학생번호, 왼쪽이 좋아하는 학생들  <학생번호> >
                    if(studentMap.get(studentNo).contains(students[nr][nc])){
                        likesCount++;
                    }
                    // emptyCount
                    if(students[nr][nc] == 0)
                        emptyCount++;
                }

                //1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
                //2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
                //3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.

                if( /* 1번 조건*/( max_likes_count < likesCount ) ||
                    /* 2번 조건  1번 조건이 안걸렸다면 */
                        (max_likes_count == likesCount && max_near_empty < emptyCount) ||
                    /* 3번 조건 */
                        ( likesCount == max_likes_count && max_near_empty == emptyCount
                                && ( r < best_r || ( r == best_r && c < best_c) ))
                ) {

                    best_r = r;
                    best_c = c;
                    max_likes_count = likesCount;
                    max_near_empty = emptyCount;
                }
            }
        }

        // 조건을 다 돌았다면 best_r, best_c 가 나올것이고
        students[best_r][best_c] = studentNo;
    }

    static  boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }



}

// input
// 3
//4 2 5 1 7
//3 1 9 4 5
//9 8 1 2 3
//8 1 9 3 4
//7 2 3 4 8
//1 9 2 5 7
//6 5 2 3 4
//5 1 9 2 8
//2 9 3 1 4

