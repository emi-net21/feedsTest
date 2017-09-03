package emiliano.emilianotest.words_history.presenter;

import android.content.Context;

import java.util.List;

import emiliano.emilianotest.words_history.storage.WordsDBPresenter;
import emiliano.emilianotest.words_history.ui.IWordsMain;

/**
 * Created by Emiliano on 2/9/17.
 */

public class WordsPresenter implements IWordsPresenter {

    private WordsDBPresenter wordsDBPresenter;
    private IWordsMain listenerWordsMain;


    public WordsPresenter(IWordsMain listenerWordsMain, Context context) {
        this.wordsDBPresenter = new WordsDBPresenter(context);
        this.listenerWordsMain = listenerWordsMain;
    }

    @Override
    public void getWordsHistory() {
        List<String> wordsHistory = wordsDBPresenter.getWordsHistory();
        listenerWordsMain.displayWordsHistory(wordsHistory);
    }
}
