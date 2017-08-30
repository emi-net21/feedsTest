package emiliano.emilianotest.feeds.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.format.DateTimeFormatter;
import java.util.List;

import emiliano.emilianotest.R;
import twitter4j.Status;

public class FeedsRVAdapter extends RecyclerView.Adapter<FeedsRVAdapter.ViewHolder>  {

    private final Context context;
    private final List<Status> feeds;

    public FeedsRVAdapter(final Context context, final List<Status> feeds) {
        this.context = context;
        this.feeds = feeds;
    }

    @Override
    public FeedsRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_feeds, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FeedsRVAdapter.ViewHolder holder, int position) {
        Status tweet = feeds.get(position);
        holder.tvMessage.setText(tweet.getText());
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView ivAvatar;
        protected TextView tvName;
        protected TextView tvLogin;
        protected TextView tvDate;
        protected TextView tvMessage;

        public ViewHolder(final View itemView) {
            super(itemView);
//            ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
//            tvName = (TextView) itemView.findViewById(R.id.tv_name);
//            tvLogin = (TextView) itemView.findViewById(R.id.tv_login);
//            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvMessage = (TextView) itemView.findViewById(R.id.tv_message);
        }
    }
}
