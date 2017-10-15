package emiliano.emilianotest.feeds.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import emiliano.emilianotest.R;
import twitter4j.Status;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

    private List<Status> feeds;

    public TweetsAdapter(List<Status> feeds) {
        this.feeds = feeds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_tweet, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Status item = feeds.get(position);
        final long tweetTime = item.getCreatedAt().getTime();
        final CharSequence time = DateUtils.getRelativeTimeSpanString(tweetTime, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS, DateUtils.FORMAT_ABBREV_ALL);

        Glide.with(holder.photoImageView.getContext())
                .load(item.getUser().getOriginalProfileImageURL())
                .centerCrop()
                .into(holder.photoImageView);

        holder.nameTextView.setText(item.getUser().getName());
        holder.usernameTextView.setText(String.format("@%s", item.getUser().getScreenName()));
        holder.timeTextView.setText(time);
        holder.messageTextView.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photoImageView;
        TextView nameTextView;
        TextView usernameTextView;
        TextView timeTextView;
        TextView messageTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            photoImageView = (ImageView) itemView.findViewById(R.id.photoImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            usernameTextView = (TextView) itemView.findViewById(R.id.usernameTextView);
            timeTextView = (TextView) itemView.findViewById(R.id.timeTextView);
            messageTextView = (TextView) itemView.findViewById(R.id.messageTextView);
        }
    }
}