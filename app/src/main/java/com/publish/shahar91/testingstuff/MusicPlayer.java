package com.publish.shahar91.testingstuff;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MusicPlayer extends AppCompatActivity {

    private Button playBtn, pauseBtn;
    private SeekBar volumeSB, lengthSB;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.music_player);

        volumeSB = (SeekBar) findViewById(R.id.volumeSB);
        lengthSB = (SeekBar) findViewById(R.id.lengthSB);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        playBtn = (Button) findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MusicPlayer.this, "Playing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MusicPlayer.this, "I'm done", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        pauseBtn = (Button) findViewById(R.id.pauseBtn);
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MusicPlayer.this, "Pausing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });

    }
}
