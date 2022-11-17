import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		int back = -1;
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			switch(type) {
			case "push":
				back = Integer.parseInt(st.nextToken());
				queue.offer(back);	
				break;
			case "pop":
				if(queue.isEmpty()) {
					sb.append("-1").append("\n");
					break;
				}
				sb.append(queue.poll()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.isEmpty()? 1: 0).append("\n");
				break;
			case "front":
				sb.append(queue.isEmpty()? -1: queue.peek()).append("\n");
				break;
			case "back":
				sb.append(queue.isEmpty()? -1: back).append("\n");
				break;
				
			}
		}
		System.out.print(sb);
	}
}