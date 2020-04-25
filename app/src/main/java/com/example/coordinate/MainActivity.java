package com.example.coordinate;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coordinate.adapter.MyAdapter;
import com.example.coordinate.util.DataUtil;

/**
 * 参考：
 * https://nanchen2251.github.io/2017/07/20/%E4%B8%80%E6%96%87%E5%BD%BB%E5%BA%95%E6%90%9E%E6%87%82-CoordinatorLayout-%E5%92%8C-AppbarLayout-%E8%81%94%E5%8A%A8%EF%BC%8C%E8%AE%A9-Design-%E8%AE%BE%E8%AE%A1%E6%9B%B4%E7%AE%80%E5%8D%95/
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtn;
    private RecyclerView mRv;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mBtn = findViewById(R.id.btn);
        mRv = findViewById(R.id.rv);

        mAdapter = new MyAdapter(this);
        mAdapter.setData(DataUtil.getData());
        mRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRv.setAdapter(mAdapter);

        mBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    v.setX(event.getRawX() - v.getWidth() / 2);
                    v.setY(event.getRawY() - v.getHeight() / 2);
                }
                return true;
            }
        });
    }
}
