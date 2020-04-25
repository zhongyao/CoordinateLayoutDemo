package com.example.coordinate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coordinate.adapter.MyAdapter;
import com.example.coordinate.util.DataUtil;

public class SecondActivity extends AppCompatActivity {


    private RecyclerView mRv;
    private MyAdapter mAdapter;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    private void initView() {
        mRv = findViewById(R.id.rv);
        mToolbar = findViewById(R.id.toolbar);
        initToolBar(mToolbar, false, "");

        mAdapter = new MyAdapter(this);
        mAdapter.setData(DataUtil.getData());
        mRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRv.setAdapter(mAdapter);
    }

    /** 初始化 Toolbar */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

}
