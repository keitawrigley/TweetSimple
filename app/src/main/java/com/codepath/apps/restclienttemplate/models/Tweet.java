package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {
    public String body;
    public long uId;
    public String createdAt;
    public User user;
    public String reTweetCount;
    public String favoritesCount;
    public String timestamp;
    public String TweetImage;
    //...
    public static Tweet fromJson (JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.uId = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.reTweetCount = jsonObject.getString("retweet_count");
        tweet.favoritesCount = jsonObject.getString("favorite_count");
        if (jsonObject.getJSONObject("entities").has("media")) {
            tweet.TweetImage = jsonObject.getJSONObject("entities").getJSONArray("media").getJSONObject(0).getString("media_url_https");
        }
        else{
            tweet.TweetImage = "";
        }
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public String getTimestamp() {
        //return timestamp;
        return TimeFormatter.getTimeDifference(createdAt);
    }
}
