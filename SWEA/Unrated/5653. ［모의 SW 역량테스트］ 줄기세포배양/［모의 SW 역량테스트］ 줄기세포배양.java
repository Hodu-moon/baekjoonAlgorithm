import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Solution {

	static int H, W, K;
	static final int ADD_NUM = 400;
	static int[][] map ;
	static boolean[][] visited;
	
	static Queue<NonActiveCell> nonActiveCellQueue;
	static Queue<ActiveCell> activeCellQueue;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			nonActiveCellQueue = new ArrayDeque<>();
			activeCellQueue = new ArrayDeque<>();
			visited = new boolean[3000][3000];

			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 0) {
						nonActiveCellQueue.add(new NonActiveCell(i  + ADD_NUM, j + ADD_NUM, map[i][j]));
						visited[i + ADD_NUM][j + ADD_NUM] = true;

					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(solve()).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int solve() {
		int cnt = 0;
		
		// 1. 비활성화 큐에서 
		int time = 0;
		
		while(time++ < K ) {
//			System.out.println("time : "  + time);
			int nonActiveQueueSize = nonActiveCellQueue.size();
			
			List<ActiveCell> list = new ArrayList<>();
			
			for(int i = 0; i < nonActiveQueueSize; i++) {
				NonActiveCell cell = nonActiveCellQueue.poll();
				if(++cell.waitTime == cell.originTime) {
					list.add(new ActiveCell(cell.x, cell.y, cell.originTime) );
				}else {
					nonActiveCellQueue.add(cell);
				}				
			}
			
			
			
			Map<Position, Queue<ActiveCell>> samePosition = new HashMap<>();
			List<Position> samePositionKey = new ArrayList<>();
			
			// 2. 활성화 큐 
			int activeCellQueueSize = activeCellQueue.size();
			
			for(int i = 0; i < activeCellQueueSize; i++) {
				
				
				ActiveCell cell = activeCellQueue.poll();
				cell.waitTime++;
				
				if(cell.waitTime == 1) {

					for(int d = 0; d < 4; d++) {
						int nx = cell.x + dx[d];
						int ny = cell.y + dy[d];
						
					
						if( visited[nx][ny])
							continue;			
						
						Queue<ActiveCell> queue = samePosition.get(new Position(nx, ny ));
						samePositionKey.add(new Position(nx , ny ));
						
						// samePosition 에 없을 경우 
						if(Objects.isNull(queue)) {
							Queue<ActiveCell> newQueue = new PriorityQueue<>();
							newQueue.add(new ActiveCell(nx , ny , cell.originTime));
							
							samePosition.put(new Position(nx , ny ), newQueue);
						}else {
							queue.add(new ActiveCell(nx , ny , cell.originTime));
						
						}

					}
					
					

				}
				
				if(cell.waitTime != cell.originTime) {
					activeCellQueue.add(cell);
				}
				
			}
			
			for(Position key : samePositionKey) {
				Queue<ActiveCell> pq = samePosition.get(key);
				
				ActiveCell activeCell = pq.poll();
				
				if(!visited[activeCell.x][activeCell.y]) {
					visited[activeCell.x][activeCell.y] = true;
					nonActiveCellQueue.add(new NonActiveCell(activeCell.x, activeCell.y, activeCell.originTime));
				}
				
				
			}
			
			for(ActiveCell cell : list) {
				activeCellQueue.offer(cell);
			}
			
//			for(NonActiveCell cell : nonActiveCellQueue) {
//				System.out.println(cell);
//			}
//			
//			for(ActiveCell cell : activeCellQueue) {
//				System.out.println(cell);
//			}
			
			
			
			
		}
		
		cnt = nonActiveCellQueue.size() + activeCellQueue.size();
		
//		System.out.println(nonActiveCellQueue.size() + " " +  activeCellQueue.size());
		
		return cnt;
		
	}
	
	
	
	static boolean isIn(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
	
	static class Position{
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			Position p = (Position)o;
			return this.x == p.x && this.y == p.y;
		}
		
		@Override
		public int hashCode() {
			return x * 31 + y ;
		}
		
	}
	
	
	
	
	static class NonActiveCell{
		int x, y, waitTime, originTime;

		public NonActiveCell(int x, int y, int originTime) {
			this.x = x;
			this.y = y;
			this.originTime = originTime;
			this.waitTime = 0;
		}

		@Override
		public String toString() {
			return "NonActiveCell [x=" + (x - ADD_NUM) + ", y=" + (y - ADD_NUM) + ", waitTime=" + waitTime + ", originTime=" + originTime + "]";
		} 
		
	}
	static class ActiveCell implements Comparable<ActiveCell>{
		int x, y, waitTime , originTime;
		
		public ActiveCell(int x, int y, int originTime) {
			this.x = x;
			this.y = y;
			this.originTime = originTime;
			this.waitTime = 0;
			
		}

		@Override
		public int compareTo(ActiveCell o) {
			// TODO Auto-generated method stub
			return (this.originTime - o.originTime ) * -1;
		}

		@Override
		public String toString() {
			return "ActiveCell [x=" + (x - ADD_NUM) + ", y=" + (y - ADD_NUM) + ", waitTime=" + waitTime + ", originTime=" + originTime + "]";
		} 
		
		
		
	}

}
