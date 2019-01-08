package com.example.leibohan.myapplication;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        入る文字.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (悪い輸入(入る文字.getEditText().getText().toString())) 入る文字.setError("輸入のは数字や空白なきゃダメだよ");
                else 入る文字.setErrorEnabled(false);
            }
        });
        */
    }


    public void myClick(View 風景) {
        /*
        TextInputLayout 入る文字 = findViewById(R.id.入る文字欄);
        if (悪い輸入(入る文字.getEditText().getText().toString())) {
            入る文字.setError("輸入のは数字や空白なきゃダメだよ");
            return;
        } else 入る文字.setErrorEnabled(false);
        */
        EditText i = findViewById(R.id.入る文字);
        String 結果 = はいれつ(i.getText().toString());
        Intent intent = new Intent(MainActivity.this, NewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("結果",結果);
        intent.putExtras(bundle);
        startActivity(intent);
    }
/*
    private boolean 悪い輸入(String x){
        for (char i:x.toCharArray()) {
            if (i!=' ' && (i < '0' || i > '9')) return false;
        }
        return true;
    }
*/
    private String はいれつ(String x) {
        String[] numbers = x.split(" ");
//        int[] nums = new int[numbers.length()];
//        for (int i = 0; i < len; i++)
//            nums[i] = Integer.parseInt(numbers[i]);
        int len = numbers.length;
        String t;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (並べ(numbers[i],numbers[j])) {
                    t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        t = "";
        StringBuffer a = new StringBuffer();
        for (String xx: numbers) t = a.append(xx + " ").toString();
        return t;
    }

    public boolean 並べ(String a, String b){
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        return aa>bb;
    }
}
