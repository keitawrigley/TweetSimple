package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {
    private Context context;
    List<Tweet> tweets;
    //...
    // pass in context and list of tweets
    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // for each row, inflate the layout
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        // bind values base on the position of the element
        Tweet tweet = tweets.get(i);
        viewHolder.tvBody.setText(tweet.body);
        viewHolder.tvScreenName.setText(tweet.user.screeName);
        viewHolder.tvName.setText(tweet.user.name);
        viewHolder.tvTimeStamp.setText(tweet.getTimestamp());
        viewHolder.tvReTweetCount.setText(tweet.reTweetCount);
        viewHolder.tvFavoritesCount.setText(tweet.favoritesCount);
        Glide.with(context).load(tweet.user.profileImageUrl).into(viewHolder.ivProfileImage);

        if (!tweet.TweetImage.contentEquals("")){
            Glide.with(context).load(tweet.TweetImage).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(viewHolder.ivTweetImage);
        }
        else {
            viewHolder.ivTweetImage.setImageResource(0);
        }
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // methods to SwipeRefresh container // one to clear when user swipe down and one to add the new elements
    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addTweets(List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }


    // define the view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivProfileImage;
        public TextView tvScreenName;
        public TextView tvBody;
        public TextView tvName;
        public TextView tvTimeStamp;
        //public ImageView ivReTweet;
       // public ImageView ivHeart;
        //public ImageView ivTweetImage;
        public TextView tvReTweetCount;
        public TextView tvFavoritesCount;
        public ImageView ivTweetImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvName = itemView.findViewById(R.id.tvName);
            tvTimeStamp = itemView.findViewById(R.id.tvTimeStamp);
            //ivReTweet = itemView.findViewById(R.id.ivReTweet);
            //ivHeart = itemView.findViewById(R.id.ivHeart);
            //ivTweetImage = itemView.findViewById(R.id.ivTweetImage);
            tvReTweetCount = itemView.findViewById(R.id.tvReTweetCount);
            tvFavoritesCount = itemView.findViewById(R.id.tvFavoritesCount);
            ivTweetImage = itemView.findViewById(R.id.ivTweetImage);
        }
    }
}
