//양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.
//
//x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
//정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ numbers의 길이 ≤ 100,000
//0 ≤ numbers의 모든 수 ≤ 1015

package level2New;

public class DiffBit {

	public static void main(String[] args) {
		
		solution(new long[] {2, 7});

	}
	public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        // 뒤에서부터 확인, 처음으로 0이 나오면 1로 변경, 그 뒤의 수를 0으로 변경
        
        for(int i = 0; i < numbers.length; i++) {
        	answer[i] = check(numbers[i]);
        }
        
        return answer;
    }
	private static long check(long number) {
		
		String bin = '0' + Long.toBinaryString(number);
		String sum = "", front = "", back = "";
		
		for(int i = bin.length() -1; i >= 0; i--) {
			if(bin.charAt(i) == '0') {
				front = bin.substring(0, i);
				if(i != bin.length() - 1) {
					back = bin.substring(i + 1, bin.length());
				}
				break;
			}
		}
		if(back.length() != 0) {
			sum = front.concat("10").concat(back.substring(1, back.length()));
		}else {
			sum = front.concat("1");
		}
		
		long result = 0, mul = 1;
		for(int i = sum.length() - 1; i >= 0; i--) {
			result += Character.getNumericValue(sum.charAt(i)) * mul;
			mul *= 2;
		}
		
		return result;
	}
}
