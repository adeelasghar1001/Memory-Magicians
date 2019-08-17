package adeelasghar.wsu.edu.memorymagicians;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.widget.TextView;


public class ActMain extends AppCompatActivity {


    //region Declarations
    List<Integer> myArray = new ArrayList<Integer>(12);

    ImageButton ib;
    ImageButton ib_0;
    ImageButton ib_1;
    ImageButton ib_2;
    ImageButton ib_3;
    ImageButton ib_4;
    ImageButton ib_5;
    ImageButton ib_6;
    ImageButton ib_7;
    ImageButton ib_8;
    ImageButton ib_9;
    ImageButton ib_10;
    ImageButton ib_11;

    TextView matchCount;
    TextView numtries;

    boolean isRed;
    boolean isBlue;
    boolean isYellow;

    boolean isGreen;
    boolean isOrange;
    boolean isPurple;

    Button reset;

    int tries = 0;
    int counter=0;
    int matchCounter=0;
    int resID2;

    String value1="Red";
    String value2="Green";
    //endregion

    //Main onCreate function========================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //Ensures layout is fullscreen
        setContentView(R.layout.layout_main);

        ImageButton settings = (ImageButton) findViewById(R.id.ib_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActPopupMenu.class);
                intent.putExtra("check_unmatched", value1);
                intent.putExtra("check_matched", value2);
                startActivity(intent);
            }
        });

        matchCount = (TextView) findViewById(R.id.txt_matches);

        matchCount.setText(Integer.toString(matchCounter));

        Bundle extras1 = getIntent().getExtras();
        if (extras1 != null)
        {
            matchCounter = extras1.getInt("score");
            value1 = extras1.getString("unmatched_color");
            value2 = extras1.getString("matched_color");
        }

        matchCount.setText(Integer.toString(matchCounter));

        mainFunction();


        reset = (Button) findViewById(R.id.btn_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
            }
        });
    }


    //Main function that declares a couple objects==================================================
    public void mainFunction(){

        ib_0 = (ImageButton) findViewById(R.id.ib_0);
        ib_1 = (ImageButton) findViewById(R.id.ib_1);
        ib_2 = (ImageButton) findViewById(R.id.ib_2);
        ib_3 = (ImageButton) findViewById(R.id.ib_3);
        ib_4 = (ImageButton) findViewById(R.id.ib_4);
        ib_5 = (ImageButton) findViewById(R.id.ib_5);
        ib_6 = (ImageButton) findViewById(R.id.ib_6);
        ib_7 = (ImageButton) findViewById(R.id.ib_7);
        ib_8 = (ImageButton) findViewById(R.id.ib_8);
        ib_9 = (ImageButton) findViewById(R.id.ib_9);
        ib_10 = (ImageButton) findViewById(R.id.ib_10);
        ib_11 = (ImageButton) findViewById(R.id.ib_11);

        final int images[] =   {R.drawable.pic1, R.drawable.pic2,
                                R.drawable.pic3, R.drawable.pic4,
                                R.drawable.pic5, R.drawable.pic6,

                                R.drawable.pic1, R.drawable.pic2,
                                R.drawable.pic3, R.drawable.pic4,
                                R.drawable.pic5, R.drawable.pic6};

        numtries = (TextView) findViewById(R.id.txt_tries);

        generator();

        //region Buttons
        ib_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_0.setBackgroundResource(images[myArray.get(0)]);
                counter++;
                matchImage(counter,images[myArray.get(0)], ib_0);
            }
        });

        ib_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_1.setBackgroundResource(images[myArray.get(1)]);
                counter++;
                matchImage(counter,images[myArray.get(1)], ib_1);
            }
        });

        ib_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_2.setBackgroundResource(images[myArray.get(2)]);
                counter++;
                matchImage(counter,images[myArray.get(2)], ib_2);
            }
        });

        ib_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_3.setBackgroundResource(images[myArray.get(3)]);
                counter++;
                matchImage(counter,images[myArray.get(3)], ib_3);
            }
        });

        ib_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_4.setBackgroundResource(images[myArray.get(4)]);
                counter++;
                matchImage(counter,images[myArray.get(4)], ib_4);
            }
        });

        ib_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_5.setBackgroundResource(images[myArray.get(5)]);
                counter++;
                matchImage(counter,images[myArray.get(5)], ib_5);
            }
        });

        ib_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_6.setBackgroundResource(images[myArray.get(6)]);
                counter++;
                matchImage(counter,images[myArray.get(6)], ib_6);
            }
        });

        ib_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_7.setBackgroundResource(images[myArray.get(7)]);
                counter++;
                matchImage(counter,images[myArray.get(7)], ib_7);
            }
        });

        ib_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_8.setBackgroundResource(images[myArray.get(8)]);
                counter++;
                matchImage(counter,images[myArray.get(8)], ib_8);
            }
        });

        ib_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_9.setBackgroundResource(images[myArray.get(9)]);
                counter++;
                matchImage(counter,images[myArray.get(9)], ib_9);
            }
        });

        ib_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_10.setBackgroundResource(images[myArray.get(10)]);
                counter++;
                matchImage(counter,images[myArray.get(10)], ib_10);
            }
        });

        ib_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_11.setBackgroundResource(images[myArray.get(11)]);
                counter++;
                matchImage(counter,images[myArray.get(11)], ib_11);
            }
        });
        //endregion

        //region Colors
        Bundle extras1 = getIntent().getExtras();
        if (extras1 != null)
        {
            value1 = extras1.getString("unmatched_color");
            value2 = extras1.getString("matched_color");

            if(value1==null){
                isRed = true;
            }else{
                isRed = value1.contains("Red");
                isBlue = value1.indexOf("Blue") !=-1;
                isYellow = value1.indexOf("Yellow") !=-1;
            }


            if(value2==null){
                isGreen=true;
            }else {
                isGreen = value2.contains("Green");
                isOrange = value2.indexOf("Orange") != -1;
                isPurple = value2.indexOf("Purple") != -1;
            }
            if(isRed)
                changeUnmatchedColor("Red");
            else if(isBlue)
                changeUnmatchedColor("Blue");
            else if(isYellow)
                changeUnmatchedColor("Yellow");

        }
        //endregion

    }


    //Checks if two images pressed match============================================================
    public void matchImage(int c, int resID, final ImageButton ib2){

        //If first button pressed
        if(c==1){
            ib=ib2;
            resID2 = resID;
            ib2.setEnabled(false);
            ib.setEnabled(false);
            return;
        }

        //If two buttons pressed
        else{

            //Correct Answer==================================================================
            if(resID==resID2){
                ib2.setEnabled(false);
                ib.setEnabled(false);
                matchDialog("That's a match!", "Match!");

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {

                        //Change matched to orange
                        if(isOrange){
                            ib2.setBackgroundResource(R.color.orange);
                            ib.setBackgroundResource(R.color.orange);
                        }

                        //Change matched to purple
                        else if(isPurple) {
                            ib2.setBackgroundResource(R.color.purple);
                            ib.setBackgroundResource(R.color.purple);
                        }

                        //Change matched to green
                        else{
                            ib2.setBackgroundResource(R.color.green);
                            ib.setBackgroundResource(R.color.green);
                        }

                        checkEnd();

                    }
                }, 500);   //5 seconds


            }

            //Incorrect Answer==================================================================
            else if (resID!=resID2){
                matchDialog("Try again", "Not a match!");
                Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {

                        //Change back to blue background

                        if(isBlue){
                            ib2.setBackgroundResource(R.color.blue);
                            ib.setBackgroundResource(R.color.blue);
                        }

                        //Change back to yellow background
                        else if(isYellow) {
                            ib2.setBackgroundResource(R.color.yellow);
                            ib.setBackgroundResource(R.color.yellow);
                        }

                        //Change back to red background
                        else{
                            ib2.setBackgroundResource(R.color.red);
                            ib.setBackgroundResource(R.color.red);
                        }

                        ib.setEnabled(true);
                        ib2.setEnabled(true);

                    }
                }, 500);   //5 seconds

            }
            else{
                halfReset(matchCounter);
            }
            tries++;
            numtries.setText(Integer.toString(tries));
            counter=0;
        }


    }


    //Checks if the game has ended==================================================================
    public void checkEnd(){
        if(!(ib_0.isEnabled()) && !(ib_1.isEnabled()) && !(ib_2.isEnabled()) && !(ib_3.isEnabled()) &&
           !(ib_4.isEnabled()) && !(ib_5.isEnabled()) && !(ib_6.isEnabled()) && !(ib_7.isEnabled()) &&
           !(ib_8.isEnabled()) && !(ib_9.isEnabled()) && !(ib_10.isEnabled()) && !(ib_11.isEnabled())){
                matchCounter++;
                matchCount.setText(Integer.toString(matchCounter));

                ib_0.setEnabled(true);
                ib_1.setEnabled(true);
                ib_2.setEnabled(true);
                ib_3.setEnabled(true);
                ib_4.setEnabled(true);
                ib_5.setEnabled(true);
                ib_6.setEnabled(true);
                ib_7.setEnabled(true);
                ib_8.setEnabled(true);
                ib_9.setEnabled(true);
                ib_10.setEnabled(true);
                ib_11.setEnabled(true);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        matchDialog("Win", "You've won!");
                        halfReset(matchCounter);
                    }
                }, 1500);




        }else{
            return;
        }
    }


    //Generates random numbers from 0-11 to randomize image location================================
    public void generator(){

        for (int i = 0; i < 12; i++)
            myArray.add(i);

        Collections.shuffle(myArray);
        changeUnmatchedColor(value1);

    }


    //Soft reset after game won=====================================================================
    public void halfReset(int a){
        Intent intent = new Intent(getApplicationContext(), ActMain.class);
        intent.putExtra("unmatched_color", value1);
        intent.putExtra("matched_color", value2);
        intent.putExtra("score", a);
        startActivity(intent);
    }


    //Reset entire board and score==================================================================
    public void resetBoard(){
        Intent intent = new Intent(getApplicationContext(), ActMain.class);
        startActivity(intent);
    }


    //Change background of images from settings=====================================================
    public void changeUnmatchedColor(String color){

        //Red Background==================================================================
        if(color == "Red") {
            ib_0.setBackgroundResource(R.color.red);
            ib_1.setBackgroundResource(R.color.red);
            ib_2.setBackgroundResource(R.color.red);
            ib_3.setBackgroundResource(R.color.red);
            ib_4.setBackgroundResource(R.color.red);
            ib_5.setBackgroundResource(R.color.red);
            ib_6.setBackgroundResource(R.color.red);
            ib_7.setBackgroundResource(R.color.red);
            ib_8.setBackgroundResource(R.color.red);
            ib_9.setBackgroundResource(R.color.red);
            ib_10.setBackgroundResource(R.color.red);
            ib_11.setBackgroundResource(R.color.red);
        }

        //Blue Background==================================================================
        else if(color == "Blue"){
            ib_0.setBackgroundResource(R.color.blue);
            ib_1.setBackgroundResource(R.color.blue);
            ib_2.setBackgroundResource(R.color.blue);
            ib_3.setBackgroundResource(R.color.blue);
            ib_4.setBackgroundResource(R.color.blue);
            ib_5.setBackgroundResource(R.color.blue);
            ib_6.setBackgroundResource(R.color.blue);
            ib_7.setBackgroundResource(R.color.blue);
            ib_8.setBackgroundResource(R.color.blue);
            ib_9.setBackgroundResource(R.color.blue);
            ib_10.setBackgroundResource(R.color.blue);
            ib_11.setBackgroundResource(R.color.blue);
        }

        //Yellow Background==================================================================
        else if(color == "Yellow"){
            ib_0.setBackgroundResource(R.color.yellow);
            ib_1.setBackgroundResource(R.color.yellow);
            ib_2.setBackgroundResource(R.color.yellow);
            ib_3.setBackgroundResource(R.color.yellow);
            ib_4.setBackgroundResource(R.color.yellow);
            ib_5.setBackgroundResource(R.color.yellow);
            ib_6.setBackgroundResource(R.color.yellow);
            ib_7.setBackgroundResource(R.color.yellow);
            ib_8.setBackgroundResource(R.color.yellow);
            ib_9.setBackgroundResource(R.color.yellow);
            ib_10.setBackgroundResource(R.color.yellow);
            ib_11.setBackgroundResource(R.color.yellow);
        }
    }

    public void matchDialog(String m1, String m2){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(m1);
        dlgAlert.setTitle(m2);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();


    }
}
