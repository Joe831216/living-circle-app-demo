package com.test.locationlisttest;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> areaNameList = new ArrayList<>();
    private ArrayList<String> uriList = new ArrayList<>();

    private CustomListView listView;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initAdapter();
        initView();
    }

    private void initData() {
        addArea("祥豐街", "https://goo.gl/maps/Qxx9pUdhQp12");
        addArea("新豐街", "https://goo.gl/maps/oBEyL5EBPwr");
        for (int i = 0; i < 20; i++) {
            addArea("Test", "https://goo.gl/maps/oBEyL5EBPwr");
        }
    }

    private void initAdapter() {
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, areaNameList);
    }

    private void initView() {
        listView = (CustomListView) findViewById(R.id.listView);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriList.get(position)));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                } else {
                    startActivity(mapIntent);
                }
            }
        });
    }

    private void addArea(String name, String uri) {
        areaNameList.add(name);
        uriList.add(uri);
    }

}
