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

public class UpdatePersonalInfoPage extends AppCompatActivity {

    private String username4,up_fullname1,up_usertype1,up_gender1,up_dob1,up_panno1,up_phnno1;
    private EditText up_fullname,up_dob,up_panno,up_phnno;
    private Button update_btn;
    private Spinner up_gender,up_usertype;
    TaxDatabaseHandler update_per_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_personal_info_page);
        Bundle update_profile_extras = getIntent().getExtras();
        if(update_profile_extras != null)
        {
            username4 = update_profile_extras.getString("Username");
        }
        update_per_db = new TaxDatabaseHandler(UpdatePersonalInfoPage.this);
        up_fullname = (EditText) findViewById(R.id.upfullName);
        up_dob = (EditText) findViewById(R.id.upbirthday);
        up_panno = (EditText) findViewById(R.id.uppan_no2);
        up_phnno = (EditText) findViewById(R.id.upphone_no2);
        update_btn = (Button) findViewById(R.id.UpdateButton2);
        up_gender = (Spinner)findViewById(R.id.upgenderspinner2);
        up_usertype = (Spinner) findViewById(R.id.upusertypespinner);
        ArrayAdapter<String> up_genderadapter = new ArrayAdapter<String>(UpdatePersonalInfoPage.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.genderoptions));
        up_genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        up_gender.setAdapter(up_genderadapter);


        ArrayAdapter<String> up_usertypeadapter = new ArrayAdapter<String>(UpdatePersonalInfoPage.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.usertype));
        up_usertypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        up_usertype.setAdapter(up_usertypeadapter);

        Cursor personalinfores = update_per_db.getData("*",username4,TaxDatabaseHandler.T2_PROFILE,TaxDatabaseHandler.T3_C1_USERNAME);
        personalinfores.moveToFirst();
        up_fullname.setText(personalinfores.getString(1));
        up_panno.setText(personalinfores.getString(4));
        up_phnno.setText(personalinfores.getString(5));
        up_dob.setText(personalinfores.getString(6));

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                up_fullname1 = up_fullname.getText().toString();
                up_usertype1 = up_usertype.getSelectedItem().toString();
                up_dob1 = up_dob.getText().toString();
                up_panno1 = up_panno.getText().toString();
                up_phnno1 = up_phnno.getText().toString();
                up_gender1 = up_gender.getSelectedItem().toString();
                if(up_fullname1.equals("") || up_usertype1.equals("") || up_dob1.equals("") || up_panno1.equals("") || up_phnno1.equals("") || up_gender1.equals("Gender"))
                {
                    Toast.makeText(UpdatePersonalInfoPage.this,"Please fill the details.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    update_per_db.updateData(up_fullname1,TaxDatabaseHandler.T2_C2_FULLNAME,TaxDatabaseHandler.T2_PROFILE,TaxDatabaseHandler.T2_C1_USERNAME,username4);
                    update_per_db.updateData(up_usertype1,TaxDatabaseHandler.T2_C3_USERTYPE,TaxDatabaseHandler.T2_PROFILE,TaxDatabaseHandler.T2_C1_USERNAME,username4);
                    update_per_db.updateData(up_dob1,TaxDatabaseHandler.T2_C7_DOB,TaxDatabaseHandler.T2_PROFILE,TaxDatabaseHandler.T2_C1_USERNAME,username4);
                    update_per_db.updateData(up_panno1,TaxDatabaseHandler.T2_C5_PANNO,TaxDatabaseHandler.T2_PROFILE,TaxDatabaseHandler.T2_C1_USERNAME,username4);
                    update_per_db.updateData(up_phnno1,TaxDatabaseHandler.T2_C6_CONTACT,TaxDatabaseHandler.T2_PROFILE,TaxDatabaseHandler.T2_C1_USERNAME,username4);
                    update_per_db.updateData(up_gender1,TaxDatabaseHandler.T2_C4_GENDER,TaxDatabaseHandler.T2_PROFILE,TaxDatabaseHandler.T2_C1_USERNAME,username4);
                    Toast.makeText(UpdatePersonalInfoPage.this,"Profile updated successfully",Toast.LENGTH_SHORT).show();
                    Intent gotocustomhome = new Intent(UpdatePersonalInfoPage.this,CustomerHome.class);
                    gotocustomhome.putExtra("Username",username4);
                    startActivity(gotocustomhome);
                }

            }
        });



    }
}
