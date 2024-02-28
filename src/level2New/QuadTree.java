//당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
//만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
//그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.

package level2New;

public class QuadTree {

	public static void main(String[] args) {
		

	}
	
	public int[] solution(int[][] arr) {
        int[] answer = {};
        
        quadPress(arr, 0, 0, arr.length, arr[0].length);
        
        return answer;
    }
// 0 1 2 3   -> 0 1 / 2 3   <ex/2
	private int[] quadPress(int[][] arr, int sx, int sy, int ex, int ey) {
		int[] res = new int[2];
		int[] sub = new int[2];
		// 원소가 1개만 남으면 결과 리턴
		// 4개의 영역으로 나눠 quadPress 실행, 4개 영역의 결과가 모두 같으면 하나의 결과만 리턴
		
		if(arr.length == 1) {
			res[arr[sx][sy]] = 1;
			return res;
		} // 1칸 남으면 리턴
		
		sub = quadPress(arr, sx, sy, (ex-sx)/2, (ey-sy)/2);
		res[0] += sub[0];
		res[1] += sub[0];
		
		sub = quadPress(arr, (ex-sx)/2, sy, ex, (ey-sy)/2);
		res[0] += sub[0];
		res[1] += sub[0];
		
		sub = quadPress(arr, sx, (ey-sy)/2, (ex-sx)/2, ey);
		res[0] += sub[0];
		res[1] += sub[0];
		
		sub = quadPress(arr, (ex-sx)/2, (ey-sy)/2, ex, ey);
		res[0] += sub[0];
		res[1] += sub[0];
		
		if(res[0] == 4 && res[1] == 0)
			res[0] = 1;
		else if(res[0] == 0 && res[1] == 4)
			res[1] = 1;
		
		return res;
	}
}
