package emiliano.emilianotest.feeds.view;

import java.util.List;

import twitter4j.Status;

public interface IFeedsMain {
    void showProgress();

    void showFeeds(List<Status> feeds);

    void showError();
}
