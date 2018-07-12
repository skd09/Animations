package com.sharvari.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sharvari on 12-Jul-18.
 */

public class MainActivity2  extends AppCompatActivity {

    private List<colorLayout> colorLayoutList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ColorAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ColorAdapter(this, colorLayoutList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    private void prepareData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            colorLayout layout = new colorLayout(generateColor(r));
            colorLayoutList.add(layout);
        }

        mAdapter.notifyDataSetChanged();
    }

    private static String generateColor(Random r) {
        StringBuilder color = new StringBuilder(Integer.toHexString(r
                .nextInt(16777215)));
        while (color.length() < 6) {
            color.append("0");
        }

        return color.append("#").reverse().toString();

    }
}
