package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class setting extends AppCompatActivity {

    int color = 0; // 0 -> purple  1 -> black   2 -> green   3 -> red

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void MainOnClick(View v){ startActivity(new Intent(this, shopping.class));}
    public void CartOnClick(View v){ startActivity(new Intent(this, Cart.class));}
    public void SettingOnClick(View v){ startActivity(new Intent(this, setting.class));}

    public void logout (View v){ new Intent(this, setting.class);}



}