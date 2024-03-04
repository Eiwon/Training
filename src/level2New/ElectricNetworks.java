/*n은 2 이상 100 이하인 자연수입니다.
wires는 길이가 n-1인 정수형 2차원 배열입니다.
wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
1 ≤ v1 < v2 ≤ n 입니다.
전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
 * */


package level2New;

import java.util.*;

public class ElectricNetworks {
/*9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
4	[[1,2],[2,3],[3,4]]	0
7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1
 * */
	public static void main(String[] args) {
		solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});

	}
	public static int solution(int n, int[][] wires) {
        int answer = n;
        Node[] nodeList = new Node[n+1];
        
        for(int i = 0; i < wires.length; i++) {
        	Node node = null;
        	if(nodeList[wires[i][0]] == null) {
        		nodeList[wires[i][0]] = new Node(wires[i][0]);
        	}
        	
        	if(nodeList[wires[i][1]] == null) {
        		nodeList[wires[i][1]] = new Node(wires[i][1]);
        	}
        	nodeList[wires[i][0]].addNode(nodeList[wires[i][1]]);
        }
        int side = 0;
        //for(int i = 1; i < n+1; i++) {
        	
        	side = nodeList[3].getLowerNum();
        	System.out.println(side);
        //}
        
        //System.out.println(answer);
        
        return answer;
    }
	
}

class Node{
	int nodeNum;
	ArrayList<Node> adj = null;
	
	public Node(int nodeNum){
		this.nodeNum = nodeNum;
		adj = new ArrayList<>();
	}

	public void addNode(Node node) {
		adj.add(node);
		node.adj.add(this);
	}
	
	public int getLowerNum() {
		int res = 0;
		
		if(adj.size() == 1) {
			res = 1;
		}else {
			for(int i = 0; i < adj.size(); i++) {
				if(adj.get(i).nodeNum != this.nodeNum)
					res += adj.get(i).getLowerNum();
			}
		}
		
		return res;
	}
}

