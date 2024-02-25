//입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.
//
//입력 형식
//입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
//2 ≦ n, m ≦ 30
//board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.
package level2New;

//TTTANT  //
//RRFACC  //   A
//RRRFCC  //T TANT
//TRRRAA  //TTFFAA
//TTMMMF  //TTMMMF
//TMMTTJ  //TMMTTJ
import java.util.*;

public class Friends4Block {

	public static void main(String[] args) {
		solution(6,6, new String[] {
				"TTTANT",
				"RRFACC",
				"RRRFCC",
				"TRRRAA",
				"TTMMMF",
				"TMMTTJ"
		});
	}
	// board[a-1]~board[0]의 b번째 문자 저장
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        
        LinkedList<LinkedList<Box>> map = new LinkedList<>();
        boolean flag = true;
        String col = "";
        for(int i = 0; i < n; i++) {
        	map.add(new LinkedList<>());
        	for(int j = m - 1; j >= 0; j--) {
        		map.get(i).add(new Box(board[j].charAt(i)));
        	}
        }
        char c = 0;
        
        while(flag) {
        	flag = false;
        	
        for(int i = 0; i < map.size(); i++) {
        	for(int j = 0; j < map.get(i).size(); j++) {
        		try {
        		c = map.get(i).get(j).block;
        		if(c == map.get(i+1).get(j).block && c == map.get(i+1).get(j+1).block && c == map.get(i).get(j+1).block) {
        			map.get(i).get(j).explode();
        			map.get(i+1).get(j).explode();
        			map.get(i).get(j+1).explode();
        			map.get(i+1).get(j+1).explode();
        		}
        		}catch(Exception e) {
        			continue;
        		}
        	}
        }
        for(int i = 0; i < map.size(); i++) {
        	for(int j = 0; j < map.get(i).size(); j++) {
        		if(map.get(i).get(j).explosion) {
        			map.get(i).remove(j);
        			answer++;
        			flag = true;
        		}
        	}
        }
        }
        System.out.println(answer);
        
        return answer;
    }
}

class Box{
	char block;
	boolean explosion;
	
	public Box(char block) {
		this.block = block;
		explosion = false;
	}
	
	public void explode() {
		explosion = true;
	}
}
