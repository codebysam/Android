package com.example.user.taxhelper;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public TaxDatabaseHandler mytaxdb;
    private RadioGroup userTyperadiogrp;
    private RadioButton userTyperadiobtn;
    private EditText userNameEdittext;
    private EditText passwordEdittext;
    private Button loginButton;
    private TextView registerText;
    private String usertype;
    String username1,password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userTyperadiogrp = (RadioGroup) findViewById(R.id.usertyperadio);
        userNameEdittext = (EditText) findViewById(R.id.UserName1);
        passwordEdittext = (EditText) findViewById(R.id.Password1);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerText = (TextView) findViewById(R.id.registertext);
        mytaxdb = new TaxDatabaseHandler(MainActivity.this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTyperadiogrp = (RadioGroup) findViewById(R.id.usertyperadio);
                userTyperadiobtn = (RadioButton) findViewById(userTyperadiogrp.getCheckedRadioButtonId());

                if(userTyperadiobtn == null)
                {
                    Toast.makeText(MainActivity.this,"Please choose the usertype.",Toast.LENGTH_LONG).show();
                }
                else
                {
                    usertype = userTyperadiobtn.getText().toString();

                    username1 = userNameEdittext.getText().toString();
                    password1 = passwordEdittext.getText().toString();
                    if(username1.equals("") || password1.equals(""))
                    {
                        Toast.makeText(MainActivity.this,"Please fill the form.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Cursor result = mytaxdb.getData("*",username1, "LOGIN_DETAILS", "USERNAME");
                        if(result.getCount() <= 0)
                        {
                            Toast.makeText(MainActivity.this,"Username does not exist.",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            result.moveToFirst();
                            if(usertype.equals("Admin"))
                            {
                                if(username1.equals("admin"))
                                {
                                    if(password1.equals(result.getString(1)))
                                    {
                                        Intent gotoAdminHome = new Intent(MainActivity.this, AdminHome.class);
                                        gotoAdminHome.putExtra("Username",username1);
                                        startActivity(gotoAdminHome);
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "Wrong password.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this, "You are not admin.", Toast.LENGTH_SHORT).show();
                                }


                            }
                            else
                            {
                                //Toast.makeText(MainActivity.this,password1+" "+result.getString(1),Toast.LENGTH_SHORT).show();
                                if(password1.equals(result.getString(1)))
                                {
                                    Intent gotoCustomHome = new Intent(MainActivity.this,CustomerHome.class);
                                    gotoCustomHome.putExtra("Username",username1);
                                    startActivity(gotoCustomHome);
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this,"Wrong password.",Toast.LENGTH_SHORT).show();
                                }
                            }


                        }


                    }
                }


            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregisterpage = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(gotoregisterpage);
            }
        });

    }
}
