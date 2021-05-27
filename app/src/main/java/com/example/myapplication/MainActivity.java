package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final String TAG = this.getClass().getSimpleName();
    static int count = 0;
    final int demoCase = 1; // 0: click to switch ; 1: use handler

    @Override // annotation, 註解
    protected void onCreate(Bundle savedInstanceState) { // function, 函式
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count++; // ++: 遞增運算子:等於 count = count + 1;

        Log.d(TAG, "enter onCreate(), #" + count); // 3 + 4 , +:運算子; 3, 4:運算元
    }

    @Override
    protected void onStart() {
        super.onStart();
//        findViewById(android.R.id.content).setOnClickListener(this);
        Log.d(TAG, "enter onStart(), #" + count);

        switch (demoCase) {
            case 0:
                break;
            case 1:
                // 使⽤Handler⾃動切換螢幕畫面
//                Message msg1 = new Message();
                Message msg = myHandler.obtainMessage(); // 從Message pool裡⾯取一個message出來，
                                                         // 比新建立一個有效率。
                                                         // Ctr+Q 查看指令⽂文件
                myHandler.sendMessageDelayed(msg, 500); // 0.5秒後執⾏
//                myHandler.sendEmptyMessageDelayed(0, 500); // 用途等於上面兩行

//                var123(msg);
                break;
        }
    }

//    private void var123(Message msg) {
//        msg.what=1;
//    } // 不能這樣用: 因為message是有期限的，也不能當參數傳遞

    @Override
    protected void onStop() {
        Log.d(TAG, "enter onStop(), #" + count);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "enter onDestroy()");
        count--;
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "enter onPause(), #" + count);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "enter onResume(), #" + count);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "enter onRestart(), #" + count);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case android.R.id.content:
                startActivity(new Intent(this, Bookkeeping.class));

                // 增加過場動畫
                overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);

                // 強制activity終止
                MainActivity.this.finish();
        }
    }

    //  -------------------------------------------------------------------
    // 宣告⼀個Handler物件，並且連結到UI Thread
    private Handler myHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            // 這裡不處理msg內容，所以收到任何msg都是執行Activity切換的工作
            startActivity(new Intent(MainActivity.this, Bookkeeping.class));
            // 增加過場動畫
            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            MainActivity.this.finish();
        }
    };
}
