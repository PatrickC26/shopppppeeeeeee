package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class CheckOut extends AppCompatActivity implements
    CompoundButton.OnCheckedChangeListener, DialogInterface.OnClickListener {

    Button B_back,B_send;
    EditText T_name,T_adress,T_phone;
    ListView L_item;
    CheckBox CB_paynotice;
    int total=0;

    ArrayAdapter<String> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("A");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);


        B_back=findViewById(R.id.B_back);
        B_send=findViewById(R.id.B_send);

        T_name=findViewById(R.id.T_name);
        T_adress=findViewById(R.id.T_adress);
        T_phone=findViewById(R.id.T_phone);

        L_item=findViewById(R.id.lv);

        CB_paynotice=findViewById(R.id.CB_paynotice);
        CB_paynotice.setOnCheckedChangeListener(this);

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
                            B_back.setBackgroundColor(Color.rgb(128,0,128));
                            B_send.setBackgroundColor(Color.rgb(128,0,128));
                            break;


                        case 1:
                            B_back.setBackgroundColor(Color.rgb(255,255,255));
                            B_send.setBackgroundColor(Color.rgb(255,255,255));

                            break;

                        case 2:
                            B_back.setBackgroundColor(Color.rgb(0,255,0));
                            B_send.setBackgroundColor(Color.rgb(0,255,0));

                            break;

                        case 3:

                            B_back.setBackgroundColor(Color.rgb(255,0,0));
                            B_send.setBackgroundColor(Color.rgb(255,0,0));
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


        Intent infoofitem=getIntent();
        boolean check[]=infoofitem.getBooleanArrayExtra("打勾的");
        String str1="",str2="",str3="",str4="",str5="";

        for(int i=0;i<5;i++){
            if(check[i]){
                switch (i){
                    case 0:
                        str1=infoofitem.getStringExtra("第一物品名")+"  $"+
                                infoofitem.getStringExtra("第一物品價格")+"  x"+
                                infoofitem.getStringExtra("第一物品數量");
                        total+=Integer.parseInt(infoofitem.getStringExtra("第一物品價格"))*
                                Integer.parseInt(infoofitem.getStringExtra("第一物品數量"));
                        break;

                    case 1:
                        str2=infoofitem.getStringExtra("第二物品名")+"  $"+
                                infoofitem.getStringExtra("第二物品價格")+"  x"+
                                infoofitem.getStringExtra("第二物品數量");
                        total+=Integer.parseInt(infoofitem.getStringExtra("第二物品價格"))*
                                Integer.parseInt(infoofitem.getStringExtra("第二物品數量"));
                        break;

                    case 2:
                        str3=infoofitem.getStringExtra("第三物品名")+"  $"+
                                infoofitem.getStringExtra("第三物品價格")+"  x"+
                                infoofitem.getStringExtra("第三物品數量");
                        total+=Integer.parseInt(infoofitem.getStringExtra("第三物品價格"))*
                                Integer.parseInt(infoofitem.getStringExtra("第三物品數量"));
                        break;

                    case 3:
                        str4=infoofitem.getStringExtra("第四物品名")+"  $"+
                                infoofitem.getStringExtra("第四物品價格")+"  x"+
                                infoofitem.getStringExtra("第四物品數量");
                        total+=Integer.parseInt(infoofitem.getStringExtra("第四物品價格"))*
                                Integer.parseInt(infoofitem.getStringExtra("第四物品數量"));
                        break;

                    case 4:

                        str5=infoofitem.getStringExtra("第五物品名")+"  $"+
                                infoofitem.getStringExtra("第五物品價格")+"  x"+
                                infoofitem.getStringExtra("第五物品數量");
                        total+=Integer.parseInt(infoofitem.getStringExtra("第五物品價格"))*
                                Integer.parseInt(infoofitem.getStringExtra("第五物品數量"));
                        break;
                }
            }
        }
        String str6=String.valueOf(total);
        String str[]={str1,str2,str3,str4,str5,str6};

        items=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,str);
        L_item.setAdapter(items);



    }

    boolean ischeck=false;


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b)
            ischeck=true;
        else
            ischeck=false;
    }

    public  void goback(View v){
        finish();

    }


    public void send(View v){
        int s1=0,s2=0,s3=0;
        String name="" ,adress="",phone="";

        try{
            name=T_name.getText().toString();
            s1=1;
            adress = T_adress.getText().toString();
            s2=1;
            phone = T_phone.getText().toString();
            s3=1;



        }catch (Exception e){
            if(s1==0||name=="")
                T_name.setBackgroundTintList
                        (ColorStateList.valueOf(Color.rgb(255,0,0)));

            if(s2==0||adress=="")
                T_adress.setBackgroundTintList
                        (ColorStateList.valueOf(Color.rgb(255, 0, 0)));


            if(s3==0||phone=="")
                T_phone.setBackgroundTintList
                        (ColorStateList.valueOf(Color.rgb(255,0,0)));


        }



        if(ischeck){
            AlertDialog.Builder bdr=new AlertDialog.Builder(this);

            bdr.setTitle("成功送出");
            bdr.setMessage("收件人姓名："+name+"\n收件地址："+adress+"\n收件人電話："+phone
                    +"\n總金額："+total);
            bdr.setCancelable(false);
            bdr.setPositiveButton("確定",this);
            bdr.show();





        }else{
            CB_paynotice.setButtonTintList(ColorStateList.valueOf(Color.rgb(255,0,0)));
        }

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i==DialogInterface.BUTTON_POSITIVE){
            Intent gom=new Intent();
            gom.setClass(this,shopping.class);
            startActivity(gom);

        }
    }
}