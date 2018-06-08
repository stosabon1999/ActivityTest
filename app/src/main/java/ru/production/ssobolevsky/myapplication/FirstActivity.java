package ru.production.ssobolevsky.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private static final String VALUE = "default_value";

    private TextView mReceivedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }

    private void init() {
        mReceivedText = findViewById(R.id.tv_received_text);
        mReceivedText.setText(getIntent().getStringExtra(VALUE));
    }

    public static final Intent newIntent(Context context, String text) {
        Intent intent = new Intent(context, FirstActivity.class);
        intent.putExtra(VALUE, text);
        return intent;
    }
}
