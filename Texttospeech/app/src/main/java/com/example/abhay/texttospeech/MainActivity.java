package com.example.abhay.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
EditText e1;Button b1;
    TextToSpeech tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        tx=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                tx.setLanguage(Locale.ENGLISH);
                tx.setSpeechRate(0.7f);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                tx.speak(s1,TextToSpeech.QUEUE_FLUSH,null);
            }
            });
        }
}







