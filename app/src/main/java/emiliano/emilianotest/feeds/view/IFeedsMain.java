package emiliano.emilianotest.feeds.view;

import java.util.List;

import twitter4j.Status;

/**
 * Created by Emiliano on 30/8/17.
 */

public interface IFeedsMain {
    void showProgress();
    void showFeeds(List<Status> feeds);
}
