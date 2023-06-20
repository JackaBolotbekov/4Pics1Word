package com.example.a4pics1word;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private Button word1, word2, word3, word4;
    private String word1_text, word2_text, word3_text, word4_text;
    private Button l1, l2, l3, l4, l5;
    private Button w1, w2, w3, w4, w5, clear;
    private String l1_text, l2_text, l3_text, l4_text, l5_text;
    private String w1_text, w2_text, w3_text, w4_text, w5_text;
    private Vibrator vibrator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initialize();
        setUpListener();
        clearListener();
    }

    private void initialize() {
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        word1 = (Button) findViewById(R.id.first_letter);
        word2 = (Button) findViewById(R.id.second_letter);
        word3 = (Button) findViewById(R.id.third_letter);
        word4 = (Button) findViewById(R.id.fourth_letter);
        l1 = (Button) findViewById(R.id.l_1);
        l2 = (Button) findViewById(R.id.l_2);
        l3 = (Button) findViewById(R.id.l_3);
        l4 = (Button) findViewById(R.id.l_4);
        l5 = (Button) findViewById(R.id.l_5);
        w1 = (Button) findViewById(R.id.w_1);
        w2 = (Button) findViewById(R.id.w_2);
        w3 = (Button) findViewById(R.id.w_3);
        w4 = (Button) findViewById(R.id.w_4);
        w5 = (Button) findViewById(R.id.w_5);
        clear = (Button) findViewById(R.id.btn_clear);
        l1_text = l1.getText().toString();
        l2_text = l2.getText().toString();
        l3_text = l3.getText().toString();
        l4_text = l4.getText().toString();
        l5_text = l5.getText().toString();
        w1_text = w1.getText().toString();
        w2_text = w2.getText().toString();
        w3_text = w3.getText().toString();
        w4_text = w4.getText().toString();
        w5_text = w5.getText().toString();
    }

    private void setUpListener() {
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1_text = l1.getText().toString();
                if (!l1_text.equals("")) {
                    examination(l1, l1_text);
                }
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l2_text = l2.getText().toString();
                if (!l2_text.equals("")) {
                    examination(l2, l2_text);
                }
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l3_text = l3.getText().toString();
                if (!l3_text.equals("")) {
                    examination(l3, l3_text);
                }
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l4_text = l4.getText().toString();
                if (!l4_text.equals("")) {
                    examination(l4, l4_text);
                }
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l5_text = l5.getText().toString();
                if (!l5_text.equals("")) {
                    examination(l5, l5_text);
                }
            }
        });
        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w1_text = w1.getText().toString();
                if (!w1_text.equals("")) {
                    examination(w1, w1_text);
                }
            }
        });
        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w2_text = w2.getText().toString();
                if (!w2_text.equals("")) {
                    examination(w2, w2_text);
                }
            }
        });
        w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w3_text = w3.getText().toString();
                if (!w3_text.equals("")) {
                    examination(w3, w3_text);
                }
            }
        });
        w4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w4_text = w4.getText().toString();
                if (!w4_text.equals("")) {
                    examination(w4, w4_text);
                }
            }
        });
        w5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w5_text = w5.getText().toString();
                if (!w5_text.equals("")) {
                    examination(w5, w5_text);
                }
            }
        });
    }

    private void examination(Button l, String text) {
        if (word1.getText() == "") {
            word1.setText(text);
            l.setText("");
        } else if (word2.getText() == "") {
            word2.setText(text);
            l.setText("");
        } else if (word3.getText() == "") {
            word3.setText(text);
            l.setText("");
        } else if (word4.getText() == "") {
            word4.setText(text);
            l.setText("");
            word4_text = word4.getText().toString();
            word3_text = word3.getText().toString();
            word2_text = word2.getText().toString();
            word1_text = word1.getText().toString();
            String finalWord = word1_text + word2_text + word3_text + word4_text;
            if (finalWord.equals("вода")) {
                Toast.makeText(this, "ВЕРНО", Toast.LENGTH_SHORT).show();
            } else {
                startVibratingAnimation();
                Toast.makeText(this, "неправильно", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void clearListener() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word4.getText() != "") {
                    word4_text = word4.getText().toString();
                    switchCase(word4_text);
                    word4.setText("");
                    clearAnim();
                } else if (word3.getText() != "") {
                    word3_text = word3.getText().toString();
                    switchCase(word3_text);
                    word3.setText("");
                } else if (word2.getText() != "") {
                    word2_text = word2.getText().toString();
                    switchCase(word2_text);
                    word2.setText("");
                } else if (word1.getText() != "") {
                    word1_text = word1.getText().toString();
                    switchCase(word1_text);
                    word1.setText("");
                } else {
                    Toast.makeText(GameActivity.this, "нечего очищять!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startVibratingAnimation() {
        // Создание анимации
        Animation animation = new TranslateAnimation(0, 10, 0, 0);
        animation.setDuration(50);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(5);
        // Установка анимации на текстовое поле
        word1.setTextColor(Color.RED);
        word2.setTextColor(Color.RED);
        word3.setTextColor(Color.RED);
        word4.setTextColor(Color.RED);
        word1.startAnimation(animation);
        word2.startAnimation(animation);
        word3.startAnimation(animation);
        word4.startAnimation(animation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearAnim();
    }

    private void clearAnim() {
        vibrator.cancel();
        word1.clearAnimation();
        word1.setTextColor(Color.WHITE);
        word2.setTextColor(Color.WHITE);
        word3.setTextColor(Color.WHITE);
        word4.setTextColor(Color.WHITE);
    }

    private void switchCase(String value) {
        switch (value) {
            case "а":
                l1.setText("а");
                break;
            case "б":
                l2.setText("б");
                break;
            case "в":
                l3.setText("в");
                break;
            case "г":
                l4.setText("г");
                break;
            case "д":
                l5.setText("д");
                break;
            case "и":
                w1.setText("и");
                break;
            case "к":
                w2.setText("к");
                break;
            case "о":
                w3.setText("о");
                break;
            case "ж":
                w4.setText("ж");
                break;
            case "е":
                w5.setText("е");
                break;
        }
    }
}