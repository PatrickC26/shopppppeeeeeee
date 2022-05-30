package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class setting extends AppCompatActivity {

    int color = 0; // 0 -> purple  1 -> black   2 -> green   3 -> red

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void logout (View v){
        setContentView(R.layout.activity_login);
    }



}