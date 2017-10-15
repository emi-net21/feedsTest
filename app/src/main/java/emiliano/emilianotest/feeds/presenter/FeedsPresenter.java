package emiliano.emilianotest.feeds.presenter;

import java.util.List;

import emiliano.emilianotest.feeds.FeedsContract;
import emiliano.emilianotest.feeds.repository.TwitterFeedsProvider;
import emiliano.emilianotest.words_history.storage.WordsDBRepository;
import twitter4j.Status;

public class FeedsPresenter implements FeedsContract.Presenter, TwitterFeedsProvider.ListenerApiGetFeeds {

    private TwitterFeedsProvider twitterFeedsProvider;
    private WordsDBRepository wordsDBRepository;


    private FeedsContract.View mView;

    public FeedsPresenter(WordsDBRepository wordsDBRepository) {
        twitterFeedsProvider = new TwitterFeedsProvider();
        this.wordsDBRepository = wordsDBRepository;
    }

    @Override
    public void attach(FeedsContract.View view) {
        this.mView = view;
    }

    @Override
    public void detach() {
        this.mView = null;
    }

    @Override
    public void onSearchFeeds(String text) {
        mView.showProgress();
        wordsDBRepository.addWord(text);
        twitterFeedsProvider.getFeedsByWord(text, this);
    }

    @Override
    public void onGetFeedsSuccess(List<Status> feeds) {
        mView.showFeeds(feeds);
    }

    @Override
    public void onGetFeedsFailure() {
        mView.showError();
    }
}
