package edu.sjsu.cmpe275.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TweetStatsImpl {
	/**
	    * reset all the three measurements.
	    */
	
	   //int lengthOfLongestTweet;
	   //String mostActiveFollower;
	   //String mostProductiveUser;
	   
	   public HashMap<String,String> tweet = new HashMap<String,String>();
	   public HashMap<String,Integer> follower = new HashMap<String,Integer>();
	   public HashMap<String,Integer> tweetlength = new HashMap<String,Integer>();
	   
	   public void resetStats(){
	   }
	   
	   /**
	    * @return the length of longest message successfully tweeted since the beginning or last reset. If no messages were successfully tweeted, return 0.
	    */
	   public int getLengthOfLongestTweet(){
		   Iterator iterator = tweet.entrySet().iterator();
		   int length=-1;;
		   while(iterator.hasNext()){
			   Map.Entry pair = (Map.Entry) iterator.next();
			   if(pair.getValue().toString().length()>=length)
				   length = pair.getValue().toString().length();
		   }
		   return length;
		   
	   }
	   /**
	    * @return the user who has attempted to follow the biggest number of different users since
	    * the beginning or last reset. If there is a tie, return the 1st of such users based on
	    * alphabetical order. Even if the follow action did not succeed, it still counts toward the stats.
	    * If no users attempted to follow anybody, return null.  
	    */
	   public String getMostActiveFollower(){
		   
		   Iterator iterator = follower.entrySet().iterator();
		   Integer currmax = -1;
		   String user=null;
		   while(iterator.hasNext()){
			   Map.Entry pair = (Map.Entry) iterator.next();
			   if(Integer.parseInt(pair.getValue().toString()) > currmax){
				   currmax = Integer.parseInt(pair.getValue().toString());
				   user = pair.getKey().toString();
				   
			   }
		   }
		   
		   return user;
		   
	   }
		   
	   /**
	    * The most productive user is determined by the total length of all the messages successfully tweeted since the beginning
	    * or last reset. If there is a tie, return the 1st of such users based on alphabetical order. If no users successfully tweeted, return null.
	    * @return the most productive user.
	    */
	   public String getMostProductiveUser(){
		   Iterator iterator = tweetlength.entrySet().iterator();
		   Integer currmax = -1;
		   ArrayList<String> user = new ArrayList<String>();
		   while(iterator.hasNext()){
			   Map.Entry pair = (Map.Entry) iterator.next();
			   if(Integer.parseInt(pair.getValue().toString()) > currmax){
				   currmax = Integer.parseInt(pair.getValue().toString());
				   if(!user.contains(pair.getKey().toString()))
					   user.add(pair.getKey().toString());
				   
			   }
		   }

		   return user.toString();
		   
	   }

}
