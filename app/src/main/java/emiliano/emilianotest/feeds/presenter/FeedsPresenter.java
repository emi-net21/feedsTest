package emiliano.emilianotest.feeds.presenter;

import java.util.ArrayList;
import java.util.List;

import emiliano.emilianotest.feeds.model.Feed;
import emiliano.emilianotest.feeds.view.IFeedsMain;

public class FeedsPresenter implements IFeedsPresenter {

    private IFeedsMain feedsMain;

    public FeedsPresenter(IFeedsMain feedsMain) {
        this.feedsMain = feedsMain;
    }

    @Override
    public void onSearchFeeds(String text) {
        feedsMain.showProgress();
        feedsMain.showFeeds(setData());
    }

    private List<Feed> setData() {
        List<Feed> result = new ArrayList<>();
        result.add(new Feed("11111"));
        result.add(new Feed("222"));
        result.add(new Feed("333"));
        result.add(new Feed("444"));
        result.add(new Feed("5555"));
        return result;
     }
}
