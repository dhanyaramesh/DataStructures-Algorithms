package hackerRank;

import java.util.ArrayList;

public class FirstRepeatedword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayList<String> delimiters = new ArrayList<String>();
		delimiters.add("\\s+");
		delimiters.add(".");
		delimiters.add(";");
		delimiters.add(":");
		delimiters.add("-");
		delimiters.add("\\t+");
		
		for(int i=0;i<delimiters.size();i++)
			sentence.replace(delimiters.get(i), " ");*/
		String sentence = "I had now new one, had new.";
		//String pattern = "[(.*)(;*)(:*)(\\s*)(\\t*)]*";
		sentence = sentence.replace("\\w+", " ");
		String[] words = sentence.split(" ");
		ArrayList<String> repetitions = new ArrayList<String>();
		
		
		for(int i=0;i<words.length;i++){
			if(!repetitions.contains(words[i]))
				repetitions.add(words[i]);
			else{
				System.out.println(words[i]);
				return;
			}
		}


	}

}
