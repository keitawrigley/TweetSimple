package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    public String name;
    public long uId;
    public String screeName;
    public String profileImageUrl;
    public String createdAt;
    public String profileBannerUrl;
    //public int reTweetCount;

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.uId = jsonObject.getLong("id");
        user.screeName = jsonObject.getString("screen_name");
        user.profileImageUrl = jsonObject.getString("profile_image_url_https");
        user.createdAt = jsonObject.getString("created_at");
        user.profileBannerUrl = jsonObject.getString("profile_banner_url");
        //user.reTweetCount = jsonObject.getInt("retweet_count");
        return user;
    }
}
