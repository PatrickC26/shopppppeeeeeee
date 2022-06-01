package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class setting extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        RadioGroup a = findViewById(R.id.RG);
        a.setOnCheckedChangeListener(this);
    }



    public void MainOnClick(View v){ startActivity(new Intent(this, shopping.class));}
    public void CartOnClick(View v){ startActivity(new Intent(this, Cart.class));}
    public void SettingOnClick(View v){ startActivity(new Intent(this, setting.class));}

    public void logout (View v){ new Intent(this, setting.class);}


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int color = -1; // 0 -> purple  1 -> black   2 -> green   3 -> red
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.RB_purple:
                color = 0;
                break;
            case R.id.RB_black:
                color = 1;
                break;
            case R.id.RB_green:
                color = 2;
                break;
            case R.id.RB_red:
                color = 3;
                break;
            default:
                break;
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference colorFB = database.getReference("account/" + login.userName + "/color");
        colorFB.setValue(String.valueOf(color));
    }
}