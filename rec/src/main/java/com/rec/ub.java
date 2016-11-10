package com.rec;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class ub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			File file = new File("/Users/dhanyaramesh/Desktop/239/project/sample.csv");
			DataModel model = new FileDataModel(file);
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
			UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(br.readLine()!=null){
				System.out.println(br.readLine());
			}
				
			List recommendations =  (List) recommender.recommend(2,3);
			//for (RecommendedItem recommendation : recommendations) {
			for(int i=0;i<recommendations.size();i++)	
				System.out.println(recommendation);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
