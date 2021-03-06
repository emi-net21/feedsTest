package emiliano.emilianotest.words_history.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import emiliano.emilianotest.R;
import emiliano.emilianotest.words_history.presenter.IWordsPresenter;
import emiliano.emilianotest.words_history.presenter.WordsPresenter;
import emiliano.emilianotest.words_history.view.adapters.WordsHistoryRVAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link WordsHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WordsHistoryFragment extends Fragment implements IWordsMain {

    private IWordsPresenter wordsPresenter;
    private RecyclerView rvWordsHistory;

    public WordsHistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WordsHistoryFragment.
     */
    public static WordsHistoryFragment newInstance() {
        return new WordsHistoryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_words_history, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.action_word_history));


        wordsPresenter = new WordsPresenter(this, getContext());

        rvWordsHistory = (RecyclerView) view.findViewById(R.id.rv_words_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvWordsHistory.getContext(),
                layoutManager.getOrientation());
        rvWordsHistory.addItemDecoration(dividerItemDecoration);
        rvWordsHistory.setLayoutManager(layoutManager);
        wordsPresenter.getWordsHistory();
    }

    @Override
    public void displayWordsHistory(List<String> wordsHistory) {
        WordsHistoryRVAdapter adapter = new WordsHistoryRVAdapter(wordsHistory);
        rvWordsHistory.setAdapter(adapter);
    }
}
