package com.moncledjogger.pro.twitter;

import java.util.ArrayList;

/**
 * Created by user 3 on 07-07-2017.
 */

public class Tweet {
    ArrayList<Status> statuses;

    public Tweet(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Status> getStatuses() {
        return statuses;
    }
}
