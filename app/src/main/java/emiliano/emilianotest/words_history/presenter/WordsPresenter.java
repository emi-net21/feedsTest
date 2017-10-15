package emiliano.emilianotest.words_history.presenter;

import android.content.Context;

import java.util.List;

import emiliano.emilianotest.words_history.storage.WordsDBRepository;
import emiliano.emilianotest.words_history.view.IWordsMain;

/**
 * Created by Emiliano on 2/9/17.
 */

public class WordsPresenter implements IWordsPresenter {

    private WordsDBRepository wordsDBRepository;
    private IWordsMain listenerWordsMain;


    public WordsPresenter(IWordsMain listenerWordsMain, Context context) {
        this.wordsDBRepository = new WordsDBRepository(context);
        this.listenerWordsMain = listenerWordsMain;
    }

    @Override
    public void getWordsHistory() {
        List<String> wordsHistory = wordsDBRepository.getWordsHistory();
        listenerWordsMain.displayWordsHistory(wordsHistory);
    }
}
