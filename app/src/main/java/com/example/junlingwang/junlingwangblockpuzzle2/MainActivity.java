package com.example.junlingwang.junlingwangblockpuzzle2;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

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
    private Database records;

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

        pool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleID, int status) {
                if (status != 0) {
                    Log.e("soundPoolDemo", "failed to load sound");
                    return;
                }
                Log.e("soundPoolDemo", "loaded" + sampleID);
                soundReady = true;

            }
        });
        //airhronID = pool.load(this, R.raw.airhorn, 1);
        //ufoID = pool.load(this, R.raw.ufo, 1);
        //kidID = pool.load(this, R.raw.kidlaugh, 1);
        wolfSoundID = pool.load(this, R.raw.a00wolf, 1);
        birdSoundID = pool.load(this, R.raw.a01bird, 1);
        pigSoundID = pool.load(this, R.raw.a02pig, 1);
        tigerSoundID = pool.load(this, R.raw.a03tiger, 1);
        balloonSoundID = pool.load(this, R.raw.a10balloon, 1);
        carSoundID = pool.load(this, R.raw.a11car, 1);
        planeSoundID = pool.load(this, R.raw.a12plane, 1);
        ufoSoundID = pool.load(this, R.raw.a13ufo, 1);
        atomSoundID = pool.load(this, R.raw.a20atom, 1);
        dnaSoundID = pool.load(this, R.raw.a21dna, 1);
        galaxySoundID = pool.load(this, R.raw.a22galaxy, 1);
        spiralSoundID = pool.load(this, R.raw.a23spiral, 1);
        cheeringID = pool.load(this, R.raw.cheering, 1);
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
                currentPictureName = pictureToSet.substring(4);
            }
        }

        int id = getResources()
                .getIdentifier(pictureToSet, "drawable", getPackageName());
        //int id = this.getResources().getIdentifier("p230spiral", "raw", this.getPackageName());
        if (Character.toString(imageCode.charAt(2)).equals(POSITION_CODE_LEFT_TOP)) {
            imageButtonLeftTop.setImageResource(id);
            imageCodeLeftTop = imageCode;
        }
        if (Character.toString(imageCode.charAt(2)).equals(POSITION_CODE_RIGHT_TOP)) {
            imageButtonRightTop.setImageResource(id);
            imageCodeRightTop = imageCode;
        }
        if (Character.toString(imageCode.charAt(2)).equals(POSITION_CODE_LEFT_BOTTOM)) {
            imageButtonLeftBottom.setImageResource(id);
            imageCodeLeftBottom = imageCode;
        }
        if (Character.toString(imageCode.charAt(2)).equals(POSITION_CODE_RIGHT_BOTTOM)) {
            imageButtonRightBottom.setImageResource(id);
            imageCodeRightBottom = imageCode;
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

    public void changeImageLeftTop (View view) {
        changeImage(imageCodeLeftTop);
        evaluate();
    }

    public void changeImageRightTop (View view) {
        changeImage(imageCodeRightTop);
        evaluate();
    }

    public void changeImageLeftBottom (View view) {
        changeImage(imageCodeLeftBottom);
        evaluate();
    }

    public void changeImageRightBottom (View view) {
        changeImage(imageCodeRightBottom);
        evaluate();
    }

    private void changeImage(String imageCode) {
        String pictureCode = Character.toString(imageCode.charAt(1));// one digit string
        String positionCode = Character.toString(imageCode.charAt(2));// one digit string
        int pictureNum = Integer.valueOf(pictureCode);
        Random rand = new Random();
        int  index = rand.nextInt(3) + 1;
        int newNumber = (pictureNum + index) % 4;
        setImage(themeCode + newNumber + positionCode);
    }

    private void evaluate() {
        String pictureIDLeftTop = Character.toString(imageCodeLeftTop.charAt(1));
        String pictureIDRightTop = Character.toString(imageCodeRightTop.charAt(1));
        String pictureIDLeftBottom = Character.toString(imageCodeLeftBottom.charAt(1));
        String pictureIDRightBottom = Character.toString(imageCodeRightBottom.charAt(1));
        if (pictureIDLeftBottom.equals(pictureIDLeftTop) &&
                pictureIDLeftTop.equals(pictureIDRightTop) &&
                pictureIDRightTop.equals(pictureIDRightBottom)) {
            Toast.makeText(this, currentPictureName, Toast.LENGTH_LONG).show();
            makeSound();
        }
    }

    private void makeSound() {
        if (soundReady) {
            pool.play(cheeringID, (float) 0.4, (float) 0.4, 1, 0, 1);
            if (currentPictureName.equals("wolf")) {
                pool.play(wolfSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("bird")) {
                pool.play(birdSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("pig")) {
                pool.play(pigSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("tiger")) {
                pool.play(tigerSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("balloon")) {
                pool.play(balloonSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("car")) {
                pool.play(carSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("car")) {
                pool.play(carSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("plane")) {
                pool.play(planeSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("ufo")) {
                pool.play(ufoSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("atom")) {
                pool.play(atomSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("dna")) {
                pool.play(dnaSoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("galaxy")) {
                pool.play(galaxySoundID, 1, 1, 1, 0, 1);
            }else if(currentPictureName.equals("spiral")) {
                pool.play(spiralSoundID, 1, 1, 1, 0, 1);
            }

        }
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
        mixPictures();
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void addData () {
        //String nameString = name.getText().toString();
        //String breedString = breed.getText().toString();
        records = new Database(this); // this statement creates a new object and call the onCreate() method.
        records.add(currentPictureName, "1", "today");
        //Intent go_to = new Intent(this, MainActivity.class);
        //startActivity(go_to);
    }
}
