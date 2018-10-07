package com.example.user.taxhelper;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateITreturnDetailsPage extends AppCompatActivity {

    private EditText getsalary2,getothers2,getyear2;
    TaxDatabaseHandler Itreturndb2;
    private Button adddetails2;
    String Itreturnusername2,year2,others2,salary2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_itreturn_details_page);
        getsalary2 = (EditText) findViewById(R.id.salaryeditText2);
        getothers2 = (EditText) findViewById(R.id.othersourceseditText2);
        getyear2  = (EditText) findViewById(R.id.yeareditText2);
        adddetails2 = (Button) findViewById(R.id.updateItdetailsbtn2);
        Bundle Itreturnextras2 = getIntent().getExtras();
        if(Itreturnextras2 != null)
        {
            Itreturnusername2 = Itreturnextras2.getString("Username");
        }
        Itreturndb2 = new TaxDatabaseHandler(UpdateITreturnDetailsPage.this);

        adddetails2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year2 = getyear2.getText().toString();
                salary2 = getsalary2.getText().toString();
                others2 = getothers2.getText().toString();
                if (year2.equals("") || salary2.equals("") || others2.equals("")) {
                    Toast.makeText(UpdateITreturnDetailsPage.this,"Please fill the details",Toast.LENGTH_SHORT).show();
                } else {

                    Cursor Itreturnresult2 = Itreturndb2.getData("*", Itreturnusername2, TaxDatabaseHandler.T2_PROFILE, TaxDatabaseHandler.T2_C1_USERNAME);
                    Itreturnresult2.moveToFirst();
                    IT_Details result = new IT_Details(0, 0, 0, 0, 0);
                    if (getyear2.getText().toString().equals("2018-19")) {
                        if (Itreturnresult2.getString(2).toString().equals("Individual Youth")) {
                            result = CalculateTax.individual_2018_19(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        } else if (Itreturnresult2.getString(2).toString().equals("Senior Citizen")) {
                            result = CalculateTax.senior_2018_19(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        } else if (Itreturnresult2.getString(2).toString().equals("Supersenior Citizen")) {
                            result = CalculateTax.supersenior_2018_19(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        }
                    } else if (getyear2.getText().toString().equals("2017-18")) {
                        if (Itreturnresult2.getString(2).toString().equals("Individual Youth")) {
                            result = CalculateTax.individual_2017_18(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        } else if (Itreturnresult2.getString(2).toString().equals("Senior Citizen")) {
                            result = CalculateTax.senior_2017_18(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        } else if (Itreturnresult2.getString(2).toString().equals("Supersenior Citizen")) {
                            result = CalculateTax.supersenior_2017_18(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        }
                    } else if (getyear2.getText().toString().equals("2016-17")) {
                        if (Itreturnresult2.getString(2).toString().equals("Individual Youth")) {
                            result = CalculateTax.individual_2016_17(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        } else if (Itreturnresult2.getString(2).toString().equals("Senior Citizen")) {
                            result = CalculateTax.senior_2016_17(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        } else if (Itreturnresult2.getString(2).toString().equals("Supersenior Citizen")) {
                            result = CalculateTax.supersenior_2016_17(Double.parseDouble(salary2) + Double.parseDouble(others2));
                        }
                    }

                    Itreturndb2.updateData2(salary2,TaxDatabaseHandler.T3_C3_SALARY,TaxDatabaseHandler.T3_IT_DETAILS,TaxDatabaseHandler.T3_C1_USERNAME,Itreturnusername2,TaxDatabaseHandler.T3_C2_YEAR,year2);
                    Itreturndb2.updateData2(others2,TaxDatabaseHandler.T3_C4_OTHERS,TaxDatabaseHandler.T3_IT_DETAILS,TaxDatabaseHandler.T3_C1_USERNAME,Itreturnusername2,TaxDatabaseHandler.T3_C2_YEAR,year2);
                    Itreturndb2.updateData2(String.valueOf(result.tax),TaxDatabaseHandler.T3_C5_TAX,TaxDatabaseHandler.T3_IT_DETAILS,TaxDatabaseHandler.T3_C1_USERNAME,Itreturnusername2,TaxDatabaseHandler.T3_C2_YEAR,year2);
                    Itreturndb2.updateData2(String.valueOf(result.cess),TaxDatabaseHandler.T3_C6_CESS,TaxDatabaseHandler.T3_IT_DETAILS,TaxDatabaseHandler.T3_C1_USERNAME,Itreturnusername2,TaxDatabaseHandler.T3_C2_YEAR,year2);
                    Itreturndb2.updateData2(String.valueOf(result.rebate),TaxDatabaseHandler.T3_C7_REBATE,TaxDatabaseHandler.T3_IT_DETAILS,TaxDatabaseHandler.T3_C1_USERNAME,Itreturnusername2,TaxDatabaseHandler.T3_C2_YEAR,year2);
                    Itreturndb2.updateData2(String.valueOf(result.surcharge),TaxDatabaseHandler.T3_C8_SURCHARGE,TaxDatabaseHandler.T3_IT_DETAILS,TaxDatabaseHandler.T3_C1_USERNAME,Itreturnusername2,TaxDatabaseHandler.T3_C2_YEAR,year2);
                    Itreturndb2.updateData2(String.valueOf(result.totaltax),TaxDatabaseHandler.T3_C9_TOTAL_TAX,TaxDatabaseHandler.T3_IT_DETAILS,TaxDatabaseHandler.T3_C1_USERNAME,Itreturnusername2,TaxDatabaseHandler.T3_C2_YEAR,year2);
                    Toast.makeText(UpdateITreturnDetailsPage.this,"IT details update successfully.",Toast.LENGTH_SHORT).show();
                    Intent gotoIT_details = new Intent(UpdateITreturnDetailsPage.this,ITreturnPage.class);
                    gotoIT_details.putExtra("Username",Itreturnusername2);
                    startActivity(gotoIT_details);


                }
            }
        });

    }
}
