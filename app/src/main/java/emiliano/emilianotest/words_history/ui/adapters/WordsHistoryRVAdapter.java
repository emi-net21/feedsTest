package emiliano.emilianotest.words_history.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import emiliano.emilianotest.R;

/**
 * Created by Emiliano on 2/9/17.
 */

public class WordsHistoryRVAdapter extends RecyclerView.Adapter<WordsHistoryRVAdapter.ViewHolder> {

    ArrayList<String> wordsHistory;

    public WordsHistoryRVAdapter(List<String> wordsHistory) {
        this.wordsHistory = (ArrayList<String>) wordsHistory;
    }

    @Override
    public WordsHistoryRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word_history, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WordsHistoryRVAdapter.ViewHolder holder, int position) {
        holder.tvWord.setText(wordsHistory.get(position));
    }

    @Override
    public int getItemCount() {
        return wordsHistory.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvWord;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = (TextView) itemView.findViewById(R.id.tvWord);
        }
    }
}