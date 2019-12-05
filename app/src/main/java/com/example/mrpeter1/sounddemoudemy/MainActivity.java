package com.example.mrpeter1.sounddemoudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
   Button btnplay, btnpause;
    MediaPlayer mediaPlayer;
    public void play(View view){
        //mediaPlayer = MediaPlayer.create(this, R.raw.fantasy);
        mediaPlayer.start();

    }

    public  void pause(View view){

        //MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fantasy);
        mediaPlayer.pause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.fantasy);
        btnplay = findViewById(R.id.btnplay);
        btnpause = findViewById(R.id.btnpause);
//
//        btnplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fantasy);
//                mediaPlayer.start();
//            }
//        });
//
//        btnpause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fantasy);
//                mediaPlayer.pause();
//            }
//        });


    }
}
