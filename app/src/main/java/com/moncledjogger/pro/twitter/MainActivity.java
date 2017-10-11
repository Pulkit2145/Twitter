package com.moncledjogger.pro.twitter;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static final String BASE_URL = "https://loklak.org/api/search.json?q=";
    String text;


    ArrayList<Status> statusArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final OkHttpClient okHttpClient = new OkHttpClient();
        FloatingActionButton B = (FloatingActionButton) findViewById(R.id.button);

        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView);

        statusArrayList = new ArrayList<>();

        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, statusArrayList);
        recyclerView1.setAdapter(recyclerViewAdapter);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);


        final LinearLayout l = (LinearLayout) getLayoutInflater().inflate(R.layout.design_layout, null);

        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Search Box")
                .setView(l)
                .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        statusArrayList.clear();
                        final EditText editText = (EditText) l.findViewById(R.id.editText2);
                        text = editText.getText().toString();
                        final Request request = new Request.Builder()
                                .url(BASE_URL + "Amitabh").build();

                        okHttpClient.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Request request, IOException e) {                  //Call call
                                Log.e("TAG", "onFailure: " + e.getLocalizedMessage());

                            }

                            @Override
                            public void onResponse(Response response) throws IOException {
                                String result = response.body().string();
                                Log.e("TAG", result);
                                Gson gson = new Gson();
                                final Tweet tweet = gson.fromJson(result, Tweet.class);

                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d("RESPONSE", "run: " + tweet.getStatuses().size());
                                        statusArrayList.addAll(tweet.getStatuses());
                                        recyclerViewAdapter.notifyDataSetChanged();
                                        editText.setText("");
                                    }
                                });

                            }
                        });
                    }
                }).create();

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });


    }
}
