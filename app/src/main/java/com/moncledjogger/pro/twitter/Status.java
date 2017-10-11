package com.moncledjogger.pro.twitter;

/**
 * Created by user 3 on 07-07-2017.
 */

class Status {
    String text,link;
    User user;

    public Status(String text, String link, User user, String user_name) {
        this.text = text;
        this.link = link;
        this.user = user;

    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public User getUser() {
        return user;
    }



    public void setText(String text) {
        this.text = text;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
