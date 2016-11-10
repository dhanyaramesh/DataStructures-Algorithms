package com.UserBased;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.math3.linear.ConjugateGradient;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.spark.sql.catalyst.optimizer.Optimizer;

import com.sun.xml.bind.v2.runtime.reflect.ListIterator;

import au.com.bytecode.opencsv.CSVWriter;

public class contentbased {


	public static void main(String[] args) throws IOException, TasteException {
		
	     String[] genres = {"Comedy","Action","Sci-Fi & Fantasy","Independent","Romantic","Animation","Drama"};
	     HashMap<String,Integer> genre = new HashMap<String,Integer>();
	     for(int s=0;s<genres.length;s++)
	    	 genre.put(genres[s], s+1);
				
			///////// movie genre dataset ///////////////////
			
			
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

				
		////////////////////////////////////////////////////////////////
      // ----------user-movie rating dataset--------------------------//
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
					//----- writing the 4 tuples to csv file--------//
					FileWriter writer = new FileWriter(new File("data/test.csv"));

					//writer.append("User_id,Movie_id,rating,genre");
					//writer.append('\n');
					for(Integer[] item : user_item){
						//user
						writer.append(item[0].toString());
						writer.append(',');
						
						// movie
						writer.append(item[1].toString());
						writer.append(',');
						// rating
						writer.append(item[2].toString());
						writer.append(',');

						// genre
						writer.append(item[3].toString());
						writer.append('\n');

						
						
						
						}

					writer.flush();
					writer.close();
					
//////////////////////////////////////
					
				String movie_names_array[] = {"Star Wars","Spotlight","Rocky","Mad Max : Fury Road",
							"Kung Fu Panda3","Despicable Me","Big Hero 6","The hungover",
							"Inside out","The big short","Almost Famous","The hunger games",
							"Pulp Fiction","Inglorious Basterds","The usual suspects",
							"Mamma Mia","Frozen","Legally Blonde","Silver Linings",
							"Twilight","Bridget Jones Diary","Gone Girl","The matrix","Alien",
							"2001:A space Odyssey","The godfather","Pretty Woman","Star Wars 2",
							"Captain America","Room","The Danish Girl","The Martian","The intern",
							"Zootopia","X-Men","Mission Impossible - Rogue Nation","spy","Focus"};
					
		//--------using user based cf with the transformed data set----------//			
						ArrayList<String> movie_names = new ArrayList<String>(Arrays.asList(movie_names_array));
						DataModel model = new FileDataModel(new File("test.csv"));
						UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
						UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
						UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
						
						List<RecommendedItem> recommendations = recommender.recommend(204, 3);
						for (RecommendedItem recommendation : recommendations) {
							int v = (int)recommendation.getItemID()-1001;
							System.out.println(movie_names.get(v));
						  System.out.println(recommendation);
						}
					
					
				
				
				
					


	}

}
