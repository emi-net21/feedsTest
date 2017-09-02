package emiliano.emilianotest.feeds.presenter;

import java.util.List;

import emiliano.emilianotest.feeds.twitter.TwitterFeedsProvider;
import emiliano.emilianotest.feeds.view.IFeedsMain;
import twitter4j.Status;

public class FeedsPresenter implements IFeedsPresenter, TwitterFeedsProvider.ListenerApiGetFeeds {

    private IFeedsMain feedsMain;
    private TwitterFeedsProvider twitterFeedsProvider;

    public FeedsPresenter(IFeedsMain feedsMain) {
        this.feedsMain = feedsMain;
    }

    @Override
    public void onSearchFeeds(String text) {
        feedsMain.showProgress();
        twitterFeedsProvider = new TwitterFeedsProvider();
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
