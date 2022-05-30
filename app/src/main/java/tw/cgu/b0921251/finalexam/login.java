package tw.cgu.b0921251.finalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class login extends AppCompatActivity {


    // login
    EditText T_username, T_password;
    Button B_login;
    String PSWD = "";


    // setting
    int themeColor = 0; // 0 -> purple  1 -> black   2 -> green   3 -> red


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // login
        T_username = findViewById(R.id.T_username);
        T_password = findViewById(R.id.T_password);
        B_login = findViewById(R.id.B_login);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference pswd = database.getReference("account/a/pswd");
        pswd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                System.out.println(value);
                PSWD = value.toString();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Failed to read value." + error.toException());
            }
        });
    }

    // login page
    public void loginButton(View v){
        if (PSWD.equals(T_password.getText().toString())) {
            startActivity(new Intent(this, shopping.class));
        }
        else {
            AlertDialog.Builder loginUnsuccessfull = new AlertDialog.Builder(this);
            loginUnsuccessfull.setMessage("登入失敗！").setTitle("錯誤").setPositiveButton("OK", null).show();
            T_username.setText("");
            T_password.setText("");
        }
    }


    // ALL
    public void MainOnClick(View v){ startActivity(new Intent(this, shopping.class));}
    public void CartOnClick(View v){ startActivity(new Intent(this, Cart.class));}
    public void SettingOnClick(View v){ startActivity(new Intent(this, setting.class));}


    // setting page
    public void logout (View v){ setContentView(R.layout.activity_login);  }


}