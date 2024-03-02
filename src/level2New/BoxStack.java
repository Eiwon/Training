package level2New;

import java.util.*;

public class BoxStack {
//	[4, 3, 1, 2, 5]	2    34215
//	[5, 4, 3, 2, 1]	5
	public static void main(String[] args) {
		solution(new int[] {4, 3, 1, 2, 5});
	}
	public static int solution(int[] order) {
        int answer = 1;
        int[] nOrder = new int[order.length];
        Stack<Integer> subConv = new Stack<>();
        Queue<Integer> mainConv = new LinkedList<>();
        int nextBox = 0;
        
        for(int i = 0; i < order.length; i++) {
        	nOrder[order[i]-1] = i;
        }
        
        for(int i : nOrder) {
        	System.out.print(i + " ");
        }
        System.out.println();
       	boolean start = false;
        for(int i : nOrder) {
        	if(i == 0) {
        		start = true;
        		nextBox++;
        	}else if(start == false) {
        		subConv.push(i);
        	}else mainConv.add(i);
        }
        System.out.println(subConv.toString());
        System.out.println(mainConv.toString());
        while(true) {
        	if(subConv.size() == 0 || mainConv.size() == 0) {
        		return order.length;
        	}
        	if(nextBox == subConv.peek()) {
        		answer++;
        		nextBox = subConv.pop() +1;
        	}else if(nextBox == mainConv.peek()) {
        		answer++;
        		nextBox = mainConv.poll() +1;
        	}else break;
        }
//        System.out.println(answer);
        
        return answer;
    }
}
