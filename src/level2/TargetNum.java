package level2;

public class TargetNum {
// +++-- 
	public static void main(String[] args) {
		solution(new int[] {4, 1, 2, 1}, 4);
	}
//[1, 1, 1, 1, 1]	3	5
	//[4, 1, 2, 1]	4
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        System.out.println(answer);
        
        return answer;
    }
	// return : i == number.length일 때, sum과 target이 일치 여부
	// 재귀로 넘겨줄 매개변수는 왠만해선 변경 xx
	private static int dfs(int[] numbers, int target, int i, int sum) {
		int result = 0;
		if(i == numbers.length) {
			if(target == sum) {
				System.out.println(sum);
				result = 1;
			}
			System.out.println();
		}else {
			System.out.print("+" + numbers[i] + " ");
			result += dfs(numbers, target, i+1, sum +numbers[i]);
			System.out.print("-" + numbers[i] + " ");
			result += dfs(numbers, target, i+1, sum -numbers[i]);
		}
		return result;
	}
	
	
}
