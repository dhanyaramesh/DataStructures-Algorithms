package main.java;



import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



@Aspect

public class StatsAspect {
	
	@After("execution(* main.java.TweetServiceImpl.tweet(..))")
	public void logTweet(JoinPoint jp){
		
		String user = (String)jp.getArgs()[0];
		String message = (String)jp.getArgs()[1];
		System.out.println(user + " tweeted "+ message);
		
		TweetStatsImpl tsi = new TweetStatsImpl();
		// create an entry in tweet hashmap
		tsi.tweet.put(user,message);
		
		// add the length of the message
		if(tsi.tweetlength.containsKey(user)){
			tsi.tweetlength.put(user, tsi.tweetlength.get(user)+message.length()) ;
		}
		else
			tsi.tweetlength.put(user,message.length()) ;
		
		
	}
	
	
	@After("execution(* aop.src.main.java.TweetServiceImpl.tweet(..))")
	public void logFollow(JoinPoint jp){
		String follower = (String)jp.getArgs()[0];
		String followee = (String)jp.getArgs()[1];
		System.out.println(follower + "started following " + followee);
		
		TweetStatsImpl tsi = new TweetStatsImpl();
		
		if(tsi.follower.containsKey(follower))
			tsi.follower.put(follower,tsi.follower.get(follower)+1);
		else
			tsi.follower.put(follower,1);
		
		
	}
	

}
