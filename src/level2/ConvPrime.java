package level2;

public class ConvPrime {
//437674	3	3
	public static void main(String[] args) {
		solution(437674, 3);

	}
	
	public static int solution(int n, int k) {
        int answer = 0;
        // n 을 k진수 문자열로 변환
        // 0 단위로 자르기
        // 10진수 정수로 변환하여 소수인지 체크
        String convN = "0";
        while(n > 0) {
        	convN += (n % k);
        	n /= k;
        }
       
        String splitN = "";
        char c = 0;
        for(int i=convN.length()-1; i >= 0; i--) {
        	c = convN.charAt(i);
        	if(c == '0') {
        		if(splitN.length() > 0) {
        			answer += primeck(splitN, k);
        			splitN = "";
        		}
        	}else {
        		splitN += c;
        	}
        }
        System.out.println(answer);
        return answer;
    }

	private static int primeck(String splitN, int k) {
		int decN = Integer.parseInt(splitN);
		if(decN < 2) return 0;
		
		for(int i=2; i*i <= decN; i++) {
			if(decN % i == 0) {
				return 0;
			}
		}
		System.out.println(decN + " is prime number");
		return 1;
	}
}
