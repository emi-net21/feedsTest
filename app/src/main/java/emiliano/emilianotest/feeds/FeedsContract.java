package emiliano.emilianotest.feeds;

import java.util.List;

import emiliano.emilianotest.common.BasePresenter;
import twitter4j.Status;

public interface FeedsContract {

    interface View {
        void showProgress();

        void showFeeds(List<Status> feeds);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void onSearchFeeds(String text);
    }

}
