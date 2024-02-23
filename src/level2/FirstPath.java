package level2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class FirstPath {
//"ULURRDLLU"	7
	public static void main(String[] args) {
		
		solution("ULURRDLLU");
		
	}
		private static final int LEFT = 0;
		private static final int DOWN = 1;
		private static final int UP = 2;
		private static final int RIGHT = 3;
		//0,0	1,0		1,-1	2,-1	2,0		2,1		1,1		1,0		1,-1	2,-1
	public static int solution(String dirs) {
		// 그래프
	    int answer = 0;
	    int[][] commands = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
	    char c = 0;
	    Node start = new Node(0, 0);
	    int x = 0, y = 0, moveX = 0, moveY = 0;
	    for(int i = 0; i < dirs.length(); i++) {
	    	c = dirs.charAt(i);
	    	switch (c) {
			case 'L': 
				moveX = commands[LEFT][0];
				moveY = commands[LEFT][1];
				break;
			case 'D':
				moveX = commands[DOWN][0];
				moveY = commands[DOWN][1];
				break;
			case 'U':
				moveX = commands[UP][0];
				moveY = commands[UP][1];
				break;
			case 'R':
				moveX = commands[RIGHT][0];
				moveY = commands[RIGHT][1];
				break;
			default:
				break;
			}
	    	
	    	x = Math.max(Math.min(x + moveX, 5), -5);
	    	y = Math.max(Math.min(y + moveY, 5), -5);
	    	Node next = new Node(x, y);
	    	if(start.addNode(next) == 1) {
	    		answer++;
	    	}
	    	start = next;
	    }
	     
	    System.out.println(answer);
	    
	    return answer;
	}
}

class Node{
	public int x, y;
	public ArrayList<Node> adj;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		adj = new ArrayList<>();
	}
	
	public int addNode(Node node) {
		if(!adj.contains(node)) {
			System.out.println("target : " + node.x +" " + node.y);
			System.out.println("current : " + this.x +" " + this.y);
			adj.add(node);
			node.adj.add(this);
			System.out.println("target ls : ");
			for(int i=0; i<node.adj.size(); i++) {
				System.out.print(node.adj.get(i).x + " " + node.adj.get(i).y + " ");
			}
			System.out.println();
			System.out.println("current ls : ");
			for(int i=0; i<adj.size(); i++) {
				System.out.print(adj.get(i).x + " " + adj.get(i).y + " ");
			}
			System.out.println();
			
			return 1;
		}
		return 0;
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Node) {
			if(((Node)obj).x == this.x && ((Node)obj).y == this.y) 
				return true;
		}
		
		return false;
	}
}

