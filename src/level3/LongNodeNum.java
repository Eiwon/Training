package level3;

import java.util.*;

/*노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

제한사항
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
입출력 예
n	vertex	return
6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3*/
public class LongNodeNum {

	public static void main(String[] args) {
		solution(6, new int[][] {
			{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
			});
	}
//6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 1번에 인접한 모든 노드에 최단거리 1 부여, 우선순위 큐에 넣고 최단경로 순 정렬(1번 제외 전부 최대값)
        // 최단경로가 짧은 순으로 선택, 인접한 미방문 노드에 min(대상의 현재 최단거리, 자신 최단거리+1) 부여
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (n1.distance - n2.distance));
        Node[] graph = new Node[n+1];
        int max = 0;
        int pick1, pick2;
        for(int i = 0; i < edge.length; i++) {
        	pick1 = edge[i][0];
        	pick2 = edge[i][1];
        	if(graph[pick1] == null) {
        		graph[pick1] = new Node(Integer.MAX_VALUE);
        	}
        	if(graph[pick2] == null) {
        		graph[pick2] = new Node(Integer.MAX_VALUE);
        	}
        	graph[pick1].addNode(graph[pick2]);
        	graph[pick2].addNode(graph[pick1]);
        }
        graph[1].visited = true;
        graph[1].distance = 0;
        pq.add(graph[1]);
        Node pick = null;
        while(pq.size() > 0) {
        	pick = pq.poll();
        	for(Node next : pick.adj) {
        		if(next.visited == false) {
        			next.visited = true;
        			next.distance = pick.distance +1;
        			max = Math.max(max, next.distance);
        			pq.add(next);
        		}
        	}
        }
        for(int i=1; i<n+1; i++) {
        	System.out.println(graph[i].distance);
        }
        
        return answer;
    }
}
class Node{
	boolean visited;
	int distance;
	List<Node> adj;
	
	public Node(int distance) {
		this.distance = distance;
		adj = new ArrayList<>();
	}
	
	public void addNode(Node node) {
		adj.add(node);
		node.adj.add(this);
	}
}
