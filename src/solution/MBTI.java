//위 예시처럼 네오형이 비동의, 어피치형이 동의인 경우만 주어지지 않고, 질문에 따라 네오형이 동의, 어피치형이 비동의인 경우도 주어질 수 있습니다.
//하지만 각 선택지는 고정적인 크기의 점수를 가지고 있습니다.
//
//매우 동의나 매우 비동의 선택지를 선택하면 3점을 얻습니다.
//동의나 비동의 선택지를 선택하면 2점을 얻습니다.
//약간 동의나 약간 비동의 선택지를 선택하면 1점을 얻습니다.
//모르겠음 선택지를 선택하면 점수를 얻지 않습니다.
//검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단합니다. 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.
//
//질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices가 매개변수로 주어집니다. 이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ survey의 길이 ( = n) ≤ 1,000
//survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 하나입니다.
//survey[i]의 첫 번째 캐릭터는 i+1번 질문의 비동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
//survey[i]의 두 번째 캐릭터는 i+1번 질문의 동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
//choices의 길이 = survey의 길이
//
//choices[i]는 검사자가 선택한 i+1번째 질문의 선택지를 의미합니다.
//1 ≤ choices의 원소 ≤ 7

package solution;

public class MBTI {
	public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] typeList = {'R', 'C', 'J', 'A', 'T', 'F', 'M', 'N'};
        int[] score = new int[8];
        // int[4][2] 배열 생성하여 점수 저장
        // 선택지 점수 (1~7) -4 = 실제 점수
        // survey의 각 원소에 접근,
        for(int i=0; i<survey.length; i++) {
        	String type = survey[i];
        	int typeNum = 0;
        	for(int j=0; j<typeList.length; j++) {
        		if(type.charAt(1) == typeList[j]){
        			typeNum = j;
        			break;
        		}
        	}// 질문 타입 체크
        	score[typeNum] += (choices[i] - 4);
        }
        
        for(int i=0; i<score.length/2; i++) {
        	if(score[i] >= score[i+4])
        		answer += typeList[i];
        	else answer += typeList[i+4];
        }
        
        return answer;
    }
}
