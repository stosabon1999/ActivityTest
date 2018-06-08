package ru.production.ssobolevsky.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String VALUE = "DEFAULT";

    public static final int REQUEST_CODE = 1001;

    private EditText mInputText;

    private Button mFirstScreen;

    private Button mSecondScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListeners();
    }

    private void init() {
        mInputText = findViewById(R.id.et_input);
        mFirstScreen = findViewById(R.id.b_first_screen);
        mSecondScreen = findViewById(R.id.b_second_screen);
    }

    private void initListeners() {
        mFirstScreen.setOnClickListener(new FirstButtonClickListener());
        mSecondScreen.setOnClickListener(new SecondButtonClickListener());
    }

    private class FirstButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            startActivity(FirstActivity.newIntent(MainActivity.this, mInputText.getText().toString()));
        }
    }

    private class SecondButtonClickListener implements  View.OnClickListener {

        @Override
        public void onClick(View view) {
            startActivityForResult(SecondActivity.newIntent(MainActivity.this, mInputText.getText().toString()), REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null && requestCode == REQUEST_CODE) {
            mInputText.setText(data.getStringExtra(VALUE));
        }
    }
}
