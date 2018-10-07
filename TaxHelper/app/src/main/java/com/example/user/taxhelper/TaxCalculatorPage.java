package com.example.user.taxhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TaxCalculatorPage extends AppCompatActivity {



    private Spinner yearspin,usertypespin;
    private EditText getSalary ;
    private TextView gettax,getcess,getrebate,getsurcharge,gettotaltax;
    private Button calcTaxbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_calculator_page);
        getSalary = (EditText) findViewById(R.id.getsalaryET);
        gettax = (TextView) findViewById(R.id.taxTV);
        getcess = (TextView) findViewById(R.id.cessTV);
        getrebate = (TextView) findViewById(R.id.rebateTV);
        getsurcharge = (TextView) findViewById(R.id.surchargeTV);
        gettotaltax = (TextView) findViewById(R.id.totaltaxTV);
        calcTaxbtn = (Button) findViewById(R.id.gettotaltaxbtn);

        yearspin = (Spinner)findViewById(R.id.yearspin);
        usertypespin = (Spinner) findViewById(R.id.usertypespin);
        ArrayAdapter<String> yearadapter = new ArrayAdapter<String>(TaxCalculatorPage.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.years));
        yearadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearspin.setAdapter(yearadapter);


        ArrayAdapter<String> usertypeadapter = new ArrayAdapter<String>(TaxCalculatorPage.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.usertype));
        usertypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        usertypespin.setAdapter(usertypeadapter);

        calcTaxbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IT_Details result = new IT_Details(0,0,0,0,0);
                if(yearspin.getSelectedItem().toString().equals("2018-19"))
                {
                    if(usertypespin.getSelectedItem().toString().equals("Individual Youth"))
                    {
                        result = CalculateTax.individual_2018_19(Double.parseDouble(getSalary.getText().toString()));
                    }
                    else if(usertypespin.getSelectedItem().toString().equals("Senior Citizen"))
                    {
                        result = CalculateTax.senior_2018_19(Double.parseDouble(getSalary.getText().toString()));
                    }
                    else if(usertypespin.getSelectedItem().toString().equals("Supersenior Citizen"))
                    {
                        result = CalculateTax.supersenior_2018_19(Double.parseDouble(getSalary.getText().toString()));
                    }
                }
                else
                if(yearspin.getSelectedItem().toString().equals("2017-18"))
                {
                    if(usertypespin.getSelectedItem().toString().equals("Individual Youth"))
                    {

                    }
                    else if(usertypespin.getSelectedItem().toString().equals("Senior Citizen"))
                    {

                    }
                    else if(usertypespin.getSelectedItem().toString().equals("Supersenior Citizen"))
                    {

                    }
                }
                else if(yearspin.getSelectedItem().toString().equals("2016-17"))
                {
                    if(usertypespin.getSelectedItem().toString().equals("Individual Youth"))
                    {

                    }
                    else if(usertypespin.getSelectedItem().toString().equals("Senior Citizen"))
                    {

                    }
                    else if(usertypespin.getSelectedItem().toString().equals("Supersenior Citizen"))
                    {

                    }
                }

                gettax.setText(String.valueOf(result.tax));
                getcess.setText(String.valueOf(result.cess));
                getrebate.setText(String.valueOf(result.rebate));
                getsurcharge.setText(String.valueOf(result.surcharge));
                gettotaltax.setText(String.valueOf(result.totaltax));
            }
        });

    }
}
