package edu.sjsu.cmpe275.aop;

import java.io.IOException;

public interface TweetService {
	void tweet(String user,String message)throws IOException,IllegalArgumentException;
	void follow(String follower,String followee)throws IOException;

}
