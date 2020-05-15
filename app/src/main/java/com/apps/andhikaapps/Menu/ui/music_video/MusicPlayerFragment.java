package com.apps.andhikaapps.Menu.ui.music_video;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.apps.andhikaapps.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    13 May 2020
 */

public class MusicPlayerFragment extends Fragment {

    private Button btn_next, btn_previous, btn_pause;
    private TextView songTextLabel;
    private SeekBar songSeekbar;
    private Toolbar toolbar;
    private static MediaPlayer myMediaPlayer;
    private int position;
    private String sName;
    private ArrayList<File> mySongs;
    private Thread updateSeekbar;
    private static String SONGS = "songs";
    private static String SONGNAME = "songname";
    private static String POS = "pos";

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View root = inflater.inflate(R.layout.fragment_music_player, container, false);

        btn_next = root.findViewById(R.id.next);
        btn_previous = root.findViewById(R.id.previous);
        btn_pause = root.findViewById(R.id.pause);
        songTextLabel = root.findViewById(R.id.txtSongLabel);
        songSeekbar = root.findViewById(R.id.songSeekBar);
        toolbar = root.findViewById(R.id.toolbarmusicplayer);

        toolbar.setTitle("Now Playing");
        requireActivity().setActionBar(toolbar);
        Objects.requireNonNull(requireActivity().getActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(requireActivity().getActionBar()).setHomeButtonEnabled(true);
        setHasOptionsMenu(true);

        updateSeekbar = new Thread(){
            @Override
            public void run() {

                int totalDuration = myMediaPlayer.getDuration();
                int currentPosition = 0;

                while (currentPosition < totalDuration){
                    try {
                        sleep(300);
                        currentPosition = myMediaPlayer.getCurrentPosition();
                        songSeekbar.setProgress(currentPosition);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        if (myMediaPlayer != null){
            myMediaPlayer.stop();
            myMediaPlayer.release();
        }

        Bundle bundle = this.getArguments();
        assert bundle != null;
        String songName = bundle.getString(SONGNAME);
        position = bundle.getInt(POS,0);

        mySongs = (ArrayList) bundle.getParcelableArrayList(SONGS);

        assert mySongs != null;
        sName = mySongs.get(position).getName();

        songTextLabel.setText(songName);
        songTextLabel.setSelected(true);

        Uri u = Uri.parse(mySongs.get(position).toString());

        myMediaPlayer = MediaPlayer.create(requireActivity().getApplicationContext(), u);
        songSeekbar.setMax(myMediaPlayer.getDuration());

        updateSeekbar.start();

        songSeekbar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
        songSeekbar.getThumb().setColorFilter(getResources().getColor(R.color.colorPrimary),PorterDuff.Mode.SRC_IN);

        songSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                myMediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                songSeekbar.setMax(myMediaPlayer.getDuration());

                if (myMediaPlayer.isPlaying()){

                    btn_pause.setBackgroundResource(R.drawable.ic_play_arrow_black_24dp);
                    myMediaPlayer.pause();
                }else {
                    btn_pause.setBackgroundResource(R.drawable.pause);
                    myMediaPlayer.start();
                }
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMediaPlayer.stop();
                myMediaPlayer.release();
                position = ((position+1)%mySongs.size());

                Uri u = Uri.parse(mySongs.get(position).toString());

                myMediaPlayer = MediaPlayer.create(requireActivity().getApplicationContext(), u);

                sName = mySongs.get(position).getName();
                songTextLabel.setText(sName);

                myMediaPlayer.start();
            }
        });

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myMediaPlayer.stop();
                myMediaPlayer.release();

                position = ((position-1)<0)?(mySongs.size()-1):(position-1);
                Uri u = Uri.parse(mySongs.get(position).toString());
                myMediaPlayer = MediaPlayer.create(requireActivity().getApplicationContext(),u);

                sName = mySongs.get(position).getName();
                songTextLabel.setText(sName);

                myMediaPlayer.start();
            }
        });

        return root;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            requireActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
