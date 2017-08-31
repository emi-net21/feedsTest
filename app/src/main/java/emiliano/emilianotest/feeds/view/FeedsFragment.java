package emiliano.emilianotest.feeds.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import emiliano.emilianotest.R;
import emiliano.emilianotest.feeds.model.Feed;
import emiliano.emilianotest.feeds.presenter.FeedsPresenter;
import emiliano.emilianotest.feeds.presenter.IFeedsPresenter;

/**
 * A placeholder fragment containing a simple view.
 */
public class FeedsFragment extends Fragment implements IFeedsMain {

    private IFeedsPresenter feedsPresenter;
    private RecyclerView rvFeeds;

    public FeedsFragment() {
        feedsPresenter = new FeedsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feeds, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFeeds = view.findViewById(R.id.rv_feeds);


        final EditText etText = view.findViewById(R.id.et_text);
        ImageButton ibSearch = view.findViewById(R.id.ib_search);

        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedsPresenter.onSearchFeeds(etText.getText().toString());
            }
        });


    }

    public void showProgress() {

    }

    @Override
    public void showFeeds(List<Feed> feeds) {
        rvFeeds.setHasFixedSize(true);
        rvFeeds.setAdapter(new FeedsRVAdapter(getContext(), feeds));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvFeeds.setLayoutManager(layoutManager);
    }

}
