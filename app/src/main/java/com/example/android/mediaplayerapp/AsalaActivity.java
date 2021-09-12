package com.example.android.mediaplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AsalaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs);

        AsalaActivity asalaActivity = new AsalaActivity();


        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getString(R.string.خانات_الذكريات), getString(R.string.أصاله), R.raw.asala));
        songs.add(new Song(getString(R.string.ذاك_الغبي), getString(R.string.أصاله), R.raw.asala));
        songs.add(new Song(getString(R.string.حضرة_الموقف), getString(R.string.أصاله), R.raw.asala));
        songs.add(new Song(getString(R.string.بعدك_عني), getString(R.string.أصاله), R.raw.asala));
        songs.add(new Song(getString(R.string.مبقاش_سر), getString(R.string.أصاله), R.raw.asala));
        songs.add(new Song(getString(R.string.سابوك), getString(R.string.أصاله), R.raw.asala));
        songs.add(new Song(getString(R.string.الفرق_الكبير), getString(R.string.أصاله), R.raw.asala));
        songs.add(new Song(getString(R.string.سامحتك_كتير), getString(R.string.أصاله), R.raw.asala));

        //find the home page button id and set onClickListener to this button to start intent
        Button homePage = (Button) findViewById(R.id.homePage);
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to move from Asala Activity to Main activity
                Intent homePageIntent = new Intent(AsalaActivity.this, MainActivity.class);
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
                //intent to move from Asala Activity to play now activity
                Intent playIntent = new Intent(AsalaActivity.this, PlayNowActivity.class);
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
