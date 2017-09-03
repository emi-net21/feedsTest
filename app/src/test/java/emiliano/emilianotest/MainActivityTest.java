package emiliano.emilianotest;

import android.support.v4.app.Fragment;
import android.view.MenuItem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import emiliano.emilianotest.feeds.view.FeedsFragment;
import emiliano.emilianotest.words_history.ui.WordsHistoryFragment;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private MainActivity subject;

    @Before
    public void setUp() {
        subject = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertThat(subject).isNotNull();
    }

    @Test
    public void onCreate_shouldAddFeedFragment() {
        List<Fragment> fragmentList = subject.getSupportFragmentManager().getFragments();
        assertThat(fragmentList.get(0)).isInstanceOf(FeedsFragment.class);
        assertThat(fragmentList.size()).isEqualTo(1);
    }

    @Test
    public void onOptionsItemSelected_actionHistory_shouldChangeFragment() {
        MenuItem mockMenu = mock(MenuItem.class);
        when(mockMenu.getItemId()).thenReturn(R.id.action_show_history);
        subject.onOptionsItemSelected(mockMenu);

        List<Fragment> fragmentList = subject.getSupportFragmentManager().getFragments();
        assertThat(fragmentList.get(1)).isInstanceOf(WordsHistoryFragment.class);
        assertThat(fragmentList.size()).isEqualTo(2);

    }

}