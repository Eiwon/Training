package level2;

import java.util.ArrayList;

public class FirstPath {
//"ULURRDLLU"	7
	public static void main(String[] args) {
		
		solution("ULURRDLLU");
		
	}
		private static final int LEFT = 0;
		private static final int DOWN = 1;
		private static final int UP = 2;
		private static final int RIGHT = 3;
		
	public static int solution(String dirs) {
		// 그래프
	    int answer = 0;
	    int[][] commands = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
	    char c = 0;
	     
	     

	    
	     for(int i = 0; i < dirs.length(); i++) {
	    	 c = dirs.charAt(i);
	    	 
	     }
	     
	     System.out.println(answer);
	     
	     
	     return answer;
	}
}

class Graph{
	// 모든 노드를 관리하는 리스트
	class Node{
		int x;
		int y;
		ArrayList<Node> adj = new ArrayList<>();
	}
}

