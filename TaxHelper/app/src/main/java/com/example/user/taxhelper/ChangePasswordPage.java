package com.example.user.taxhelper;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordPage extends AppCompatActivity {

    private EditText chngpass_oldpassword,chngpass_newpassword,chngpass_confirmpassword;
    private Button chngpassbtn;
    String oldpass,newpass,confirmpass,storedpass;
    String username5;
    TaxDatabaseHandler chngpass_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password_page);

        chngpass_oldpassword = (EditText) findViewById(R.id.chngpass_oldpassword);
        chngpass_newpassword = (EditText) findViewById(R.id.chngpass_newpassword);
        chngpass_confirmpassword = (EditText) findViewById(R.id.chngpass_confirmpassword);
        chngpassbtn = (Button) findViewById(R.id.chngpass_btn);

        chngpass_db = new TaxDatabaseHandler(ChangePasswordPage.this);

        Bundle chngpass_extras = getIntent().getExtras();
        if(chngpass_extras != null)
        {
            username5 = chngpass_extras.getString("Username");
        }

        Cursor chngpass_res = chngpass_db.getData("*",username5,TaxDatabaseHandler.T1_LOGIN_DETAILS,TaxDatabaseHandler.T1_C1_USERNAME);
        chngpass_res.moveToFirst();
        storedpass = chngpass_res.getString(1);

        chngpassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldpass = chngpass_oldpassword.getText().toString();
                newpass = chngpass_newpassword.getText().toString();
                confirmpass = chngpass_confirmpassword.getText().toString();

                if(oldpass.equals("") || newpass.equals("") || confirmpass.equals(""))
                {
                    Toast.makeText(ChangePasswordPage.this,"Please fill the form.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(oldpass.equals(storedpass))
                    {
                        if(newpass.equals(confirmpass))
                        {
                            chngpass_db.updateData(newpass,TaxDatabaseHandler.T1_C2_PASSWORD,TaxDatabaseHandler.T1_LOGIN_DETAILS,TaxDatabaseHandler.T1_C1_USERNAME,username5);
                            Toast.makeText(ChangePasswordPage.this,"Password changes successfully.",Toast.LENGTH_SHORT).show();
                            Intent gotocustomhome = new Intent(ChangePasswordPage.this,CustomerHome.class);
                            gotocustomhome.putExtra("Username",username5);
                            startActivity(gotocustomhome);
                        }
                        else
                        {
                            Toast.makeText(ChangePasswordPage.this,"New passwords does not match",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(ChangePasswordPage.this,"Wrong old password.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
