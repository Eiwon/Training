package level3;
/*주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.*/
import java.util.*;
public class TravelRoute {
//[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	
	//["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
	static HashMap<String, Integer> portToIdx;
	static List<List<Edge>> portMap;
	static Stack<String> route;
	public static void main(String[] args) {
		solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
			{"ATL", "ICN"}, {"ATL","SFO"}});

	}
	public static String[] solution(String[][] tickets) {
        String[] answer = {};
        // 시작점과 끝점, 사용 여부가 담긴 edge 생성
        // edge를 시작점별로 분류
        // 각 시작점의 edge를 끝점 이름 기준으로 정렬
        // ICN을 시작으로 DFS, 지나간 지점은 stack에 저장, 
        int edgeNum = tickets.length;
        portToIdx = new HashMap<>();
        portMap = new ArrayList<>();
        route = new Stack<>();
        int portNum = 0;
        String[] ticket;
        for(int i=0; i < tickets.length; i++) {
        	ticket = tickets[i];
        	for(int j=0; j<ticket.length; j++) {
        		if(!portToIdx.containsKey(ticket[j])) {
        			portToIdx.put(ticket[j], portNum++);
        			portMap.add(new ArrayList<>());
        		}
        	}
        	portMap.get(portToIdx.get(ticket[0])).add(new Edge(ticket[1]));
        }
        for(List<Edge> port : portMap) {
        	Collections.sort(port, (e1, e2) -> (e1.next.compareTo(e2.next)));
        }
        dfs("ICN", edgeNum);
        answer = route.toArray(answer);
        return answer;
    }
	
	public static int dfs(String port, int edgeNum) {
		int targetIdx = portToIdx.get(port);
		// 스택에 해당 port 추가
		route.add(port);
		if(route.size() == edgeNum +1)
			return 1;
		//System.out.println(route.toString());
		if(portMap.get(targetIdx).size() > 0) {
			for(Edge edge : portMap.get(targetIdx)) {
				if(edge.isUsed == false) {
					edge.isUsed = true;
					// 사용됨으로 체크 후 dfs
					if(dfs(edge.next, edgeNum) == 1)
						return 1;
					edge.isUsed = false;
				}
			}
		}
		route.pop();
		return 0;
	}
}
class Edge{
	boolean isUsed;
	String next;
	
	public Edge(String next) {
		this.next = next;
	}
}

