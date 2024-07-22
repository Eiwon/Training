package level3;

import java.util.Arrays;
import java.util.PriorityQueue;

/*라이언은 아래와 같은 특별한 규칙으로 트리 노드들을 구성한다.

트리를 구성하는 모든 노드의 x, y 좌표 값은 정수이다.
모든 노드는 서로 다른 x값을 가진다.
같은 레벨(level)에 있는 노드는 같은 y 좌표를 가진다.
자식 노드의 y 값은 항상 부모 노드보다 작다.
임의의 노드 V의 왼쪽 서브 트리(left subtree)에 있는 모든 노드의 x값은 V의 x값보다 작다.
임의의 노드 V의 오른쪽 서브 트리(right subtree)에 있는 모든 노드의 x값은 V의 x값보다 크다.
이진트리를 구성하는 노드들의 좌표가 담긴 배열 nodeinfo가 매개변수로 주어질 때,
노드들로 구성된 이진트리를 전위 순회, 후위 순회한 결과를 2차원 배열에 순서대로 담아 return 하도록 solution 함수를 완성하자.

제한사항
nodeinfo는 이진트리를 구성하는 각 노드의 좌표가 1번 노드부터 순서대로 들어있는 2차원 배열이다.
nodeinfo의 길이는 1 이상 10,000 이하이다.
nodeinfo[i] 는 i + 1번 노드의 좌표이며, [x축 좌표, y축 좌표] 순으로 들어있다.
모든 노드의 좌표 값은 0 이상 100,000 이하인 정수이다.
트리의 깊이가 1,000 이하인 경우만 입력으로 주어진다.
모든 노드의 좌표는 문제에 주어진 규칙을 따르며, 잘못된 노드 위치가 주어지는 경우는 없다.*/
public class BinaryTree {
/*[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]	[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]*/
	public static void main(String[] args) {
		solution(new int[][] {
			{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}
			});
	}
	public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        int len = nodeinfo.length;
        PriorityQueue<P> pq = new PriorityQueue<>((p1, p2) -> (p1.level - p2.level));
        for(int i = 0; i < len; i++) {
        	pq.add(new P(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        P root = new P(0, Integer.MAX_VALUE, 0);
        P[] pTree = new P[len+1];
        pTree[0] = root;
        
        while(pq.size() > 0) {
        	
        }
        // 
        
        return answer;
    }
}
class P{
	int value;
	int x, level;
	
	public P(int value, int x, int level) {
		this.value = value;
		this.x = x;
		this.level = level;
	}
}
