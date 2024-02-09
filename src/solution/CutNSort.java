//array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
//
//array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
//1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
//2에서 나온 배열의 3번째 숫자는 5입니다.
//배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//array의 길이는 1 이상 100 이하입니다.
//array의 각 원소는 1 이상 100 이하입니다.
//commands의 길이는 1 이상 50 이하입니다.
//commands의 각 원소는 길이가 3입니다.

package solution;

import java.util.*;

//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
public class CutNSort {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start = 0, end = 0, num = 0;
        List<Integer> target;
        
        for(int command = 0; command < commands.length; command++) {
        	start = commands[command][0];
        	end = commands[command][1];
        	num = commands[command][2];
        	
        	target = new ArrayList<>(end -start +1);
        	for(int i = start-1; i < end; i++) {
        		target.add(array[i]);
        	}
        	target.sort(null);
        	answer[command] = target.get(num -1);
        }
        for(int a : answer)
        	System.out.print(a + " ");
        
        return answer;
    }
}
