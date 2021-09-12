package com.example.android.mediaplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MohammadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getString(R.string.ياللي_عالم_بينا), getString(R.string.محمد_حمائي), R.raw.asala));
        songs.add(new Song(getString(R.string.ده_وقته), getString(R.string.محمد_حمائي), R.raw.asala));
        songs.add(new Song(getString(R.string.حياتك_في_صوره), getString(R.string.محمد_حمائي), R.raw.asala));
        songs.add(new Song(getString(R.string.على_قد_الشوق), getString(R.string.محمد_حمائي), R.raw.asala));
        songs.add(new Song(getString(R.string.تعرف_بحبك_ليه), getString(R.string.محمد_حمائي), R.raw.asala));
        songs.add(new Song(getString(R.string.انت_عظيم), getString(R.string.محمد_حمائي), R.raw.asala));
        songs.add(new Song(getString(R.string.قدام_الناس), getString(R.string.محمد_حمائي), R.raw.asala));
        songs.add(new Song(getString(R.string.كفايه_حلول_وسط), getString(R.string.محمد_حمائي), R.raw.asala));

        //find the home page button id and set onClickListener to this button to start intent
        Button homePage = (Button) findViewById(R.id.homePage);
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to move from Mohammad Activity to Main activity
                Intent homePageIntent = new Intent(MohammadActivity.this, MainActivity.class);
                startActivity(homePageIntent);
            }
        });


        SongAdapter adapter = new SongAdapter(this, songs);
        //find the listView by ID
        ListView listView = (ListView) findViewById(R.id.list);
        //set on item click listener on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //intent to move from Mohammad Activity to play now activity
                Intent playIntent = new Intent(MohammadActivity.this, PlayNowActivity.class);
                //get the position of all array elements
                Song clickedSong = songs.get(position);
                //put the positin to get the mSongResourceId
                playIntent.putExtra(getString(R.string.SONG), clickedSong.getmSongResourceId());
                //start intent
                startActivity(playIntent);
            }
        });
        //set the adapter on list view
        listView.setAdapter(adapter);
    }
}
