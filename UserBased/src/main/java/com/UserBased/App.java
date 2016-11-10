package com.UserBased;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class App 
{
    public static void main( String[] args ) throws IOException, TasteException
    {
		// movie name and movie id mapping
		
		String movie_names_array[] = {"Star Wars","Spotlight","Rocky","Mad Max : Fury Road",
								"Kung Fu Panda3","Despicable Me","Big Hero 6","The hungover",
								"Inside out","The big short","Almost Famous","The hunger games",
								"Pulp Fiction","Inglorious Basterds","The usual suspects",
								"Mamma Mia","Frozen","Legally Blonde","Silver Linings",
								"Twilight","Bridget Jones Diary","Gone Girl","The matrix","Alien",
								"2001:A space Odyssey","The godfather","Pretty Woman","Star Wars 2",
								"Captain America","Room","The Danish Girl","The Martian","The intern",
								"Zootopia","X-Men","Mission Impossible - Rogue Nation","spy","Focus"};
    	ArrayList<String> movie_names = new ArrayList<String>(Arrays.asList(movie_names_array));
		DataModel model = new FileDataModel(new File("movie_response_dataset.csv"));
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
