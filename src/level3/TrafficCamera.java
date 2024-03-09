package level3;
/*고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.

고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요
차량의 대수는 1대 이상 10,000대 이하입니다.
routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점, routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다
*/
import java.util.*;
public class TrafficCamera {
//[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]	2
	public static void main(String[] args) {
		solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});

	}
	public static int solution(int[][] routes) {
        int answer = 0;
        List<Route> list = new LinkedList<>();
        for(int[] r : routes) {
        	list.add(new Route(r[0], r[1]));
        }
        
        list.sort(new Comparator<Route>() {

			@Override
			public int compare(Route o1, Route o2) {
				return o1.out - o2.out;
			}});
        Queue<Route> q = (Queue<Route>)list;
        
        while(q.size() > 0) {
        	int camera = q.peek().out;
        	int size = q.size();
        	answer++;
        	for(int i = 0; i < size; i++) {
        		Route pick = q.poll();
        		if(pick.isCaught(camera) == false) {
        			q.add(pick);
        		}
        	}
        }
        
        return answer;
    }
}

class Route{
	int in;
	int out;
	
	public Route(int in, int out) {
		this.in = in;
		this.out = out;
	}
	
	boolean isCaught(int camera) {
		if(in <= camera && camera <= out)
			return true;
		else return false;
	}
}
