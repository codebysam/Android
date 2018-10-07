package com.example.user.taxhelper;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerHome extends AppCompatActivity {

    private TextView fullname3;
    private ImageView view_profile, calc_tax, view_taxslab, view_settings, view_itreturns, view_links;
    String username2;
    TaxDatabaseHandler mytaxdb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        fullname3 = (TextView)findViewById(R.id.fullName3);
        view_profile = (ImageView) findViewById(R.id.grid1);
        calc_tax= (ImageView) findViewById(R.id.grid2);
        view_taxslab= (ImageView) findViewById(R.id.grid3);
        view_itreturns= (ImageView) findViewById(R.id.grid4);
        view_links= (ImageView) findViewById(R.id.grid5);
        view_settings= (ImageView) findViewById(R.id.grid6);
        Bundle customhome_extras = getIntent().getExtras();
        if(customhome_extras != null)
        {
            username2 = customhome_extras.getString("Username");
        }
        mytaxdb3 = new TaxDatabaseHandler(CustomerHome.this);
        Cursor customhomeresult = mytaxdb3.getData("*",username2,"PROFILE","USERNAME");
        customhomeresult.moveToFirst();
        fullname3.setText(customhomeresult.getString(1));





        view_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_profile = new Intent(CustomerHome.this,CustomerProfile.class);
                goto_profile.putExtra("Username",username2);
                startActivity(goto_profile);
            }
        });

        calc_tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_tax_calc = new Intent(CustomerHome.this,TaxCalculatorPage.class);
                goto_tax_calc.putExtra("Username",username2);
                startActivity(goto_tax_calc);
            }
        });

        view_taxslab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_taxslab = new Intent(CustomerHome.this,TaxSlabPage.class);
                goto_taxslab.putExtra("Username",username2);
                startActivity(goto_taxslab);
            }
        });

        view_itreturns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_itreturn = new Intent(CustomerHome.this,ITreturnPage.class);
                goto_itreturn.putExtra("Username",username2);
                startActivity(goto_itreturn);
            }
        });

        view_links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_links = new Intent(CustomerHome.this,LinksPage.class);
                goto_links.putExtra("Username",username2);
                startActivity(goto_links);
            }
        });

        view_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_settings = new Intent(CustomerHome.this,SettingsPage.class);
                goto_settings.putExtra("Username",username2);
                startActivity(goto_settings);
            }
        });


    }
}
