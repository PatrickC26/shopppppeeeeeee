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

    public void logout (View v){
        Intent it = new Intent(this,login.class);
        startActivity(it);
    }

    public void MainOnClick(View v){
        System.out.println("Log in success");
        Intent it = new Intent(this,shopping.class);
        startActivity(it);
    }
    public void CartOnClick(View v){
        Intent it = new Intent(this,Cart.class);
        startActivity(it);
    }
    public void SettingOnClick(View v){
        Intent it = new Intent(this,setting.class);
        startActivity(it);
    }
}