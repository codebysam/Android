package com.example.user.taxhelper;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CustomerProfile extends AppCompatActivity {

    TaxDatabaseHandler mytaxdb4;
    private TextView customfullname,customgender,customdob,customusertype,custompanno,customphnno;
    String username4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);
        Bundle customprofileextra = getIntent().getExtras();
        if (customprofileextra != null)
        {
            username4 = customprofileextra.getString("Username");
        }

        customfullname = (TextView) findViewById(R.id.customfullnametv);
        customgender = (TextView) findViewById(R.id.customgendertv);
        customdob = (TextView) findViewById(R.id.customdobtv);
        customusertype = (TextView) findViewById(R.id.customusertypetv);
        custompanno = (TextView) findViewById(R.id.custompannotv);
        customphnno = (TextView) findViewById(R.id.customphn_notv);

        mytaxdb4 = new TaxDatabaseHandler(CustomerProfile.this);
        Cursor customprofileresult = mytaxdb4.getData("*",username4,TaxDatabaseHandler.T2_PROFILE,TaxDatabaseHandler.T2_C1_USERNAME);
        customprofileresult.moveToFirst();

        customfullname.setText(customprofileresult.getString(1));
        customgender.setText(customprofileresult.getString(3));
        customdob.setText(customprofileresult.getString(6));
        customusertype.setText(customprofileresult.getString(2));
        custompanno.setText(customprofileresult.getString(4));
        customphnno.setText(customprofileresult.getString(5));
    }
}
