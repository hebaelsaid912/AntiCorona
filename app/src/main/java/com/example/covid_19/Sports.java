package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Sports extends  YouTubeBaseActivity {
    YouTubePlayerView playerView;
    VideoView vid;
    Button playerbtn;
    YouTubePlayer.OnInitializedListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        playerbtn = (Button) findViewById(R.id.player);
        playerView = (YouTubePlayerView) findViewById(R.id.videoView);
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("Ezm11Oxc7FA");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        playerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerView.initialize(YoutubeConfig.getApiKey(),listener);
            }
        });
    }
    public void backHome(View v){
        Intent i = new Intent(this,Home.class);
        startActivity(i);
    }
}
