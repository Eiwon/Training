/*스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.*/
package level3;
//["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
import java.util.*;

public class BestAlbum {

	public static void main(String[] args) {
		solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, 
				new int[] {500, 600, 150, 800, 2500});
	}
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, Integer> mList = new HashMap<>();
        ArrayList<Album> aList = new ArrayList<>();
        int musicNum = 0;
        int genreNum = 0;
        for(int i = 0; i < genres.length; i++) {
        	if(!mList.containsKey(genres[i])) {
        		mList.put(genres[i], genreNum++);
        		aList.add(new Album());
        		musicNum++;
        	}
        	if(aList.get(mList.get(genres[i])).addMusic(i, plays[i]) == 2) {
        		musicNum++;
        	}
        }
        aList.sort((a, b) -> (b.total - a.total));
        answer = new int[musicNum];
        int idx = 0;
        for(Album al : aList) {
        	answer[idx++] = al.id1;
        	if(al.num > 1)
        		answer[idx++] = al.id2;
        }
        return answer;
    }
}
class Album{
	int id1, id2;
	int view1, view2;
	int total;
	int num = 0;
	
	public int addMusic(int id, int view) {
		if(view1 < view) {
			id2 = id1;
			view2 = view1;
			id1 = id;
			view1 = view;
		}else if(view2 < view){
			id2 = id;
			view2 = view;
		}
		total += view;
		num++;
		return num;
	}
}
