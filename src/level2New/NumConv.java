//자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
//
//x에 n을 더합니다
//x에 2를 곱합니다.
//x에 3을 곱합니다.
//자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
//
//제한사항
//1 ≤ x ≤ y ≤ 1,000,000
//1 ≤ n < y

package level2New;

public class NumConv {

	private static int minDepth = Integer.MAX_VALUE;
	public static void main(String[] args) {
		solution(2, 5, 4);

	}

	public static int solution(int x, int y, int n) {
        int answer = 0;
        if(x == y) return 0;
        answer = conversion(x, y, n, 0);
        if(answer == 0)
        	return -1;
        
        return answer;
    }
	
	public static int conversion(int x, int y, int n, int depth) {
		// 종료 조건 : x가 y보다 클때, x==y일때
		int result = 0;
		int[] res = new int[3];
		if(depth > minDepth)
			return 0;
		if(x > y)
			return 0;
		else if(x == y) {
			minDepth = Math.min(depth, minDepth);
			return depth;
		}
			
		else {
			// 3가지 연산 후 1이상이 반환된 값이 있다면 그 값을 return
			res[0] = conversion(x * 3, y, n, depth+1);
			res[2] = conversion(x * 2, y, n, depth+1);
			res[1] = conversion(x + n, y, n, depth+1);
		}
		for(int r : res) {
			if(r > 0) {
				if(result == 0)
					result = r;
				else result = Math.min(result, r);
			}
		}
		return result;
	}
	
}
