package com.example.mrpeter1.sounddemoudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
   Button btnplay, btnpause;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

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
        audioManager =(AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC); // mengontor agar volume itu sesuai dengan volume saat memutar musik pada handpone
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC); // untuk mengatur volume sesuai dengan seekbar vilume

        mediaPlayer = MediaPlayer.create(this, R.raw.fantasy);
        SeekBar volumeseekbar = (SeekBar) findViewById(R.id.VolumeSeekBar);
        btnplay = findViewById(R.id.btnplay);
        btnpause = findViewById(R.id.btnpause);
        volumeseekbar.setMax(maxVolume); // mengatur volumeseekbar sesuai dengan volume maxVolume
        volumeseekbar.setProgress(currentVolume);

        volumeseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("seekbar changed ", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar scrubSeekBar = findViewById(R.id.scrubSeekBar);
        scrubSeekBar.setMax(mediaPlayer.getDuration());
        scrubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Scrub sneekbar moved", Integer.toString(progress));
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        } ,0,  300);
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
