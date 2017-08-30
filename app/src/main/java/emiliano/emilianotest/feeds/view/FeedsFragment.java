package emiliano.emilianotest.feeds.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import emiliano.emilianotest.R;
import twitter4j.Status;

/**
 * A placeholder fragment containing a simple view.
 */
public class FeedsFragment extends Fragment implements IFeedsMain {

    public FeedsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feeds, container, false);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showFeeds(List<Status> feeds) {

    }

}
