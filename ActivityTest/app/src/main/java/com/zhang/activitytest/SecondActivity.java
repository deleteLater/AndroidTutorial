package com.zhang.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is" + getTaskId());
        setContentView(R.layout.second_activity);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
/*                Intent intent = new Intent();
                intent.putExtra("data_return", "Report to FirstActivity");
                setResult(RESULT_OK, intent);
                finish(); // destroy current activity*/
            }
        });

/*        Intent intent = getIntent();
        Log.d("SecondActivity", intent.getStringExtra("extra_string_data"));*/
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Report to FirstActivity");
        setResult(RESULT_OK, intent);
        finish(); // destroy current activity
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
