package com.example.user.taxhelper;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class ITreturnPage extends AppCompatActivity {

    private TextView taxtv,cesstv,rebatetv,surchargetv,totaltaxtv,salarytv,otherstv;
    private LinearLayout showItdetails,getItdetails;
    private EditText getsalary,getothers,getyear;
    TaxDatabaseHandler Itreturndb;
    private Button adddetails;
    String Itreturnusername,year,others,salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itreturn_page);
        showItdetails = (LinearLayout) findViewById(R.id.showItdetailslayout);
        getItdetails = (LinearLayout) findViewById(R.id.getItdetailslayout);
        getsalary = (EditText) findViewById(R.id.salaryeditText);
        getothers = (EditText) findViewById(R.id.othersourceseditText);
        getyear  = (EditText) findViewById(R.id.yeareditText);
        adddetails = (Button) findViewById(R.id.adddetailsbtn);
        taxtv = (TextView) findViewById(R.id.taxtv1) ;
        cesstv = (TextView) findViewById(R.id.cesstv1);
        surchargetv = (TextView) findViewById(R.id.surchargetv1);
        rebatetv = (TextView) findViewById(R.id.rebatetv1);
        totaltaxtv = (TextView) findViewById(R.id.totaltaxtv1);
        salarytv = (TextView) findViewById(R.id.salarytv1);
        otherstv = (TextView) findViewById(R.id.otherstv1);

        Bundle Itreturnextras = getIntent().getExtras();
        if(Itreturnextras != null)
        {
            Itreturnusername = Itreturnextras.getString("Username");
        }
        Itreturndb = new TaxDatabaseHandler(ITreturnPage.this);

        Cursor Itreturnresult1 = Itreturndb.getData("*",Itreturnusername,TaxDatabaseHandler.T3_IT_DETAILS,TaxDatabaseHandler.T3_C1_USERNAME);
        if(Itreturnresult1.getCount() > 0)
        {
            showItdetails.setVisibility(View.VISIBLE);
            Itreturnresult1.moveToFirst();
            taxtv.setText(Itreturnresult1.getString(4));
            cesstv.setText(Itreturnresult1.getString(5));
            rebatetv.setText(Itreturnresult1.getString(6));
            surchargetv.setText(Itreturnresult1.getString(7));
            totaltaxtv.setText(Itreturnresult1.getString(8));
            salarytv.setText(Itreturnresult1.getString(2));
            otherstv.setText(Itreturnresult1.getString(3));
        }
        else
        {
            getItdetails.setVisibility(View.VISIBLE);
            adddetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    year = getyear.getText().toString();
                    salary = getsalary.getText().toString();
                    others = getothers.getText().toString();
                    getItdetails.setVisibility(View.VISIBLE);
                    if (year.equals("") || salary.equals("") || others.equals("")) {
                        Toast.makeText(ITreturnPage.this,"Please fill the details",Toast.LENGTH_SHORT).show();
                    } else {
                        Cursor Itreturnresult2 = Itreturndb.getData("*", Itreturnusername, TaxDatabaseHandler.T2_PROFILE, TaxDatabaseHandler.T2_C1_USERNAME);
                        Itreturnresult2.moveToFirst();

                        IT_Details result = new IT_Details(0, 0, 0, 0, 0);
                        if (getyear.getText().toString().equals("2018-19")) {
                            if (Itreturnresult2.getString(2).toString().equals("Individual Youth")) {
                                result = CalculateTax.individual_2018_19(Double.parseDouble(salary) + Double.parseDouble(others));
                            } else if (Itreturnresult2.getString(2).toString().equals("Senior Citizen")) {
                                result = CalculateTax.senior_2018_19(Double.parseDouble(salary) + Double.parseDouble(others));
                            } else if (Itreturnresult2.getString(2).toString().equals("Supersenior Citizen")) {
                                result = CalculateTax.supersenior_2018_19(Double.parseDouble(salary) + Double.parseDouble(others));
                            }
                        } else if (getyear.getText().toString().equals("2017-18")) {
                            if (Itreturnresult2.getString(2).toString().equals("Individual Youth")) {
                                result = CalculateTax.individual_2017_18(Double.parseDouble(salary) + Double.parseDouble(others));
                            } else if (Itreturnresult2.getString(2).toString().equals("Senior Citizen")) {
                                result = CalculateTax.senior_2017_18(Double.parseDouble(salary) + Double.parseDouble(others));
                            } else if (Itreturnresult2.getString(2).toString().equals("Supersenior Citizen")) {
                                result = CalculateTax.supersenior_2017_18(Double.parseDouble(salary) + Double.parseDouble(others));
                            }
                        } else if (getyear.getText().toString().equals("2016-17")) {
                            if (Itreturnresult2.getString(2).toString().equals("Individual Youth")) {
                                result = CalculateTax.individual_2016_17(Double.parseDouble(salary) + Double.parseDouble(others));
                            } else if (Itreturnresult2.getString(2).toString().equals("Senior Citizen")) {
                                result = CalculateTax.senior_2016_17(Double.parseDouble(salary) + Double.parseDouble(others));
                            } else if (Itreturnresult2.getString(2).toString().equals("Supersenior Citizen")) {
                                result = CalculateTax.supersenior_2016_17(Double.parseDouble(salary) + Double.parseDouble(others));
                            }
                        }

                        Itreturndb.insertItdetails(Itreturnusername, year, salary, others, String.valueOf(result.tax), String.valueOf(result.cess), String.valueOf(result.rebate), String.valueOf(result.surcharge), String.valueOf(result.totaltax));
                        taxtv.setText(String.valueOf(result.tax));
                        cesstv.setText(String.valueOf(result.cess));
                        rebatetv.setText(String.valueOf(result.rebate));
                        surchargetv.setText(String.valueOf(result.surcharge));
                        totaltaxtv.setText(String.valueOf(result.totaltax));
                        salarytv.setText(salary);
                        otherstv.setText(others);
                        showItdetails.setVisibility(View.VISIBLE);
                        getItdetails.setVisibility(View.INVISIBLE);
                    }
                }
            });

        }

    }
}
