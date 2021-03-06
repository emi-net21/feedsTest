package emiliano.emilianotest.feeds.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import emiliano.emilianotest.R;
import emiliano.emilianotest.feeds.FeedsContract;
import emiliano.emilianotest.feeds.presenter.FeedsPresenter;
import emiliano.emilianotest.feeds.view.adapters.TweetsAdapter;
import emiliano.emilianotest.words_history.storage.WordsDBRepository;
import twitter4j.Status;

/**
 * A placeholder fragment containing a simple view.
 */
public class FeedsFragment extends Fragment implements FeedsContract.View {

    private FeedsPresenter feedsPresenter;
    private RecyclerView rvFeeds;

    public FeedsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feeds, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.feeds));

        feedsPresenter = new FeedsPresenter(new WordsDBRepository(getActivity()));
        feedsPresenter.attach(this);

        rvFeeds = (RecyclerView) view.findViewById(R.id.rv_feeds);
        final EditText etText = (EditText) view.findViewById(R.id.et_text);
        ImageButton ibSearch = (ImageButton) view.findViewById(R.id.ib_search);

        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedsPresenter.onSearchFeeds(etText.getText().toString());
            }
        });

    }

    /**
     * This callback should be used before search feeds, just to give the user a feedback
     */
    @Override
    public void showProgress() {

    }

    @Override
    public void showFeeds(List<Status> feeds) {
        rvFeeds.setHasFixedSize(true);
        rvFeeds.setAdapter(new TweetsAdapter(feeds));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvFeeds.setLayoutManager(layoutManager);
    }

    /**
     * This method should display a error message
     */
    @Override
    public void showError() {

    }
}
