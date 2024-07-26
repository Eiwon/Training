package level2New;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.

대기실은 5개이며, 각 대기실은 5x5 크기입니다.
거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
5개의 대기실을 본 죠르디는 각 대기실에서 응시자들이 거리두기를 잘 기키고 있는지 알고 싶어졌습니다. 자리에 앉아있는 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 문자열 배열 places가 매개변수로 주어집니다. 각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

제한사항
places의 행 길이(대기실 개수) = 5
places의 각 행은 하나의 대기실 구조를 나타냅니다.
places의 열 길이(대기실 세로 길이) = 5
places의 원소는 P,O,X로 이루어진 문자열입니다.
places 원소의 길이(대기실 가로 길이) = 5
P는 응시자가 앉아있는 자리를 의미합니다.
O는 빈 테이블을 의미합니다.
X는 파티션을 의미합니다.
입력으로 주어지는 5개 대기실의 크기는 모두 5x5 입니다.
return 값 형식
1차원 정수 배열에 5개의 원소를 담아서 return 합니다.
places에 담겨 있는 5개 대기실의 순서대로, 거리두기 준수 여부를 차례대로 배열에 담습니다.
각 대기실 별로 모든 응시자가 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 담습니다.
*/
public class Corona {

	public static void main(String[] args) {
		String[][] places = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		};
		
		solution(places);
		// result : 1 0 1 1 1
	}
	
	public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
        	answer[i] = check(places[i]);
        }
        return answer;
    }
/*					"POOOP", 
					"OXXOX", 
					"OPXPX", 
					"OOXOX", 
					"POXXP"*/
	private static int check(String[] strings) {
		Seat[][] room = new Seat[5][5];
		Queue<Seat> danger = new LinkedList<>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				room[i][j] = new Seat(strings[i].charAt(j), i, j);
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(room[i][j].type == 1) {
					danger.add(room[i][j]);
				}
				while(danger.size() > 0) {
					Seat seat = danger.poll();
					if(seat.x -1 >= 0) {
						
					}
				}
				
			}
		}
		
		
		return 0;
	}
}
class Seat {
	int type, shortD, x, y;
	
	public Seat(char type, int x, int y) {
		if(type == 'P') {
			this.type = 1;
			shortD = 0;
		}else if(type == 'O') {
			this.type = 0;
			shortD = 25;
		}else {
			this.type = 2;
			shortD = -1;
		}
		this.x = x;
		this.y = y;
	}
	public int check(Seat other) {
		if(other.type == 0) {
			other.shortD = Math.min(this.shortD +1, other.shortD);
		}else if(other.type == 1) {
			if(this.shortD < 2) {
				
			}
		}
		
		return 0;
	}
}
