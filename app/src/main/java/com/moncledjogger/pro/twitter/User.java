package com.moncledjogger.pro.twitter;

/**
 * Created by user 3 on 07-07-2017.
 */

public class User {
    String name,profile_image_url_https;

    public User(String name, String profile_image_url_https) {
        this.name = name;
        this.profile_image_url_https = profile_image_url_https;
    }

    public String getName() {
        return name;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }
}
