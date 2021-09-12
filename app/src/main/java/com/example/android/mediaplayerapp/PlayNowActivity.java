package com.example.android.mediaplayerapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayNowActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }

                }
            };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_song);

        //find the home page button id and set onClickListener to this button to start intent
        Button homePage = (Button) findViewById(R.id.homePage);
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to move from Play now Activity to Main activity
                Intent homePageIntent = new Intent(PlayNowActivity.this, MainActivity.class);
                startActivity(homePageIntent);
            }
        });

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        releaseMediaPlayer();
        //get the extra from other activity
        Bundle bundle = getIntent().getExtras();
        //get the song resource id
        int song = bundle.getInt(getString(R.string.SONG));
        int result = mAudioManager.requestAudioFocus(mOnAudioChangeListener,
                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (mMediaPlayer == null) {
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                mMediaPlayer = MediaPlayer.create(PlayNowActivity.this, song);

                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        }


        //button to play music or stop music
        ImageView playNow = (ImageView) findViewById(R.id.play);
        playNow.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                //TODO rite the code to play music or stop music
                //when press button replace the pause button to play button

                if (mMediaPlayer.isPlaying()) {
                    playNow.setImageResource(R.drawable.play_music);
                    mMediaPlayer.pause();
                } else {
                    playNow.setImageResource(R.drawable.pause);
                    mMediaPlayer.start();
                }

            }


        });


        //button to move to the previous song
        ImageView previousSong = (ImageView) findViewById(R.id.previous_song);
        previousSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO rite the code to move to previous song

            }
        });

        //button to move to the next song
        ImageView nextSong = (ImageView) findViewById(R.id.next_song);
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO rite code to move to the next song
            }
        });

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioChangeListener);

        }
    }

    //when user leave the play now activity stop song
    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }


}

