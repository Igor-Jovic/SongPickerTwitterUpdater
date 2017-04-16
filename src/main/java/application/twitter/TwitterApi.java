package application.twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Optional;

public class TwitterApi {

    public static void tweetMessage(String message) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.updateStatus(message);
    }

    public static void destroyLastTweet() throws TwitterException {
        Optional<Status> first = TwitterFactory.getSingleton().getHomeTimeline().stream().findFirst();
        if (first.isPresent()) {
            long lastTweetId = first.get().getId();
            TwitterFactory.getSingleton().destroyStatus(lastTweetId);
        }
    }
}
