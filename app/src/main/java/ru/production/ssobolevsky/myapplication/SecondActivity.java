package ru.production.ssobolevsky.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private static final String VALUE = "DEFAULT";

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }

    private void init() {
        mEditText = findViewById(R.id.et_input_second);
        mEditText.setText(getIntent().getStringExtra(VALUE));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.VALUE, mEditText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public static final Intent newIntent(Context context, String text) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(VALUE, text);
        return intent;
    }
}
