package emiliano.emilianotest.feeds.repository;

import java.util.List;

import twitter4j.Status;

public interface TwitterApi {
    List<Status> searchTweets(final String keyword);
}
