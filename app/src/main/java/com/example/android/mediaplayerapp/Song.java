package com.example.android.mediaplayerapp;

public class Song {
    private String mSongName;
    private int mSongResourceId;
    private String mArtistName;

    //constructor for song class
    public Song(String songName, String artistName, int songResourceId) {
        mSongName = songName;
        mArtistName = artistName;
        mSongResourceId = songResourceId;
    }

    //get string mSongName
    public String getmSongName() {
        return mSongName;
    }

    //get string mArtistName
    public String getmArtistName() {
        return mArtistName;
    }

    //get int mSongResourceId
    public int getmSongResourceId() {
        return mSongResourceId;
    }
}
