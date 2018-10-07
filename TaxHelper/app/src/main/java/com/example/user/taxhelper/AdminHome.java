package com.example.user.taxhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminHome extends AppCompatActivity {

    private TextView viewUsers,addUsers,loginasCustomer;
    String adminhomeusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        Bundle adminhomeextras = getIntent().getExtras();
        if(adminhomeextras != null)
        {
            adminhomeusername = adminhomeextras.getString("Username");
        }

        viewUsers = (TextView) findViewById(R.id.viewusersTV);
        addUsers = (TextView) findViewById(R.id.addusersTV);
        loginasCustomer = (TextView) findViewById(R.id.loginascustomTV);

        viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoviewuser = new Intent(AdminHome.this,Users.class);
                gotoviewuser.putExtra("Username",adminhomeusername);
                startActivity(gotoviewuser);

            }
        });

        addUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoadduser = new Intent(AdminHome.this,RegisterActivity.class);
                startActivity(gotoadduser);
            }
        });

        loginasCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocustomerhome = new Intent(AdminHome.this,CustomerHome.class);
                gotocustomerhome.putExtra("Username",adminhomeusername);
                startActivity(gotocustomerhome);
            }
        });
    }
}
