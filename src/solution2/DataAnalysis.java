//데이터는 ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]으로 구성되어 있으며 현식이는 이 데이터들 중 조건을 만족하는 데이터만 뽑아서 정렬하려 합니다.
//정렬한 데이터들이 담긴 이차원 정수 리스트 data와 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext, 뽑아낼 정보의 기준값을 나타내는 정수 val_ext, 정보를 정렬할 기준이 되는 문자열 sort_by가 주어집니다.
//
//data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요. 단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.
//
//제한사항
//1 ≤ data의 길이 ≤ 500
//data[i]의 원소는 [코드 번호(code), 제조일(date), 최대 수량(maximum), 현재 수량(remain)] 형태입니다.
//1 ≤ 코드 번호≤ 100,000
//20000101 ≤ 제조일≤ 29991231
//data[i][1]은 yyyymmdd 형태의 값을 가지며, 올바른 날짜만 주어집니다. (yyyy : 연도, mm : 월, dd : 일)
//1 ≤ 최대 수량≤ 10,000
//1 ≤ 현재 수량≤ 최대 수량
//ext와 sort_by의 값은 다음 중 한 가지를 가집니다.
//"code", "date", "maximum", "remain"
//순서대로 코드 번호, 제조일, 최대 수량, 현재 수량을 의미합니다.
//val_ext는 ext에 따라 올바른 범위의 숫자로 주어집니다.
//정렬 기준에 해당하는 값이 서로 같은 경우는 없습니다.
package solution2;
//[[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]]	
//"date"	20300501	"remain"	
//[[3,20300401,10,8],[1,20300104,100,80]]
import java.util.*;
public class DataAnalysis {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<Integer[]> extSet = new ArrayList<>(); 
        // ext 값이 val_ext보다 작은 데이터 추출
        // sort_by 값 기준으로 오름차순 정렬
        int row = getType(ext);
        for(int i=0; i<data.length; i++) {
        	if(data[i][row] < val_ext) {
        		extSet.add(new Integer[] {data[i][0], data[i][1], data[i][2], data[i][3]});
        	}
        }
        int sortType = getType(sort_by);
        
        extSet.sort(new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[sortType].compareTo(o2[sortType]);
			}
        	
        });
        answer = new int[extSet.size()][4];
        Integer[] ls;
        for(int i = 0; i < extSet.size(); i++) {
        	ls = extSet.get(i);
        	for(int j = 0; j < 4; j++) {
        		answer[i][j] = ls[j];
        	}
        }
        
        return answer;
    }

	private int getType(String str) {
		String[] type = {"code", "date", "maximum", "remain"};
		for(int i=0; i<type.length; i++) {
			if(str.equals(type[i]))
				return i;
		}
		return -1;
	}
}
