package adeelasghar.wsu.edu.memorymagicians;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class ActPopupMenu extends Activity {


    private RadioGroup unmatchedColorGroup;
    private RadioGroup matchedColorGroup;
    private RadioButton colorButton;
    Button apply;
    String radiovalue;
    String radiovalue2;
    Boolean isRed, isYellow, isBlue, isGreen, isOrange, isPurple;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_pop_menu);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);


        //====================================================================================================//


        unmatchedColorGroup = (RadioGroup) findViewById(R.id.rg_unmatched);
        matchedColorGroup = (RadioGroup) findViewById(R.id.rg_matched);

        RadioButton radioRed = (RadioButton) findViewById(R.id.rb_red);
        RadioButton radioBlue = (RadioButton) findViewById(R.id.rb_blue);
        RadioButton radioYellow = (RadioButton) findViewById(R.id.rb_yellow);

        RadioButton radioGreen = (RadioButton) findViewById(R.id.rb_green);
        RadioButton radioOrange = (RadioButton) findViewById(R.id.rb_orange);
        RadioButton radioPurple = (RadioButton) findViewById(R.id.rb_purple);



        Bundle extra = getIntent().getExtras();
        if (extra != null)
        {
            radiovalue = extra.getString("check_unmatched");
            radiovalue2 = extra.getString("check_matched");
        }

        if(radiovalue==null){
            isRed = true;
        }else{
            isRed = radiovalue.contains("Red");
            isBlue = radiovalue.indexOf("Blue") !=-1;
            isYellow = radiovalue.indexOf("Yellow") !=-1;
        }


        if(radiovalue2==null){
            isGreen=true;
        }else {
            isGreen = radiovalue2.contains("Green");
            isOrange = radiovalue2.indexOf("Orange") != -1;
            isPurple = radiovalue2.indexOf("Purple") != -1;
        }
        if(isRed)
            radioRed.setChecked(true);
        else if(isBlue)
            radioBlue.setChecked(true);
        else if(isYellow)
            radioYellow.setChecked(true);
        else
            radioRed.setChecked(true);

        if(isGreen)
            radioGreen.setChecked(true);
        else if(isOrange)
            radioOrange.setChecked(true);
        else if(isPurple)
            radioPurple.setChecked(true);
        else
            radioRed.setChecked(true);

        apply = (Button) findViewById(R.id.btn_apply);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActMain.class);
                intent.putExtra("unmatched_color", radiovalue);
                intent.putExtra("matched_color", radiovalue2);
                startActivity(intent);
            }
        });

    }

    public void checkButton(View v) {

        int radioID = unmatchedColorGroup.getCheckedRadioButtonId();
        colorButton = (RadioButton) findViewById(radioID);

        radiovalue = colorButton.getText().toString();
    }

    public void checkButton2(View v) {

        int radioID = matchedColorGroup.getCheckedRadioButtonId();
        colorButton = (RadioButton) findViewById(radioID);

        radiovalue2 = colorButton.getText().toString();
    }


}
