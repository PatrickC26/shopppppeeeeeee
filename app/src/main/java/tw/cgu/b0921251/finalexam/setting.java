package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class setting extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener {

    Button toShop, toCart, toSetting;
    TextView L_user;

    boolean p[] = {false,false,false,false};//phone
    boolean s[] = {false,false};//shoe
    boolean sh[] = {false,false,false,false};//shirt
    boolean w[] = {false,false};//wear
    boolean f[] = {false,false};//food

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        RadioGroup a = findViewById(R.id.RG);
        a.setOnCheckedChangeListener(this);

        toShop = findViewById(R.id.toShop);
        toCart = findViewById(R.id.toCart);
        toSetting = findViewById(R.id.toSetting);
        L_user = findViewById(R.id.L_user);

        Intent it = getIntent();
        int flag = it.getIntExtra("flag",0);
        if(flag==1){
            p=it.getBooleanArrayExtra("phone");
            s=it.getBooleanArrayExtra("shoe");
            sh= it.getBooleanArrayExtra("shirt");
            w= it.getBooleanArrayExtra("wear");
            f= it.getBooleanArrayExtra("food");
        }

        if (login.userName.isEmpty())
            finish();

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
                            toShop.setBackgroundColor(Color.rgb(255,0,103));
                            toCart.setBackgroundColor(Color.rgb(255,0,103));
                            toSetting.setBackgroundColor(Color.rgb(255,0,103));
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
                            toShop.setBackgroundColor(Color.rgb(105,161,2));
                            toCart.setBackgroundColor(Color.rgb(105,161,2));
                            toSetting.setBackgroundColor(Color.rgb(105,161,2));
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

        DatabaseReference Uname = database.getReference("account/" + login.userName + "/name");
        Uname.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    String value = dataSnapshot.getValue(String.class);
                    L_user.setText(value + " 您好");
                }
                catch (Exception e){   }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Failed to read value." + error.toException());
            }
        });
    }



    public void MainOnClick(View v){
        Intent it = new Intent(this,shopping.class);
        it.putExtra("flag",1);
        it.putExtra("phone",p);
        it.putExtra("shoe",s);
        it.putExtra("shirt",sh);
        it.putExtra("wear",w);
        it.putExtra("food",f);
        finish();
        startActivity(it);
    }
    public void CartOnClick(View v){
        Intent it = new Intent(this,Cart.class);
        it.putExtra("flag",1);
        it.putExtra("phone",p);
        it.putExtra("shoe",s);
        it.putExtra("shirt",sh);
        it.putExtra("wear",w);
        it.putExtra("food",f);
        finish();
        startActivity(it);
    }
    public void SettingOnClick(View v){ }
    public void logout (View v){ finish(); System.out.println("logout");}


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