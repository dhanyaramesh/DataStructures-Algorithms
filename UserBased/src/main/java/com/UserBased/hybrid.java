package com.UserBased;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class hybrid {

	public static void main(String[] args) throws IOException {

		String movie_names_array[] = {"Star Wars","Spotlight","Rocky","Mad Max : Fury Road",
				"Kung Fu Panda3","Despicable Me","Big Hero 6","The hungover",
				"Inside out","The big short","Almost Famous","The hunger games",
				"Pulp Fiction","Inglorious Basterds","The usual suspects",
				"Mamma Mia","Frozen","Legally Blonde","Silver Linings",
				"Twilight","Bridget Jones Diary","Gone Girl","The matrix","Alien",
				"2001:A space Odyssey","The godfather","Pretty Woman","Star Wars 2",
				"Captain America","Room","The Danish Girl","The Martian","The intern",
				"Zootopia","X-Men","Mission Impossible - Rogue Nation","spy","Focus"};
		
		String[] genres = {"Comedy","Action","Sci-Fi & Fantasy","Independent","Romantic","Animation","Drama"};
	     HashMap<String,Integer> genre = new HashMap<String,Integer>();
	     for(int s=0;s<genres.length;s++)
	    	 genre.put(genres[s], s+1);
				
	// movie-genre dataset	
		String csvFile1 = "data/content_based_movie_genre_dataset.csv";
		BufferedReader br1 = null;
		String line1 = "";
		String cvsSplitBy1 = ",";
		ArrayList<String[]> movie_genre = new ArrayList<String[]>();
	
		

			br1 = new BufferedReader(new FileReader(csvFile1));
			int j=0;
			while ((line1 = br1.readLine()) != null) {
				String[] each_movie_genre = {"",""};
			        // use comma as separator
				String[] entry = line1.split(cvsSplitBy1);
				each_movie_genre[0] = entry[0];
				each_movie_genre[1] = entry[1];
				movie_genre.add(each_movie_genre);
				j++;
				
			}
	// user-movie rating dataset
			
		String csvFile = "data/content_based_user_item.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Integer[]> user_item = new ArrayList<Integer[]>();
		

			br = new BufferedReader(new FileReader(csvFile));
			int i=0;
			while ((line = br.readLine()) != null) {
				Integer[] user_item_rating = {0,0,0,0};
			        // use comma as separator
				String[] entry = line.split(cvsSplitBy);
				user_item_rating[0] = Integer.parseInt(entry[0]);  //user id
				user_item_rating[1] = Integer.parseInt(entry[1]);  //item id
				user_item_rating[2] = Integer.parseInt(entry[2]);  // rating
			
				for(int k=0;k<movie_genre.size();k++){
					String[] temp = movie_genre.get(k);
					
					if(temp[0].equals(entry[1])){
						user_item_rating[3] = genre.get(temp[1]);      //genre
						if(!user_item.contains(user_item_rating)){
							user_item.add(user_item_rating);
							i++;
						}
							
					}
					
				}
				
	     }
			
	// normalized user profile for user 204
		
		int user = 204;
		Integer[] up ={0,0,0,0,0,0,0};
		Integer[] count ={0,0,0,0,0,0,0};
		for(int in=0;in<user_item.size();in++){
			Integer[] dummy = user_item.get(in);
			
			if(dummy[0] == user){
				up[dummy[3]-1] +=dummy[2];	
				count[dummy[3]-1] ++;
			}
		}
		
		Integer[] norm_profile = {0,0,0,0,0,0,0};
		for(int in=0;in<up.length;in++){
			if(count[in]!=0 && (up[in] / count[in])>=3 )
				norm_profile[in] = up[in] / count[in];
			else
				norm_profile[in] = 0;
									
		}
		
		// movie-genre binary vectors
		
		String csvFile2 = "data/jaccards_movie_genre_dataset.csv";
		BufferedReader br2 = null;
		String line2 = "";
		String cvsSplitBy2 = ",";
		ArrayList<Integer[]> movie_genre_jaccards = new ArrayList<Integer[]>();
	
		

			br2 = new BufferedReader(new FileReader(csvFile2));
			while ((line2 = br2.readLine()) != null) {
			
				String[] entry = line2.split(cvsSplitBy2);
				Integer[] new_entry = {0,0,0,0,0,0,0};
				for(j =0;j<entry.length;j++){
					new_entry[j] = Integer.parseInt(entry[j]);
				}
				movie_genre_jaccards.add(new_entry);				
				
			}
			
			// calculating jaccard's similarity
			
			int anb=0;
			int a=0;
			int b=0;
			float max = 0;
			int movie_index=0;
			
			for(int in=0;in < movie_genre_jaccards.size(); in++){
				Integer[] temp = movie_genre_jaccards.get(in);
				
				for(j=0;j<temp.length;j++){
					if(temp[j] !=0 && norm_profile[j]!=0){
						anb++;
					}
					if(temp[j]!=0)
						a++;
					if(norm_profile[j]!=0)
						b++;
				}
				
				
				float js = (float)anb / (a+b-anb);
				// finding the max similar element and value
				if(js>=max){
					max=js;
					movie_index =in;
				}
				anb=0;
				a=b =0;
				
				
			}
			// id of the most similar movie.
			movie_index = movie_index+1001;
			System.out.println(movie_index);
			//pass this to item based recommender
	}

}
