package main.java;


import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@EnableAspectJAutoProxy
public class App {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
	/*	TweetServiceImpl tser = new TweetServiceImpl();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the name of the greeter");
			String name = in.nextLine();
			tser =  (TweetServiceImpl) context.getBean("tweetServiceImpl");
			tser.tweet("Tom", "hello from tom");
			//System.out.println(obj.getGreeting());
*/		

		TweetServiceImpl tser;
		//= new TweetServiceImpl();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		tser = (TweetServiceImpl) context.getBean("TweetServiceImpl");
		tser.tweet("tom", "hello from tom");
		
		TweetStatsImpl tsi = new TweetStatsImpl();
		System.out.println(tsi.getLengthOfLongestTweet());
	}

}
