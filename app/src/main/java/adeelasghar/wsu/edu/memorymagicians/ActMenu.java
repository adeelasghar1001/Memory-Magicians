package adeelasghar.wsu.edu.memorymagicians;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ActMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //Ensures layout is fullscreen
        setContentView(R.layout.layout_menu);
    }

    public void buttonOnClick(View v){
        Button button = (Button) findViewById(R.id.standard);

        startActivity(new Intent(getApplicationContext(), ActMain.class));

    }
}
