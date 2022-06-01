package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Cart extends AppCompatActivity implements View.OnLongClickListener,
        CompoundButton.OnCheckedChangeListener, TextWatcher {

    TextView L_cartTitle1,L_cartTitle2,L_cartTitle3,L_cartTitle4,L_cartTitle5;
    TextView L_cartAmount1,L_cartAmount2,L_cartAmount3,L_cartAmount4,L_cartAmount5;
    TextView totalamount;
    Button B_deleteAll,B_pay,B_main,B_cart,B_setting;
    CheckBox CB_cart1,CB_cart2,CB_cart3,CB_cart4,CB_cart5;
    EditText T_cartQty1,T_cartQty2,T_cartQty3,T_cartQty4,T_cartQty5;
    ImageView P_cartImg1,P_cartImg2,P_cartImg3,P_cartImg4,P_cartImg5;
    boolean[] check={false,false,false,false,false};
    boolean phone[], shoe[],shirt[],wear[],food[];
    int notvisible=View.GONE;
    int isvisible=View.VISIBLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);






        totalamount=findViewById(R.id.T_totalamount);

        L_cartAmount1=findViewById(R.id.L_cartAmount1);
        L_cartAmount2=findViewById(R.id.L_cartAmount2);
        L_cartAmount3=findViewById(R.id.L_cartAmount3);
        L_cartAmount4=findViewById(R.id.L_cartAmount4);
        L_cartAmount5=findViewById(R.id.L_cartAmount5);

        L_cartTitle1=findViewById(R.id.L_cartTitle1);
        L_cartTitle2=findViewById(R.id.L_cartTitle2);
        L_cartTitle3=findViewById(R.id.L_cartTitle3);
        L_cartTitle4=findViewById(R.id.L_cartTitle4);
        L_cartTitle5=findViewById(R.id.L_cartTitle5);

        B_deleteAll=findViewById(R.id.B_deleteAll);
        B_pay=findViewById(R.id.B_pay);
        B_main=findViewById(R.id.B_main);
        B_cart=findViewById(R.id.B_cart);
        B_setting=findViewById(R.id.B_setting);


        CB_cart1=findViewById(R.id.CB_cart1);
        CB_cart2=findViewById(R.id.CB_cart2);
        CB_cart3=findViewById(R.id.CB_cart3);
        CB_cart4=findViewById(R.id.CB_cart4);
        CB_cart5=findViewById(R.id.CB_cart5);

        T_cartQty1=findViewById(R.id.T_cartQty1);
        T_cartQty2=findViewById(R.id.T_cartQty2);
        T_cartQty3=findViewById(R.id.T_cartQty3);
        T_cartQty4=findViewById(R.id.T_cartQty4);
        T_cartQty5=findViewById(R.id.T_cartQty5);

        P_cartImg1=findViewById(R.id.P_cartImg1);
        P_cartImg2=findViewById(R.id.P_cartImg2);
        P_cartImg3=findViewById(R.id.P_cartImg3);
        P_cartImg4=findViewById(R.id.P_cartImg4);
        P_cartImg5=findViewById(R.id.P_cartImg5);


        B_deleteAll.setOnLongClickListener(this);

        CB_cart1.setOnCheckedChangeListener(this);
        CB_cart2.setOnCheckedChangeListener(this);
        CB_cart3.setOnCheckedChangeListener(this);
        CB_cart4.setOnCheckedChangeListener(this);
        CB_cart5.setOnCheckedChangeListener(this);

        T_cartQty1.addTextChangedListener(this);
        T_cartQty2.addTextChangedListener(this);
        T_cartQty3.addTextChangedListener(this);
        T_cartQty4.addTextChangedListener(this);
        T_cartQty5.addTextChangedListener(this);





       /* Intent getcolor=getIntent();

        int color=getcolor.getIntExtra()

        switch (color){
            case 0:
            B_deleteAll.setBackgroundColor(Color.rgb(128,0,128));
            B_pay.setBackgroundColor(Color.rgb(128,0,128));
            B_main.setBackgroundColor(Color.rgb(128,0,128));
            B_cart.setBackgroundColor(Color.rgb(128,0,128));
            B_setting.setBackgroundColor(Color.rgb(128,0,128));
            break;




            case 1:
            B_deleteAll.setBackgroundColor(Color.rgb(255,255,255));
            B_pay.setBackgroundColor(Color.rgb(255,255,255));
            B_main.setBackgroundColor(Color.rgb(255,255,255));
            B_cart.setBackgroundColor(Color.rgb(255,255,255));
            B_setting.setBackgroundColor(Color.rgb(255,255,255));
            break;

            case 2:
            B_deleteAll.setBackgroundColor(Color.rgb(0,255,0));
            B_pay.setBackgroundColor(Color.rgb(0,255,0));
            B_main.setBackgroundColor(Color.rgb(0,255,0));
            B_cart.setBackgroundColor(Color.rgb(0,255,0));
            B_setting.setBackgroundColor(Color.rgb(0,255,0));
            break;



            case 3:

            B_deleteAll.setBackgroundColor(Color.rgb(255,0,0));
            B_pay.setBackgroundColor(Color.rgb(255,0,0));
            B_main.setBackgroundColor(Color.rgb(255,0,0));
            B_cart.setBackgroundColor(Color.rgb(255,0,0));
            B_setting.setBackgroundColor(Color.rgb(255,0,0));
            break;



        }*/







        L_cartTitle1.setVisibility(notvisible);
        L_cartTitle2.setVisibility(notvisible);
        L_cartTitle3.setVisibility(notvisible);
        L_cartTitle4.setVisibility(notvisible);
        L_cartTitle5.setVisibility(notvisible);

        L_cartAmount1.setVisibility(notvisible);
        L_cartAmount2.setVisibility(notvisible);
        L_cartAmount3.setVisibility(notvisible);
        L_cartAmount4.setVisibility(notvisible);
        L_cartAmount5.setVisibility(notvisible);

        P_cartImg1.setVisibility(notvisible);
        P_cartImg2.setVisibility(notvisible);
        P_cartImg3.setVisibility(notvisible);
        P_cartImg4.setVisibility(notvisible);
        P_cartImg5.setVisibility(notvisible);

        T_cartQty1.setVisibility(notvisible);
        T_cartQty2.setVisibility(notvisible);
        T_cartQty3.setVisibility(notvisible);
        T_cartQty4.setVisibility(notvisible);
        T_cartQty5.setVisibility(notvisible);

        CB_cart1.setVisibility(notvisible);
        CB_cart2.setVisibility(notvisible);
        CB_cart3.setVisibility(notvisible);
        CB_cart4.setVisibility(notvisible);
        CB_cart5.setVisibility(notvisible);



    Intent it=getIntent();

    phone=it.getBooleanArrayExtra("phone");
    shoe=it.getBooleanArrayExtra("shoe");
    shirt= it.getBooleanArrayExtra("shirt");
    wear= it.getBooleanArrayExtra("wear");
    food= it.getBooleanArrayExtra("food");


       if (phone[0]) {
           L_cartTitle1.setVisibility(isvisible);
           L_cartAmount1.setVisibility(isvisible);
           P_cartImg1.setVisibility(isvisible);
           T_cartQty1.setVisibility(isvisible);
           CB_cart1.setVisibility(isvisible);
       }
       if (shoe[0]) {
           L_cartTitle2.setVisibility(isvisible);
           L_cartAmount2.setVisibility(isvisible);
           P_cartImg2.setVisibility(isvisible);
           T_cartQty2.setVisibility(isvisible);
           CB_cart2.setVisibility(isvisible);
       }
       if (shirt[0]) {
           L_cartTitle3.setVisibility(isvisible);
           L_cartAmount3.setVisibility(isvisible);
           P_cartImg3.setVisibility(isvisible);
           T_cartQty3.setVisibility(isvisible);
           CB_cart3.setVisibility(isvisible);
       }
       if (wear[0]) {
           L_cartTitle4.setVisibility(isvisible);
           L_cartAmount4.setVisibility(isvisible);
           P_cartImg4.setVisibility(isvisible);
           T_cartQty4.setVisibility(isvisible);
           CB_cart4.setVisibility(isvisible);
       }
       if (food[0]) {
           L_cartTitle5.setVisibility(isvisible);
           L_cartAmount5.setVisibility(isvisible);
           P_cartImg5.setVisibility(isvisible);
           T_cartQty5.setVisibility(isvisible);
           CB_cart5.setVisibility(isvisible);
       }



    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        cal();
    }

    @Override
    public boolean onLongClick(View view) {

        L_cartTitle1.setVisibility(notvisible);
        L_cartTitle2.setVisibility(notvisible);
        L_cartTitle3.setVisibility(notvisible);
        L_cartTitle4.setVisibility(notvisible);
        L_cartTitle5.setVisibility(notvisible);

        L_cartAmount1.setVisibility(notvisible);
        L_cartAmount2.setVisibility(notvisible);
        L_cartAmount3.setVisibility(notvisible);
        L_cartAmount4.setVisibility(notvisible);
        L_cartAmount5.setVisibility(notvisible);

        P_cartImg1.setVisibility(notvisible);
        P_cartImg2.setVisibility(notvisible);
        P_cartImg3.setVisibility(notvisible);
        P_cartImg4.setVisibility(notvisible);
        P_cartImg5.setVisibility(notvisible);

        T_cartQty1.setVisibility(notvisible);
        T_cartQty2.setVisibility(notvisible);
        T_cartQty3.setVisibility(notvisible);
        T_cartQty4.setVisibility(notvisible);
        T_cartQty5.setVisibility(notvisible);

        CB_cart1.setVisibility(notvisible);
        CB_cart2.setVisibility(notvisible);
        CB_cart3.setVisibility(notvisible);
        CB_cart4.setVisibility(notvisible);
        CB_cart5.setVisibility(notvisible);

        check[0]=false;
        check[1]=false;
        check[2]=false;
        check[3]=false;
        check[4]=false;


        return true;
    }




    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(b){
            switch (compoundButton.getId()){
                case R.id.CB_cart1:
                    check[0]=true;
                    break;
                case R.id.CB_cart2:
                    check[1]=true;
                    break;
                case R.id.CB_cart3:
                    check[2]=true;
                    break;
                case R.id.CB_cart4:
                    check[3]=true;
                    break;
                case R.id.CB_cart5:
                    check[4]=true;
                    break;

            }
        }else{
            switch (compoundButton.getId()){
                case R.id.CB_cart1:
                    check[0]=false;
                    break;
                case R.id.CB_cart2:
                    check[1]=false;
                    break;
                case R.id.CB_cart3:
                    check[2]=false;
                    break;
                case R.id.CB_cart4:
                    check[3]=false;
                    break;
                case R.id.CB_cart5:
                    check[4]=false;
                    break;

            }

        }

        cal();

    }



    public void gomain(View v){
        Intent gom=new Intent();

        gom.setClass(this,shopping.class);

        gom.putExtra("phone",phone);
        gom.putExtra("shirt",shirt);
        gom.putExtra("shoe",shoe);
        gom.putExtra("wear",wear);
        gom.putExtra("food",food);
        startActivity(gom);

    }

    public void gosetting(View v){
          Intent gos=new Intent();
        gos.setClass(this,setting.class);
        startActivity(gos);

    }

    public void gopay(View v){
        Intent gop=new Intent();
        gop.setClass(this,CheckOut.class);

        gop.putExtra("打勾的",check);

        for(int i=0;i<5;i++){
            if(check[i]){
                switch (i){
                    case 0:
                        gop.putExtra("第一物品名",L_cartTitle1.getText().toString());
                        gop.putExtra("第一物品價格",L_cartAmount1.getText().toString());
                        gop.putExtra("第一物品數量",T_cartQty1.getText().toString());
                        break;
                    case 1:
                        gop.putExtra("第二物品名",L_cartTitle2.getText().toString());
                        gop.putExtra("第二物品價格",L_cartAmount2.getText().toString());
                        gop.putExtra("第二物品數量",T_cartQty2.getText().toString());
                        break;
                    case 2:
                        gop.putExtra("第三物品名",L_cartTitle3.getText().toString());
                        gop.putExtra("第三物品價格",L_cartAmount3.getText().toString());
                        gop.putExtra("第三物品數量",T_cartQty3.getText().toString());
                        break;
                    case 3:
                        gop.putExtra("第四物品名",L_cartTitle4.getText().toString());
                        gop.putExtra("第四物品價格",L_cartAmount4.getText().toString());
                        gop.putExtra("第四物品數量",T_cartQty4.getText().toString());
                        break;
                    case 4:
                        gop.putExtra("第五物品名",L_cartTitle5.getText().toString());
                        gop.putExtra("第五物品價格",L_cartAmount5.getText().toString());
                        gop.putExtra("第五物品數量",T_cartQty5.getText().toString());
                        break;





                }
            }
        }


        startActivity(gop);


    }

    public void cal(){
        double total=0;
        double one;
        try {
            for (int i = 0; i < 5; i++) {
                if (check[i]) {
                    switch (i) {
                        case 0:
                            one = Double.parseDouble(L_cartAmount1.getText().toString()) *
                                    Double.parseDouble(T_cartQty1.getText().toString());
                            total += one;
                            break;
                        case 1:
                            one = Double.parseDouble(L_cartAmount2.getText().toString()) *
                                    Double.parseDouble(T_cartQty2.getText().toString());
                            total += one;
                            break;
                        case 2:
                            one = Double.parseDouble(L_cartAmount3.getText().toString()) *
                                    Double.parseDouble(T_cartQty3.getText().toString());
                            total += one;
                            break;
                        case 3:
                            one = Double.parseDouble(L_cartAmount4.getText().toString()) *
                                    Double.parseDouble(T_cartQty4.getText().toString());
                            total += one;
                            break;
                        case 4:
                            one = Double.parseDouble(L_cartAmount5.getText().toString()) *
                                    Double.parseDouble(T_cartQty5.getText().toString());
                            total += one;
                            break;
                    }
                }
            }
        }catch (Exception e){

        }

        totalamount.setText("$"+total);
    }
}