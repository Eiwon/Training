//2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
//
//제한 조건
//행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
//행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
//곱할 수 있는 배열만 주어집니다.
public class ArrProduct {
	public static void main(String[] args) {
			solution(new int[][] {{1,4}, {3,2}, {4,1}}, new int[][] {{3, 3}, {3, 3}});
	}
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int sum = 0;
        for(int row = 0; row < arr1.length; row++) {
        	for(int col = 0 ; col < arr2[0].length; col++) {
        		sum = 0;
        		for(int i = 0; i < arr1[0].length; i++) {
        			sum += arr1[row][i] * arr2[i][col];
        		}
        		answer[row][col] = sum;
        	}
        }
//        for(int i=0; i<answer.length; i++) {
//        	for(int j=0; j<answer[0].length; j++) {
//        		System.out.print(answer[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        
        
        return answer;
    }

}
