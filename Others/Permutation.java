import java.util.*;
public class Permutation{


	public static void main(String[] args){

		permute("TommyLovesEva");
	}

	public static void permute(String s){
		HashSet<String> hs = new HashSet();
		permuteHelper(s, "", hs);
	}

	public static void permuteHelper(String s, String chosen, HashSet<String> hs){
		//System.out.println("permuteHelper(" + s + ", " + chosen + ")");
		if(s.isEmpty()){
			if(!hs.contains(chosen)){
				hs.add(chosen);
				System.out.println(chosen);
			}
			return;
		}
		for(int i = 0; i < s.length(); i++){

			//choose
			char c = s.charAt(i);

			s = s.substring(0,i) + s.substring(i+1, s.length());

			//explore
			permuteHelper(s, chosen + c, hs);

			//unchoose
			s = s.substring(0,i) + c + s.substring(i, s.length());

		}

	}
}
