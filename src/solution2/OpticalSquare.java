//가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
//
//모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//sizes의 길이는 1 이상 10,000 이하입니다.
//sizes의 원소는 [w, h] 형식입니다.
//w는 명함의 가로 길이를 나타냅니다.
//h는 명함의 세로 길이를 나타냅니다.
//w와 h는 1 이상 1,000 이하인 자연수입니다.

package solution2;

public class OpticalSquare {
	public int solution(int[][] sizes) {
        int answer = 0;
        
        int upperSide = 0;
        int lowerSide = 0;
        int upper = 0, lower = 0;
        
        for(int[] size : sizes) {
        	upper = Math.max(size[0], size[1]);
        	lower = Math.min(size[0], size[1]);
        	
        	upperSide = Math.max(upper, upperSide);
        	lowerSide = Math.max(lower, lowerSide);
        }
        answer = upperSide * lowerSide;
        
        return answer;
    }
}
