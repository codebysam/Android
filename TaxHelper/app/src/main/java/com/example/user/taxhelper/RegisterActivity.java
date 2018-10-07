package com.example.user.taxhelper;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    String username,password,repassword,fullname,gender,panno,phnno,dob,usertype;
    private TaxDatabaseHandler mydb2;
    private EditText reg_fullname,reg_username,reg_password,reg_repassword,reg_dob,reg_phn_no,reg_panno;
    private Spinner reg_gender_spinner,reg_usertype;
    private Button register_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg_fullname = (EditText) findViewById(R.id.fullName2);
        reg_username = (EditText) findViewById(R.id.userName2);
        reg_password = (EditText) findViewById(R.id.password2);
        reg_repassword = (EditText) findViewById(R.id.repassword2);
        reg_dob = (EditText) findViewById(R.id.birthday2);
        reg_phn_no = (EditText) findViewById(R.id.phone_no2);
        reg_panno = (EditText) findViewById(R.id.pan_no2);
        reg_gender_spinner = (Spinner) findViewById(R.id.genderspinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.genderoptions));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reg_gender_spinner.setAdapter(adapter);
        reg_usertype = (Spinner) findViewById(R.id.usertypespinner);
        ArrayAdapter<String> usertypeadapter = new ArrayAdapter<String>(RegisterActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.usertype));
        usertypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reg_usertype.setAdapter(usertypeadapter);
        register_btn = (Button) findViewById(R.id.registerButton2);
        mydb2 = new TaxDatabaseHandler(RegisterActivity.this);

        register_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fullname = reg_fullname.getText().toString();
                 username = reg_username.getText().toString();
                 password = reg_password.getText().toString();
                 repassword = reg_repassword.getText().toString();
                 gender = reg_gender_spinner.getSelectedItem().toString();
                 usertype = reg_usertype.getSelectedItem().toString();
                 dob = reg_dob.getText().toString();
                 panno = reg_panno.getText().toString();
                 phnno = reg_phn_no.getText().toString();

                 if(fullname.equals("") || username.equals("") || password.equals("") || repassword.equals("") || gender.equals("Gender") || usertype.equals("") || dob.equals("") || panno.equals("") || phnno.equals(""))
                 {
                     Toast.makeText(RegisterActivity.this,"Please fill the form",Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Cursor res = mydb2.getData("*",username,"LOGIN_DETAILS","USERNAME");
                     if(res.getCount() > 0)
                     {
                         Toast.makeText(RegisterActivity.this,"Username already exist.",Toast.LENGTH_SHORT).show();
                     }
                     else
                     {
                            if(password.equals(repassword))
                            {
                                if(mydb2.insertprofileData(fullname,username,password,usertype,dob,panno,phnno,gender))
                                {
                                    Toast.makeText(RegisterActivity.this,"Data Inserted successfully.",Toast.LENGTH_SHORT).show();
                                    Intent gotocustomerhome = new Intent(RegisterActivity.this,CustomerHome.class);
                                    gotocustomerhome.putExtra("Username",username);
                                    startActivity(gotocustomerhome);
                                }
                                else
                                {
                                    Toast.makeText(RegisterActivity.this,"Some error occured.Please try again.",Toast.LENGTH_SHORT).show();

                                }
                            }
                            else
                            {
                                Toast.makeText(RegisterActivity.this,"Passwords does not match.",Toast.LENGTH_SHORT).show();
                            }
                     }
                 }



             }
        });

    }
}
