package com.example.user.taxhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingsPage extends AppCompatActivity {

    private String username3;
    private TextView updatePersonalInfo,updateItdetails,changepassowrd,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        Bundle settings_extras = getIntent().getExtras();
        if(settings_extras != null)
        {
            username3 = settings_extras.getString("Username");
        }
        updatePersonalInfo = (TextView) findViewById(R.id.updatepersonalinfotv);
        updateItdetails = (TextView)findViewById(R.id.updateItdetailstv);
        changepassowrd = (TextView) findViewById(R.id.changePasswordtv);
        logout = (TextView) findViewById(R.id.logouttv);

        updatePersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_up_per_info = new Intent(SettingsPage.this,UpdatePersonalInfoPage.class);
                goto_up_per_info.putExtra("Username",username3);
                startActivity(goto_up_per_info);
            }
        });

        updateItdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_up_it_details = new Intent(SettingsPage.this,UpdateITreturnDetailsPage.class);
                goto_up_it_details.putExtra("Username",username3);
                startActivity(goto_up_it_details);
            }
        });

        changepassowrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_chng_password = new Intent(SettingsPage.this,ChangePasswordPage.class);
                goto_chng_password.putExtra("Username",username3);
                startActivity(goto_chng_password);
             }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_home = new Intent(SettingsPage.this,MainActivity.class);
                startActivity(goto_home);
            }
        });
    }
}
