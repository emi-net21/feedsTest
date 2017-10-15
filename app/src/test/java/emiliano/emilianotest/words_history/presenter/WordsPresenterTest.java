package emiliano.emilianotest.words_history.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import emiliano.emilianotest.BuildConfig;
import emiliano.emilianotest.words_history.view.IWordsMain;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, manifest = "src/main/AndroidManifest.xml")
public class WordsPresenterTest {

    private IWordsMain mockWordsMain;
    private WordsPresenter subject;

    @Before
    public void setUp() {
        mockWordsMain = mock(IWordsMain.class);
        subject = new WordsPresenter(mockWordsMain, RuntimeEnvironment.application);
    }

    @Test
    public void getWordsHistory() {
        subject.getWordsHistory();
        verify(mockWordsMain).displayWordsHistory(any(List.class));
    }

}