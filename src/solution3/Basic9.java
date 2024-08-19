package solution3;
import java.util.*;

public class Basic9 {
	public int[] solution1(int n) {
        int[] answer = new int[n];
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 1; i * i <= n; i++){
           if(n % i == 0){
               answer[idx++] = i;
               if(n != i * i){
                   stack.add(n / i);
               }
           } 
        }
        while(stack.size() > 0) {
        	answer[idx++] = stack.pop();
        }
        
        answer = Arrays.copyOfRange(answer, 0, idx);
        
        return answer;
    }
	
	public String solution2(String s) {
        String answer = "";
        int[] charSet = new int[26];
        char p;
        for(int i = 0; i < s.length(); i++) {
        	p = s.charAt(i);
        	charSet[p - 'a']++;
        }
        for(int i = 0; i < charSet.length; i++) {
        	if(charSet[i] == 1) {
        		answer += (char)(i + 'a');
        	}
        }
        return answer;
    }
	public String solution3(String my_string, int num1, int num2) {
        String answer = "";
        int prev = Math.min(num1, num2), next = Math.max(num1, num2);
        
        answer = my_string.substring(0, prev) + my_string.charAt(next)
        	+ my_string.substring(prev + 1, next) + my_string.charAt(prev)
        	+ my_string.substring(next + 1, my_string.length());
        
        return answer;
    }
	public long solution4(String numbers) {
        long answer = 0;
        int idx = 0;
        char p;
        while(idx < numbers.length()) {
        	p = numbers.charAt(idx);
        	answer *= 10;
        	switch (p) {
        	case 'z' :
        		idx += 4;
        		break;
			case 'o':
				answer++;
				idx += 3;
				break;
			case 't' : 
				if(numbers.charAt(idx + 1) == 'w') {
					answer += 2;
					idx += 3;
				}else {
					answer += 3;
					idx += 5;
				}
				break;
			case 'f' :
				if(numbers.charAt(idx + 1) == 'o') {
					answer += 4;
					idx += 4;
				}else {
					answer += 5;
					idx += 4;
				}
				break;
			case 's' :
				if(numbers.charAt(idx + 1) == 'i') {
					answer += 6;
					idx += 3;
				}else {
					answer += 7;
					idx += 5;
				}
				break;
			case 'e' :
				answer += 8;
				idx += 5;
				break;
			case 'n' :
				answer += 9;
				idx += 4;
				break;
			default:
				break;
			}
        }
        
        return answer;
    }
	
	public String solution5(String my_string) {
        String answer = "";
        char p;
        for(int i = 0; i < my_string.length(); i++) {
        	p = my_string.charAt(i);
        	answer += 
        		Character.isUpperCase(p) ? Character.toLowerCase(p) : Character.toUpperCase(p);
        }
        return answer;
    }
	public String solution6(String cipher, int code) {
        String answer = "";
        
        for(int i = code - 1; i < cipher.length(); i += code) {
        	answer += cipher.charAt(i);
        }
        
        return answer;
    }
	public int solution7(int order) {
        int answer = 0;
        int remains;
        while(order > 0) {
        	remains = order % 10;
        	if(remains != 0 && remains % 3 == 0) answer++;
        	order /= 10;
        }
        
        return answer;
    }
	
	public int solution8(int[] array, int n) {
        int answer = 0;
        int minDist = Integer.MAX_VALUE;
        
        for(int i = 0; i < array.length; i++) {
        	int dist = Math.abs(array[i] - n);
        	if(dist < minDist) {
        		minDist = dist;
        		answer = array[i];
        	}else if(dist == minDist) {
        		if(array[i] < answer) {
        			answer = array[i];
        		}
        	}
        }
        
        return answer;
    }
	public int solution9(int chicken) {
        int answer = 0;
        int remains = chicken;
        
        while(remains > 9){
            answer += remains / 10;
            remains = remains / 10 + remains % 10;
        }
        
        return answer;
    }
	public String solution10(String[] id_pw, String[][] db) {
        for(String[] user : db) {
        	if(user[0].equals(id_pw[0])) {
        		return (user[1].equals(id_pw[1])) ? "login" : "wrong pw";
        	}
        }
        
        return "fail";
    }
	public int[] solution11(int[][] score) {
        int[] answer = new int[score.length];
        Queue<Integer> q = new PriorityQueue<>((a, b) -> {return b - a;});
        Map<Integer, Integer> rankTable = new HashMap<>();
        
        for(int[] sco : score) {
        	q.add(sco[0] + sco[1]);
        }
        
        int rank = 1, dup = 0;
        while(q.size() > 0) {
        	int sum = q.poll();
        	if(!rankTable.containsKey(sum)) {
        		rank += dup;
        		rankTable.put(sum, rank++);
        		dup = 0;
        	}else {
        		dup++;
        	}
        }
        
        for(int i = 0; i < score.length; i++) {
        	answer[i] = rankTable.get(score[i][0] + score[i][1]);
        }
        
        return answer;
    }
	public int solution12(int a, int b) {
		while(b % 2 == 0) {
        	b /= 2;
        }
        while(b % 5 == 0) {
        	b /= 5;
        }
        if(b != 1 && a % b != 0){
            return 2;
        }
        
        return 1;
    }
	public int solution13(int n) {
        int answer = 0, start = 0, end = n, stack = 0;
        
        while(start != end) {
        	for(int i = start + 1; i <= end; i++) {
        		if(i % 3 == 0) {
        			stack++;
        			continue;
        		}
        		int a = i;
        		while(a > 0) {
        			if(a % 10 == 3) {
        				stack++;
        				break;
        			}
        			a /= 10;
        		}
        	}
        	start = end;
        	end += stack;
        	stack = 0;
        }
        answer = end;
        
        return answer;
    }
	public int solution13(int[] sides) {
        int answer = 1;
        // max보다 작으면서, max - min 보단 큰 수
        // max보다 크면서, max + min보단 작은 수
        // max랑 같은 수
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        for(int i = max - min +1; i < max; i++){
            answer++;
        }
        for(int i = max + 1; i < max + min; i++){
            answer++;
        }
        return answer;
    }
	public int solution14(String my_string) {
        int answer = 0;
        
        String number = "";
        
        char p;
        for(int i = 0; i < my_string.length(); i++) {
        	p = my_string.charAt(i);
        	if(Character.isDigit(p)) {
        		number += p;
        	}else {
        		if(number.length() > 0) {
        			answer += Integer.parseInt(number);
        			number = "";
        		}
        	}
        }
        if(number.length() > 0) {
			answer += Integer.parseInt(number);
			number = "";
		}
        
        return answer;
    }
	
	public int[] solution15(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int limitX = board[0] / 2, limitY = board[1] / 2;
        for(String input : keyinput) {
        	if(input.charAt(0) == 'l' && answer[0] - 1 >= limitX * -1) {
        		answer[0]--;
        	}else if(input.charAt(0) == 'r' && answer[0] + 1 <= limitX) {
        		answer[0]++;
        	}else if(input.charAt(0) == 'u' && answer[1] + 1 <= limitY) {
        		answer[1]++;
        	}else if(input.charAt(0) == 'd' && answer[1] - 1 >= limitY * -1) {
        		answer[1]--;
        	}
        }
        
        return answer;
    }
	public int solution16(int[] numbers) {
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1], numbers[numbers.length - 1] * numbers[numbers.length - 2]);
    }
	public int solution17(int[][] dots) {
        int[] start = dots[0], end = dots[1];
        for(int[] dot : dots){
            start[0] = Math.min(start[0], dot[0]);
            start[1] = Math.min(start[1], dot[1]);
            end[0] = Math.max(end[0], dot[0]);
            end[1] = Math.max(end[1], dot[1]);
        }
        return (end[0] - start[0]) * (end[1] - start[1]);
    }
	public int solution18(String s) {
        int answer = 0;
        int recent = 0;
        for(String command : s.split(" ")) {
        	if(command.equals("Z")) {
        		answer -= recent;
        	}else {
        		recent = Integer.parseInt(command);
        		answer += recent;
        	}
        }
        
        return answer;
    }
	public int solution19(String my_string) {
        int answer = 0;
        char p;
        for(int i = 0; i < my_string.length(); i++){
            p = my_string.charAt(i);
            if(Character.isDigit(p)) {
            	answer += Integer.parseInt(String.valueOf(p));
            }
        }
        return answer;
    }
	public String solution20(String my_string) {
        String answer = "";
        char p;
        for(int i = 0; i < my_string.length(); i++) {
        	p = my_string.charAt(i);
        	if(p != 'a' && p != 'e' && p != 'o' && p != 'i' && p != 'u') {
        		answer += p;
        	}
        }
        return answer;
    }
	public int[] solution21(int n) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        for(int i = 2; i <= n; i++) {
        	if(n % i == 0) {
        		q.add(i);
        	}
        	while(n % i == 0) {
        		n /= i;
        	}
        }
        answer = new int[q.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = q.poll();
        }
        
        return answer;
    }
	public int solution22(String[] spell, String[] dic) {
        int spellNum = spell.length;
        Map<Character, Integer> origin = new HashMap<>();
        Map<Character, Integer> target;
        
        char p;
        for(String sp : spell) {
        	p = sp.charAt(0);
        	if(origin.containsKey(p)){
        		origin.put(p, origin.get(p) + 1);
        	}else origin.put(p, 1);
        }
        
        for(String word : dic) {
        	if(word.length() != spellNum) {
        		continue;
        	}
        	target = new HashMap<>();
        	for(int i = 0; i < word.length(); i++) {
        		p = word.charAt(i);
        		if(target.containsKey(p)){
        			target.put(p, target.get(p) + 1);
            	}else target.put(p, 1);
        	}
        	if(origin.equals(target))
        		return 1;
        }
        
        return 2;
    }
}
