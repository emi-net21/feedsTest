package emiliano.emilianotest.feeds.repository;

import android.os.AsyncTask;

import java.util.List;

import emiliano.emilianotest.BuildConfig;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import static emiliano.emilianotest.BuildConfig.TWITTER_CONSUMER_KEY;
import static emiliano.emilianotest.BuildConfig.TWITTER_CONSUMER_SECRET;

public class TwitterFeedsProvider implements TwitterApi {

    private static final int MAX_COUNT_FEEDS = 50;

    private final Twitter twitterInstance;
    private ListenerApiGetFeeds listenerApiGetFeeds;

    public TwitterFeedsProvider() {
        final Configuration configuration = createConfiguration();
        final TwitterFactory twitterFactory = new TwitterFactory(configuration);
        twitterInstance = twitterFactory.getInstance();
    }

    private Configuration createConfiguration() {
        final ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
                .setOAuthAccessToken(BuildConfig.TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(BuildConfig.TWITTER_ACCESS_TOKEN_SECRET);

        return configurationBuilder.build();
    }

    public void getFeedsByWord(String word, ListenerApiGetFeeds listenerApiGetFeeds) {
        this.listenerApiGetFeeds = listenerApiGetFeeds;
        new GetFeeds().execute(word);
    }

    @Override
    public List<Status> searchTweets(String keyword) {
        final Query query = new Query(keyword).count(MAX_COUNT_FEEDS);
        QueryResult result;
        try {
            result = twitterInstance.search(query);
            return result.getTweets();
        } catch (TwitterException e) {
            e.printStackTrace();
            listenerApiGetFeeds.onGetFeedsFailure();
        }
        return null;
    }

    public interface ListenerApiGetFeeds {
        void onGetFeedsSuccess(List<Status> feeds);

        void onGetFeedsFailure();
    }

    private class GetFeeds extends AsyncTask<String, Void, List<Status>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<twitter4j.Status> doInBackground(String... params) {
            return searchTweets(params[0]);
        }

        @Override
        protected void onPostExecute(List<twitter4j.Status> statuses) {
            super.onPostExecute(statuses);
            if (statuses != null) {
                listenerApiGetFeeds.onGetFeedsSuccess(statuses);
            } else {
                listenerApiGetFeeds.onGetFeedsFailure();
            }
        }
    }
}
