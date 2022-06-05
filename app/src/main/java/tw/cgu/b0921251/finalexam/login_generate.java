package tw.cgu.b0921251.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import tw.cgu.b0921251.finalexam.R;

public class login_generate extends AppCompatActivity
    implements TextWatcher {

    EditText T_username, T_email, T_name, T_password;
    TextView L_username_unavailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_generate);


        T_username = findViewById(R.id.T_generate_username);
        T_email = findViewById(R.id.T_generate_email);
        T_name = findViewById(R.id.T_generate_name);
        T_password = findViewById(R.id.T_generate_password);

        T_username.addTextChangedListener(this);

        L_username_unavailable = findViewById(R.id.L_username_unavailable);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    public void login(View v){ finish();}

    @Override
    public void afterTextChanged(Editable editable) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference pswd = database.getReference("account/" + T_username.getText().toString() + "/pswd");
        pswd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    String value = dataSnapshot.getValue(String.class);
                    if (!value.isEmpty())
                        L_username_unavailable.setVisibility(View.VISIBLE);
                    else
                        L_username_unavailable.setVisibility(View.INVISIBLE);
                }
                catch (Exception e){
                    L_username_unavailable.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Failed to read value." + error.toException());
            }
        });
    }

    public void registor (View view){
        if (L_username_unavailable.getVisibility() == View.INVISIBLE
        && !T_username.getText().toString().isEmpty()
        && !T_email.getText().toString().isEmpty()
        && !T_name.getText().toString().isEmpty()
        && !T_password.getText().toString().isEmpty()) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();

            DatabaseReference pswd = database.getReference("account/" + T_username.getText().toString() + "/pswd");
            pswd.setValue(T_password.getText().toString());

            DatabaseReference email = database.getReference("account/" + T_username.getText().toString() + "/email");
            email.setValue(T_email.getText().toString());

            DatabaseReference name = database.getReference("account/" + T_username.getText().toString() + "/name");
            name.setValue(T_name.getText().toString());

            DatabaseReference color = database.getReference("account/" + T_username.getText().toString() + "/color");
            color.setValue("0");

            AlertDialog.Builder loginUnsuccessfull = new AlertDialog.Builder(this);
            loginUnsuccessfull.setMessage("註冊成功！").setTitle("成功").setPositiveButton("OK", null).show();

            finish();
        }
        else{
            AlertDialog.Builder loginUnsuccessfull = new AlertDialog.Builder(this);
            loginUnsuccessfull.setMessage("請勿空白").setTitle("錯誤").setPositiveButton("OK", null).show();
        }
    }
}