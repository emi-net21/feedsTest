package emiliano.emilianotest.feeds.view;

import java.util.List;

import emiliano.emilianotest.feeds.model.Feed;

/**
 * Created by Emiliano on 30/8/17.
 */

public interface IFeedsMain {
    void showProgress();
    void showFeeds(List<Feed> feeds);
}
