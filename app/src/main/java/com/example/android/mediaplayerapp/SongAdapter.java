package com.example.android.mediaplayerapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews , the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_list, parent, false);
        }
        // Get the {@link Song} object located at this position in the list
        Song currentWord = getItem(position);

        // Find the TextView in the songs_list.xml layout with the ID songNameView
        TextView songTextView = (TextView) convertView.findViewById(R.id.songNameView);
        // Get the song name from the current song object and
        // set this text on the name TextView
        songTextView.setText(currentWord.getmSongName());

        // Find the TextView in the song_list.xml layout with the ID artistName
        TextView artistTextView = (TextView) convertView.findViewById(R.id.artistName);
        // Get the artist name from the current song object and
        // set this text on the name TextView
        artistTextView.setText(currentWord.getmArtistName());


        return convertView;
    }
}
