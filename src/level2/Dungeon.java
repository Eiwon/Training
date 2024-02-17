//k는 1 이상 5,000 이하인 자연수입니다.
//dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
//dungeons의 가로(열) 길이는 2 입니다.
//dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
//"최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
//"최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
//서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
package level2;

public class Dungeon {
//80	[[80,20],[50,40],[30,10]]	3
	// 이미 돈 던전은 used에 표시
	// 각 던전 중 돌 수 있는 던전에 대해(피로도 확인, used 확인)
	// 더 이상 돌 수 있는 던전이 없으면 (피로도가 <=0 또는  
	public static void main(String[] args) {
		solution(80, new int[][] {{80,20}, {50,40}, {30,10}});

	}
	
	public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] used = new boolean[dungeons.length];
        
        answer = search(k, dungeons, used) -1;
        
        System.out.println("answer : " + answer);
        return answer;
    }

	private static int search(int tired, int[][] dungeons, boolean[] used) {
		//던전 1회 입장한 거라 생각
		int depth = 1, remains;
		for(int i=0; i<dungeons.length; i++) {
			remains = tired - dungeons[i][0] >= 0 ? tired -dungeons[i][1] : -1;
			if(used[i] == false && remains != -1) {
				// 다음 던전 진입
				used[i] = true;
				depth = Math.max(depth, search(remains, dungeons, used) +1);
				used[i] = false;
			}
		}
		return depth;
	}
	
}
