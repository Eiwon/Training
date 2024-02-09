//예를 들어, 3가지의 음식이 준비되어 있으며, 칼로리가 적은 순서대로 1번 음식을 3개, 2번 음식을 4개, 3번 음식을 6개 준비했으며, 물을 편의상 0번 음식이라고 칭한다면, 두 선수는 1번 음식 1개, 2번 음식 2개, 3번 음식 3개씩을 먹게 되므로 음식의 배치는 "1223330333221"이 됩니다. 따라서 1번 음식 1개는 대회에 사용하지 못합니다.
//
//수웅이가 준비한 음식의 양을 칼로리가 적은 순서대로 나타내는 정수 배열 food가 주어졌을 때, 대회를 위한 음식의 배치를 나타내는 문자열을 return 하는 solution 함수를 완성해주세요.
//
//제한사항
//2 ≤ food의 길이 ≤ 9
//1 ≤ food의 각 원소 ≤ 1,000
//food에는 칼로리가 적은 순서대로 음식의 양이 담겨 있습니다.
//food[i]는 i번 음식의 수입니다.
//food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다.
//정답의 길이가 3 이상인 경우만 입력으로 주어집니다.

package solution;

public class FoodFight {
	public String solution(int[] food) {
        String answer = "";
        //[1, 3, 4, 6]	"1223330333221"
        // 1~마지막까지 읽으며, 
        // 값 /2 만큼 값을 감소시키고, 그 수만큼 answer에 문자 추가
        // 반대 순서로 다시 반복
        
        for(int i=1; i<food.length; i++) {
        	if(food[i] %2 == 1)
        		food[i]--;
        		food[i] = food[i] /2;
        	for(int j=0; j<food[i]; j++) {
        		answer += Integer.toString(i);
        	}
        }
        answer += "0";
        
        for(int i=food.length-1; i>0; i--) {
        	for(int j=0; j<food[i]; j++) {
        		answer += Integer.toString(i);
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
