package com.example.junlingwang.junlingwangblockpuzzle2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public ImageButton imageButtonLeftTop;
    public ImageButton imageButtonRightTop;
    public ImageButton imageButtonLeftBottom;
    public ImageButton imageButtonRightBottom;
    private String imageCodeLeftTop;
    private String imageCodeRightTop;
    private String imageCodeLeftBottom;
    private String imageCodeRightBottom;
    private String currentPictureName;
    private String POSITION_CODE_LEFT_TOP = "0";
    private String POSITION_CODE_RIGHT_TOP = "1";
    private String POSITION_CODE_LEFT_BOTTOM = "2";
    private String POSITION_CODE_RIGHT_BOTTOM = "3";
    public String themeCode = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        imageButtonLeftTop = (ImageButton) findViewById(R.id.imageButtonLeftTop);
        imageButtonRightTop = (ImageButton) findViewById(R.id.imageButtonRightTop);
        imageButtonLeftBottom = (ImageButton) findViewById(R.id.imageButtonLeftBottom);
        imageButtonRightBottom = (ImageButton) findViewById(R.id.imageButtonRightBottom);
        setImage(themeCode + "00");
        setImage(themeCode + "01");
        setImage(themeCode + "02");
        setImage(themeCode + "03");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setImage(String imageCode){
        String pictureToSet = "w_bird";
        List<String> pictureNames = new ArrayList<>(
                Arrays.asList(
                        "p000wolf", "p001wolf", "p002wolf", "p003wolf",
                        "p010bird", "p011bird", "p012bird","p013bird",
                        "p020pig", "p021pig", "p022pig","p023pig",
                        "p030tiger", "p031tiger", "p032tiger","p033tiger",
                        "p100balloon", "p101balloon", "p102balloon","p103balloon",
                        "p110car", "p111car", "p112car","p113car",
                        "p120plane", "p121plane", "p122plane","p123plane",
                        "p130ufo", "p131ufo", "p132ufo","p133ufo",
                        "p200atom", "p201atom", "p202atom","p203atom",
                        "p210dna", "p211dna", "p212dna","p213dna",
                        "p220galaxy", "p221galaxy", "p222galaxy","p223galaxy",
                        "p230spiral", "p231spiral", "p232spiral","p233spiral",
                        "w_bird"
                        )
        );
        for (int i=0; i<pictureNames.size(); i++){
            if(pictureNames.get(i).contains(imageCode)){
                pictureToSet = pictureNames.get(i);
                currentPictureName = pictureToSet.substring(3);
            }
        }

        int id = getResources()
                .getIdentifier(pictureToSet, "drawable", getPackageName());
        //int id = this.getResources().getIdentifier("p230spiral", "raw", this.getPackageName());
        if (Character.toString(imageCode.charAt(2)).equals(POSITION_CODE_LEFT_TOP)) {
            imageButtonLeftTop.setImageResource(id);
        }
        if (Character.toString(imageCode.charAt(2)).equals(POSITION_CODE_RIGHT_TOP)) {
            imageButtonRightTop.setImageResource(id);
        }
        if (Character.toString(imageCode.charAt(2)).equals(POSITION_CODE_LEFT_BOTTOM)) {
            imageButtonLeftBottom.setImageResource(id);
        }
        if (Character.toString(imageCode.charAt(2)).equals(POSITION_CODE_RIGHT_BOTTOM)) {
            imageButtonRightBottom.setImageResource(id);
        }
    }

    private void mixPictures(){
        List<String> pictureNumbers = new ArrayList<>(Arrays.asList("0","1","2","3"));
        Random rand = new Random();
        int  index = rand.nextInt(4);
        String pictureNum = pictureNumbers.get(index);
        setImage(themeCode + pictureNum + POSITION_CODE_LEFT_TOP);
        pictureNumbers.remove(pictureNum);
        index = rand.nextInt(3);
        pictureNum = pictureNumbers.get(index);
        setImage(themeCode + pictureNum + POSITION_CODE_RIGHT_TOP);
        pictureNumbers.remove(pictureNum);
        index = rand.nextInt(2);
        pictureNum = pictureNumbers.get(index);
        setImage(themeCode + pictureNum + POSITION_CODE_LEFT_BOTTOM);
        pictureNumbers.remove(pictureNum);
        pictureNum = pictureNumbers.get(0);
        setImage(themeCode + pictureNum + POSITION_CODE_RIGHT_BOTTOM);
    }

    public void startGame (View view){
        mixPictures();
    }

    //Choosing theme
    public void goToSettings (View view) {
        Intent intent = new Intent(this, themeChoosing.class); // imported
//        startActivity(intent);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1 && resultCode == RESULT_OK) {
            themeCode = data.getStringExtra("MESSAGE");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
