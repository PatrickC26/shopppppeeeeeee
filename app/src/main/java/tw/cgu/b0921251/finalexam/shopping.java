package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class shopping extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner filter;
    LinearLayout phone,shirt,shoe,wear,food;
    Toast tos;
    TextView tp1,tp2,tp3,tp4,ts1,ts2,tsh1,tsh2,tsh3,tsh4,tw1,tw2,tf1,tf2;
    TextView tppr,tspr,tshpr,twpr,tfpr;
    Button bp1,bs1,bsh1,bw1,bf1,bmain,bcart,bsetting;
    Boolean p[] = {false,false,false,false};//phone
    Boolean s[] = {false,false};//shoe
    Boolean sh[] = {false,false,false,false};//shirt
    Boolean w[] = {false,false};//wear
    Boolean f[] = {false,false};//food
    int nowcolor=0;
    int producttotal[] ={0,0,0,0};//auto find how much mun of each kind product????
    int filternum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        filter = (Spinner) findViewById(R.id.SP_filter);

        phone = findViewById(R.id.PhoneView);
        shirt = findViewById(R.id.ShirtView);
        shoe = findViewById(R.id.ShoeView);
        wear = findViewById(R.id.WearView);
        food = findViewById(R.id.FoodView);

        tp1 = findViewById(R.id.L_amountP1);
        tp2 = findViewById(R.id.L_amountP2);
        tp3 = findViewById(R.id.L_amountP3);
        tp4 = findViewById(R.id.L_amountP4);
        ts1 = findViewById(R.id.L_amountS1);
        ts2 = findViewById(R.id.L_amountS2);
        tsh1 = findViewById(R.id.L_amountSH1);
        tsh2 = findViewById(R.id.L_amountSH2);
        tsh3 = findViewById(R.id.L_amountSH3);
        tsh4 = findViewById(R.id.L_amountSH4);
        tw1 = findViewById(R.id.L_amountW1);
        tw2 = findViewById(R.id.L_amountW2);
        tf1 = findViewById(R.id.L_amountF1);
        tf2 = findViewById(R.id.L_amountF2);

        tppr = findViewById(R.id.L_pricep1);
        tspr = findViewById(R.id.L_prices1);
        tshpr = findViewById(R.id.L_pricesh1);
        twpr = findViewById(R.id.L_pricew1);
        tfpr = findViewById(R.id.L_pricef1);

        tos = Toast.makeText(this,"",Toast.LENGTH_SHORT);
