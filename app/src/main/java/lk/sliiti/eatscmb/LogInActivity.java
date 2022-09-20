package lk.sliiti.eatscmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class LogInActivity extends AppCompatActivity {

    EditText username, password, nextPass;
    Button logInBtn,registerBtn,backBtn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.log_in);

        username = (EditText) findViewById(R.id.userNameTxt);
        password = (EditText) findViewById(R.id.password);
        nextPass = (EditText) findViewById(R.id.nextPass);
        logInBtn = (Button) findViewById(R.id.login_btn_2);
        registerBtn = (Button) findViewById(R.id.register_btn2);
        backBtn = (Button) findViewById(R.id.backBtn);
        DB = new DBHelper(this);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(LogInActivity.this,"Username or Password Missing",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(nextPass))
                    {
                        Boolean checkUser = DB.checkUser(user);
                        if(checkUser == false)
                        {
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true)
                            {
                                Toast.makeText(LogInActivity.this,"ACCOUNT CREATED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),UserProfileActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(LogInActivity.this,"Registration Failed.",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(LogInActivity.this,"User Already Exists. Please try again!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(LogInActivity.this,"Incorrect Username or Password.",Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}