package level2New;

import java.util.*;

public class Elevator {
//storey	result
//	16	6
//	2554	16
	public static void main(String[] args) {
		solution(2554);

	}
	public static int solution(int storey) {
        int answer = 0;
        int remains = 0;
        
        do {
        	remains = storey %10;
        	storey /= 10;
        	if(remains > 5 || (remains == 5 && storey % 10 >= 5)) {
        		answer += 10 - remains;
        		storey++;
        	}else if(remains < 5 || (remains == 5 && storey % 10 < 5)) {
        		answer += remains;
        	}
        }while(storey > 0);
        
        System.out.println(answer);
        
        return answer;
    }
}
