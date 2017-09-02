package emiliano.emilianotest.feeds.presenter;

import android.content.Context;

import java.util.List;

import emiliano.emilianotest.feeds.twitter.TwitterFeedsProvider;
import emiliano.emilianotest.feeds.view.IFeedsMain;
import emiliano.emilianotest.words_history.storage.WordsDBPresenter;
import twitter4j.Status;

public class FeedsPresenter implements IFeedsPresenter, TwitterFeedsProvider.ListenerApiGetFeeds {

    private IFeedsMain feedsMain;
    private TwitterFeedsProvider twitterFeedsProvider;
    private WordsDBPresenter wordsDBPresenter;

    public FeedsPresenter(IFeedsMain feedsMain, Context context) {
        twitterFeedsProvider = new TwitterFeedsProvider();
        wordsDBPresenter = new WordsDBPresenter(context);
        this.feedsMain = feedsMain;
    }

    @Override
    public void onSearchFeeds(String text) {
        feedsMain.showProgress();
        wordsDBPresenter.addWord(text);
        twitterFeedsProvider.getFeedsByWord(text, this);
    }

    @Override
    public void onGetFeedsSuccess(List<Status> feeds) {
        feedsMain.showFeeds(feeds);
    }

    @Override
    public void onGetFeedsFailure() {
        feedsMain.showError();
    }
}
