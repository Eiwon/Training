//비밀지도
//
//지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
//전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
//"지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
//암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
//
//입력 형식
//입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
//
//1 ≦ n ≦ 16
//arr1, arr2는 길이 n인 정수 배열로 주어진다.
//정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
//출력 형식
//원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
package solution;

public class SecretMap {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
        boolean[][] map = new boolean[n][n];
        int row1 = 0, row2 = 0;
        // 맵 각 열 y에대해 n-1부터 0까지, arr[y]를 2로 나눈 나머지가 1이면 true, 아니면 false
        
        for(int y = 0; y < n; y++) {
        	row1 = arr1[y];
        	row2 = arr2[y];
        	for(int x = n-1; x >=0; x--) {
        		if(row1 %2 == 1 || row2 %2 == 1) {
        			map[y][x] = true;
        		}
        	row1 /= 2;
        	row2 /= 2;
        	}
        }
        
        for(int y = 0; y < n; y++) {
            answer[y] = "";
        	for(int x = 0; x < n; x++) {
        		if(map[y][x]) {
        			answer[y] += '#';
        		}else {
        			answer[y] += ' ';
        		}
        	}
        }
        
        return answer;
    }
}
