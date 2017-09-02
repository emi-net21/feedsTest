package emiliano.emilianotest.feeds.twitter;

import java.util.List;

import twitter4j.Status;

public interface TwitterApi {
    List<Status> searchTweets(final String keyword);
}
