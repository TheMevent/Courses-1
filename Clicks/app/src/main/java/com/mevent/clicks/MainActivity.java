package com.mevent.clicks;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view)
    {
        TextView text = (TextView) findViewById(R.id.textView);
        Integer count = Integer.parseInt(text.getText().toString());
        count++;
        text.setText(count.toString());
    }
}
