package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class setting extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener {

Button toShop, toCart, toSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        RadioGroup a = findViewById(R.id.RG);
        a.setOnCheckedChangeListener(this);

        toShop = findViewById(R.id.toShop);
        toCart = findViewById(R.id.toCart);
        toSetting = findViewById(R.id.toSetting);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference colorFB = database.getReference("account/" + login.userName + "/color");
        colorFB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    String value = dataSnapshot.getValue(String.class);
                    int themeColor = Integer.parseInt(value);
                    System.out.println(themeColor);

                    switch (themeColor){
                        case 0:
                            RadioButton RBP = findViewById(R.id.RB_purple);
                            RBP.setChecked(true);
                            toShop.setBackgroundColor(Color.rgb(128,0,128));
                            toCart.setBackgroundColor(Color.rgb(128,0,128));
                            toSetting.setBackgroundColor(Color.rgb(128,0,128));
                            break;
                        case 1:
                            RadioButton RBB = findViewById(R.id.RB_black);
                            RBB.setChecked(true);
                            toShop.setBackgroundColor(Color.BLACK);
                            toCart.setBackgroundColor(Color.BLACK);
                            toSetting.setBackgroundColor(Color.BLACK);
                            break;

                        case 2:
                            RadioButton RBG = findViewById(R.id.RB_green);
                            RBG.setChecked(true);
                            toShop.setBackgroundColor(Color.rgb(0,255,0));
                            toCart.setBackgroundColor(Color.rgb(0,255,0));
                            toSetting.setBackgroundColor(Color.rgb(0,255,0));
                            break;
                        case 3:
                            RadioButton RBR = findViewById(R.id.RB_red);
                            RBR.setChecked(true);
                            toShop.setBackgroundColor(Color.rgb(255,0,0));
                            toCart.setBackgroundColor(Color.rgb(255,0,0));
                            toSetting.setBackgroundColor(Color.rgb(255,0,0));
                            break;
                    }
                }
                catch (Exception e){   }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Failed to read value." + error.toException());
            }
        });
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