package emiliano.emilianotest.feeds.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import emiliano.emilianotest.BuildConfig;
import emiliano.emilianotest.feeds.presenter.IFeedsPresenter;
import emiliano.emilianotest.utils.CustomRobolectricTestRunner;

import static org.mockito.Mockito.mock;

/**
 * Created by Emiliano on 3/9/17.
 */
@RunWith(CustomRobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class FeedsFragmentTest {

    private IFeedsPresenter mockFeedsPresenter;
    private FeedsFragment subject;

    @Before
    public void setUp() {
        mockFeedsPresenter = mock(IFeedsPresenter.class);
        subject = new FeedsFragment();

        AppCompatActivity activity = Robolectric.buildActivity(AppCompatActivity.class)
                .create()
                .start()
                .resume()
                .get();

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(subject, null);
        fragmentTransaction.commit();
    }

    @Test
    public void onViewCreated() {

    }

    @Test
    public void showFeeds() {


    }

}