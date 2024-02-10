package solution;
import java.util.*;

// 문자열이 너무 길면 StringBuilder 사용
// StringBuilde로 String 함수 쓰려면 toString으로 변환해야함
public class NumSet {
	public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");
        //"12321"	"42531"	"321"
        //숫자 하나씩 추출해서 크기 10 배열에 갯수 저장
        // arrX, arrY 둘이 비교해서 갯수가 더 적은 쪽으로 설정한 arrZ 생성
        // arrZ 의 9 -> 0 순으로 그 값만큼 answer 에 숫자 추가
        // 0 추가할때 answer가 비었으면 1번만 추가
        // 끝났는데 answer가 비었으면 -1 추가
        
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        int[] arrZ = new int[10];
        
        for(int i=0; i<X.length(); i++) {
        	arrX[Character.getNumericValue(X.charAt(i))]++;
        }
        for(int i=0; i<Y.length(); i++) {
        	arrY[Character.getNumericValue(Y.charAt(i))]++;
        }
        for(int i=0; i<arrZ.length; i++) {
        	arrZ[i] = Math.min(arrX[i], arrY[i]);
        }
        
        for(int i=arrZ.length-1; i >= 0; i--) {
            if(i == 0 && sb.length() == 0 && arrZ[i] > 0)
                sb.append('0');
            else{
            for(int j=0; j<arrZ[i]; j++) {
                sb.append(Integer.toString(i));
        	}
            }
        }
        answer = sb.toString();
        
        if(answer.isEmpty()) 
        	answer = "-1";
        return answer;
    }
}
