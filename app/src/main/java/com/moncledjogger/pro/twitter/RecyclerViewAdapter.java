package com.moncledjogger.pro.twitter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by user 3 on 07-07-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Status> statusArrayList;
    Context context;

    public RecyclerViewAdapter(Context context,ArrayList<Status> statusArrayList) {
        this.statusArrayList = statusArrayList;
        this.context = context;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        //ayoutInflater l= LayoutInflater.from(context);
        //View view=l.inflate(R.layout.this_list_item,parent,false);
        //ViewHolder vh= new ViewHolder(view);
        //return vh;
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.this_list_item,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Status status = statusArrayList.get(position);
        holder.t1.setText(status.getText());
        Picasso.with(context).load(status.getUser().getProfile_image_url_https()).resize(50,50).into(holder.i1);



    }

    @Override
    public int getItemCount() {
        if (statusArrayList != null)
            return statusArrayList.size();
        else
            return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView i1;
        TextView t1;
        public ViewHolder(View itemView) {
            super(itemView);
            i1 = (ImageView)itemView.findViewById(R.id.imageView1);
            t1 = (TextView)itemView.findViewById(R.id.textView2);


        }
    }
}
