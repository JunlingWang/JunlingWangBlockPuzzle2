package com.example.junlingwang.junlingwangblockpuzzle2;

import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pictureList extends AppCompatActivity {
    public ImageButton imageButtonLeftTop;
    public ImageButton imageButtonRightTop;
    public ImageButton imageButtonLeftBottom;
    public ImageButton imageButtonRightBottom;
    public String imageCodeLeftTop;
    public String imageCodeRightTop;
    public String imageCodeLeftBottom;
    public String imageCodeRightBottom;
    public String currentPictureName;
    public String POSITION_CODE_LEFT_TOP = "0";
    public String POSITION_CODE_RIGHT_TOP = "1";
    public String POSITION_CODE_LEFT_BOTTOM = "2";
    public String POSITION_CODE_RIGHT_BOTTOM = "3";
    public String themeCode = "0";
    SoundPool pool;
    boolean soundReady;
    int wolfSoundID;
    int birdSoundID;
    int pigSoundID;
    int tigerSoundID;
    int balloonSoundID;
    int carSoundID;
    int planeSoundID;
    int ufoSoundID;
    int atomSoundID;
    int dnaSoundID;
    int galaxySoundID;
    int spiralSoundID;
    int cheeringID;
    public Database records;

    public List<String> pictureNames = new ArrayList<>(
            Arrays.asList(
                    "p000wolf", "p001wolf", "p002wolf", "p003wolf",
                    "p010bird", "p011bird", "p012bird", "p013bird",
                    "p020pig", "p021pig", "p022pig", "p023pig",
                    "p030tiger", "p031tiger", "p032tiger", "p033tiger",
                    "p100balloon", "p101balloon", "p102balloon", "p103balloon",
                    "p110car", "p111car", "p112car", "p113car",
                    "p120plane", "p121plane", "p122plane", "p123plane",
                    "p130ufo", "p131ufo", "p132ufo", "p133ufo",
                    "p200atom", "p201atom", "p202atom", "p203atom",
                    "p210dna", "p211dna", "p212dna", "p213dna",
                    "p220galaxy", "p221galaxy", "p222galaxy", "p223galaxy",
                    "p230spiral", "p231spiral", "p232spiral", "p233spiral",
                    "w_bird"
                    //The name of each picture consists of information about
                    // its position, content and the theme it belongs
            ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public List createList (){
        return pictureNames;
    }
}
