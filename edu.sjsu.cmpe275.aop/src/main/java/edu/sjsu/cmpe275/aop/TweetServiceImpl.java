package edu.sjsu.cmpe275.aop;

import java.io.IOException;

public class TweetServiceImpl implements TweetService {
	public void tweet(String user,String message)throws IOException,IllegalArgumentException{
		
		System.out.println("in tweetserviceimpl");
		/*TweetStatsImpl tsi = new TweetStatsImpl();
		tsi.tweet.put(user, message);
		tsi.tweetlength.put(user, message.length());
		*/
		//System.out.println(tsi.getLengthOfLongestTweet());
		//tsi.tweetlength.put(user, message.length());
		
	}
	public void follow(String follower,String followee)throws IOException {
		
	}

}
