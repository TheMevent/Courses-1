package com.mevent.passwordsgen;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
        Switch numbers = findViewById(R.id.numbers);
        Switch uppercase = findViewById(R.id.uppercase);
        Switch lowercase = findViewById(R.id.lowercase);
        Switch specchars = findViewById(R.id.specchars);

        EditText editText = findViewById(R.id.editText);
        if (editText == null || editText.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Ошибка! Введите длину пароля!", Toast.LENGTH_SHORT).show();
            return;
        }

        Integer count = Integer.parseInt(editText.getText().toString());

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 10; i++){
            String password = GetPassword(count, numbers.isChecked(), uppercase.isChecked(), lowercase.isChecked(), specchars.isChecked());
            if (password == null){
                Toast.makeText(getApplicationContext(), "Ошибка! Проверьте все поля!", Toast.LENGTH_SHORT).show();
                break;
            }
            stringBuilder.append(password + "\n");
        }
        TextView passwords = findViewById(R.id.passwords);
        passwords.setText(stringBuilder.toString());
        passwords.setVisibility(View.VISIBLE);
    }

    public String GetPassword(int length, boolean useNumbers, boolean useUppercase, boolean useLowercase, boolean useSpecchars){
        ArrayList<Character> chars = new ArrayList<Character>();

        if (useNumbers){
            String str = "0123456789";
            for(char c: str.toCharArray()){
                chars.add(c);
            }
        }

        if (useUppercase){
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for(char c: str.toCharArray()){
                chars.add(c);
            }
        }

        if (useLowercase){
            String str = "abcdefghijklmnopqrstuvwxyz";
            for(char c: str.toCharArray()){
                chars.add(c);
            }
        }

        if (useSpecchars){
            String str = "%*)?@#$~";
            for(char c: str.toCharArray()){
                chars.add(c);
            }
        }

        if (chars.size() <= 0){
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        Random rand = new Random();

        for(int i = 0; i < length; i++){
            char c = chars.get(rand.nextInt(chars.size()));
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
