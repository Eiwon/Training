package level2;

import java.util.*;

public class SkillTree {
//"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
	public static void main(String[] args) {
		
		solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});

	}
	public static int solution(String skill, String[] skill_trees) {
	     int answer = 0;
	     
	     HashMap<Character, Integer> sequence = new HashMap<>();
	     
	     for(int i = 0; i < skill.length(); i++) {
	    	 sequence.put(skill.charAt(i), i);
	     } // 순서 등록
	     
	     for(String tree : skill_trees) {
	    	 answer += check(tree, sequence);
	     }
	     System.out.println(answer);
	     
	     return answer;
	}
	private static int check(String tree, HashMap<Character, Integer> sequence) {
	
		int lastIdx = -1;
		char pick = 0;
		for(int i = 0; i < tree.length(); i++) {
			pick = tree.charAt(i);
			if(sequence.containsKey(pick)) {
				if(sequence.get(pick) != lastIdx + 1) {
					return 0;
				}
				lastIdx = sequence.get(pick);
			}
		}
		System.out.println(tree);
		return 1;
	}
	
	
	
}
