package com.example.user.taxhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TaxSlabPage extends AppCompatActivity {

    private TextView male2018_19,senior2018_19,supersenior2018_19,male2017_18,senior2017_18,supersenior2017_18,male2016_17,senior2016_17,supersenior2016_17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_slab_page);

        male2018_19 = (TextView) findViewById(R.id.male2018_19tv);
        senior2018_19 = (TextView) findViewById(R.id.senior2018_19tv);
        supersenior2018_19 = (TextView)findViewById(R.id.supersenior2018_19tv);
        male2017_18 = (TextView) findViewById(R.id.male2017_18tv);
        senior2017_18 = (TextView) findViewById(R.id.senior2017_18tv);
        supersenior2017_18 = (TextView)findViewById(R.id.supersenior2017_18tv);
        male2016_17 = (TextView) findViewById(R.id.male2016_17tv);
        senior2016_17 = (TextView) findViewById(R.id.senior2016_17tv);
        supersenior2016_17 = (TextView)findViewById(R.id.supersenior2016_17tv);

        male2018_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab1.class);
                startActivity(int1);
            }
        });
        senior2018_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab2.class);
                startActivity(int1);
            }
        });
        supersenior2018_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab3.class);
                startActivity(int1);
            }
        });
        male2017_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab4.class);
                startActivity(int1);
            }
        });
        senior2017_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab5.class);
                startActivity(int1);
            }
        });
        supersenior2017_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab6.class);
                startActivity(int1);
            }
        });
        male2016_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab7.class);
                startActivity(int1);
            }
        });
        senior2016_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab8.class);
                startActivity(int1);
            }
        });
        supersenior2016_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TaxSlabPage.this,TaxSlab9.class);
                startActivity(int1);
            }
        });



    }
}