//        nowcolor = 接收顏色
//                nowcolor = 3;
        bp1 = findViewById(R.id.B_addP1);
        bs1 = findViewById(R.id.B_addS1);
        bsh1 = findViewById(R.id.B_addSH1);
        bw1 = findViewById(R.id.B_addW1);
        bf1 = findViewById(R.id.B_addF1);
        bmain = findViewById(R.id.B_main);
        bcart = findViewById(R.id.B_cart1);
        bsetting = findViewById(R.id.B_setting1);
        Button b[] = {bp1,bs1,bsh1,bw1,bf1,bmain,bcart,bsetting};
        for(int i=0;i<b.length;i++){
            changebtncolor(b[i],nowcolor);
        }




        TextView amo[] = {tp1,tp2,tp3,tp4,ts1,ts2,tsh1,tsh2,tsh3,tsh4,tw1,tw2,tf1,tf2};
        for(int i=0;i<amo.length;i++){
            amo[i].setOnClickListener(this);
        }

        tp1.setText(R.string.手機1詳細);
        ts1.setText(R.string.鞋子1詳細);
        tsh1.setText(R.string.衣服1詳細);
        tf1.setText(R.string.食物1詳細);
        tw1.setText(R.string.穿戴1詳細);

        String a="";
        TextView ar[] = {tppr,tspr,tshpr,twpr,tfpr};
        for(int i=0;i<5;i++){
            a=ar[i].getText().toString();
            a= "$"+a+"元";
            ar[i].setText(a);
        }
        filter.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        filternum = pos;
        switch (filternum){
            case 0:
                phone.setVisibility(View.VISIBLE);
                shirt.setVisibility(View.VISIBLE);
                shoe.setVisibility(View.VISIBLE);
                wear.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                break;
            case 1:
                phone.setVisibility(View.VISIBLE);
                shirt.setVisibility(View.GONE);
                shoe.setVisibility(View.GONE);
                wear.setVisibility(View.GONE);
                food.setVisibility(View.GONE);
                break;
            case 2:
                phone.setVisibility(View.GONE);
                shirt.setVisibility(View.VISIBLE);
                shoe.setVisibility(View.GONE);
                wear.setVisibility(View.GONE);
                food.setVisibility(View.GONE);
                break;
            case 3:
                phone.setVisibility(View.GONE);
                shirt.setVisibility(View.GONE);
                shoe.setVisibility(View.VISIBLE);
                wear.setVisibility(View.GONE);
                food.setVisibility(View.GONE);
                break;
            case 4:
                phone.setVisibility(View.GONE);
                shirt.setVisibility(View.GONE);
                shoe.setVisibility(View.GONE);
                wear.setVisibility(View.VISIBLE);
                food.setVisibility(View.GONE);
                break;
            case 5:
                phone.setVisibility(View.GONE);
                shirt.setVisibility(View.GONE);
                shoe.setVisibility(View.GONE);
                wear.setVisibility(View.GONE);
                food.setVisibility(View.VISIBLE);
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    //->>>https://stackoverflow.com/questions/4854492/setting-width-to-wrap-content-for-textview-through-code
    @Override
    public void onClick(View view) {
        ViewGroup.LayoutParams parm = view.getLayoutParams();
//        int temp = view.getHeight();
        if(view.getHeight() == 168){//132emu    168s8+
            parm.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }else{
            parm.height = 168;
//            parm.height = 132;
        }
        view.setLayoutParams(parm);
    }




    //->>>https://stackoverflow.com/questions/7784418/get-all-child-views-inside-linearlayout-at-once
    String productname="";
    public void getproductname(int kind,int prodnum){
//        int count = phone.getChildCount();
        LinearLayout ly1[] = {phone,shirt,shoe,wear,food};
        View ele1 = ly1[kind].getChildAt(prodnum);
        if(ele1 instanceof LinearLayout){
            LinearLayout ly2 =(LinearLayout) ele1;
            View ele2 = ly2.getChildAt(1);
//            int vcount = ly2.getChildCount();
//            System.out.println("inVV"+ele2.getId()+vcount);

            if(ele2 instanceof LinearLayout){
                LinearLayout ly3_bottom = (LinearLayout) ele2;
                View ele3 = ly3_bottom.getChildAt(0);
//                int reconut = ly3_bottom.getChildCount();
//                System.out.println("inFIA"+ele3.getId()+" "+reconut);

                if(ele3 instanceof TextView){
                    TextView ltitle = (TextView) ele3;
                    String prod = ltitle.getText().toString();
//                    System.out.println(prod);
                    productname=prod;
                }
            }
        }

        //exist or not exist in cart
        switch (kind){
            case 0:
                if(p[prodnum]==false){
                    p[prodnum]=true;
                    tos.setText(productname+"已成功加入購物車!");
                    tos.show();
                }else{
                    tos.setText(productname+"已在購物車中!");
                    tos.show();
                }
                break;
            case 1:
                if(sh[prodnum]==false){
                    sh[prodnum]=true;
                    tos.setText(productname+"已成功加入購物車!");
                    tos.show();
                }else{
                    tos.setText(productname+"已在購物車中!");
                    tos.show();
                }
                break;
            case 2:
                if(s[prodnum]==false){
                    s[prodnum]=true;
                    tos.setText(productname+"已成功加入購物車!");
                    tos.show();
                }else{
                    tos.setText(productname+"已在購物車中!");
                    tos.show();
                }
                break;
            case 3:
                if(w[prodnum]==false){
                    w[prodnum]=true;
                    tos.setText(productname+"已成功加入購物車!");
                    tos.show();
                }else{
                    tos.setText(productname+"已在購物車中!");
                    tos.show();
                }
                break;
            case 4:
                if(f[prodnum]==false){
                    f[prodnum]=true;
                    tos.setText(productname+"已成功加入購物車!");
                    tos.show();
                }else{
                    tos.setText(productname+"已在購物車中!");
                    tos.show();
                }
                break;
            default:
                break;

        }

        //debug---------------------
        for (int k=0;k<4;k++){
            System.out.print(p[k]+" ");
        }
        System.out.println();
        for (int k=0;k<2;k++){
            System.out.print(s[k]+" ");
        }
        System.out.println();
        for (int k=0;k<4;k++){
            System.out.print(sh[k]+" ");
        }
        System.out.println();
        for (int k=0;k<2;k++){
            System.out.print(w[k]+" ");
        }
        System.out.println();
        for (int k=0;k<2;k++){
            System.out.print(f[k]+" ");
        }
        System.out.println();
        System.out.println("productname: "+productname+"~~~~");
    }

    //phone
    public void AddOnClickp1(View v){
        getproductname(0,0);
    }
    public void AddOnClickp2(View v){
        getproductname(0,1);
    }
    public void AddOnClickp3(View v){
        getproductname(0,2);
    }
    public void AddOnClickp4(View v){
        getproductname(0,3);
    }

    //shirt
    public void AddOnClicksh1(View v){
        getproductname(1,0);
    }
    public void AddOnClicksh2(View v){
        getproductname(1,1);
    }
    public void AddOnClicksh3(View v){
        getproductname(1,2);
    }
    public void AddOnClicksh4(View v){
        getproductname(1,3);
    }

    //shoe
    public void AddOnClicks1(View v){
        getproductname(2,0);
    }
    public void AddOnClicks2(View v) {
        getproductname(2,1);
    }

    //wear
    public void AddOnClickw1(View v){
        getproductname(3,0);
    }
    public void AddOnClickw2(View v){
        getproductname(3,1);
    }

    //food
    public void AddOnClickf1(View v){
        getproductname(4,0);
    }
    public void AddOnClickf2(View v){
        getproductname(4,1);
    }




    public void MainOnClick(View v){
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


    public void changebtncolor(Button b , int color){
        switch (color){
            case 0:
                b.setBackgroundColor(Color.rgb(98,0,238));
                b.setTextColor(Color.rgb(255,255,255));
                break;
            case 1:
                b.setBackgroundColor(Color.rgb(0,0,0));
                b.setTextColor(Color.rgb(255,255,255));
                break;
            case 2:
                b.setBackgroundColor(Color.rgb(0,255,0));
                b.setTextColor(Color.rgb(255,255,255));
                break;
            case 3:
                b.setBackgroundColor(Color.rgb(255,0,0));
                b.setTextColor(Color.rgb(255,255,255));
                break;
            default:
                break;
        }
    }


}