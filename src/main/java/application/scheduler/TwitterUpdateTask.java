package application.scheduler;

import application.twitter.TwitterApi;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

import java.io.IOException;
import java.time.LocalDateTime;

import static application.scheduler.IpAddressResolver.getIpAddress;

@Component
public class TwitterUpdateTask {

    @Scheduled(fixedRate = 3600000)
    public void reportCurrentTime() throws IOException {
        String ipAddress = getIpAddress();
        System.out.println("Current ip address is: " + ipAddress);
        System.out.println("Posting to twitter, time: " + LocalDateTime.now());
        try {
            TwitterApi.destroyLastTweet();
            TwitterApi.tweetMessage(ipAddress);
        } catch (TwitterException e) {
            System.err.println("There was a problem posting to application.twitter");
            e.printStackTrace();
        }

    }
}
