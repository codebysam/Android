package com.example.user.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static double num1=0.0,num2=0.0;
    private static String op = "";
    private String str = "0";
    private static TextView text,num1_text,num2_text,op_text;
    private Button  btn0,btn1,btn2,btn3,btn4,
                    btn5,btn6,btn7,btn8,btn9,
                    btn_add,btn_sub,btn_div,btn_mul,btn_dot,
                    btn_result,btn_del,btn_per,btn_reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);
        num1_text = (TextView) findViewById(R.id.num1_id);
        num2_text = (TextView) findViewById(R.id.num2_id);
        op_text = (TextView) findViewById(R.id.op_id);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_per = (Button) findViewById(R.id.btn_percent);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_result = (Button) findViewById(R.id.btn_result);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_per.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
        btn_result.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        if(str.equals("Infinity"))
            str = "";
        String opr;
        int l = str.length();
        text.setTextSize(40.0f);
        switch (v.getId())
        {
            case R.id.btn0:
                if(!str.equals("0") && !(l > 2 && (str.charAt(l-2) == '+' || str.charAt(l-2) == '-' || str.charAt(l-2) == '*' || str.charAt(l-2) == '/') && str.charAt(l-1) == '0'))
                    str += b.getText().toString();
                generate_number(str);
                text.setText(str);
                break;
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                if(str.equals("0"))
                    str = "";
                else if(l > 2 && (str.charAt(l-2) == '+' || str.charAt(l-2) == '-' || str.charAt(l-2) == '*' || str.charAt(l-2) == '/') && str.charAt(l-1) == '0')
                    str = delete_last_char(str);
                str += b.getText().toString();
                generate_number(str);
                text.setText(str);
                break;
            case R.id.btn_dot:
                if(check_dot(str)) {
                    if(str.equals("") || str.charAt(l-1) == '+' || str.charAt(l-1) == '-' || str.charAt(l-1) == '*' || str.charAt(l-1) == '/' )
                        str += "0.";
                    else
                        str += b.getText().toString();
                }
                generate_number(str);
                text.setText(str);
                break;
            case R.id.btn_percent:
                generate_number(str);
                str = String.valueOf(num1 / 100.0);
                reset();
                generate_number(str);
                text.setText(str);
                break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                str = insert_operator(str, b.getText().toString());
                generate_number(str);
                text.setText(str);
                break;
            case R.id.btn_del:
                str = delete_last_char(str);
                generate_number(str);
                text.setText(str);
                break;
            case R.id.btn_reset:
                reset();
                str = "0";
                text.setText(str);
                break;
            case R.id.btn_result:
                generate_number(str);
                str = compute_result(str);
                text.setTextSize(60.0f);
                generate_number(str);
                text.setText(str);
                break;
        }

    }

    static String insert_operator(String s,String ch)
    {
        int l = s.length();
        char chr = s.charAt(l-1);
        if(chr == '+' || chr == '-' || chr == '*' || chr == '/')
        {
            s = delete_last_char(s);
        }
        else
        if(!op.equals(""))
        {
            generate_number(s);
            s = compute_result(s);
        }
        s += ch;
        op = ch;
        op_text.setText(op);
        return s;
    }

    static void generate_number(String s) {
        num2 = 0.0;
        boolean negative = false,flag = true;
        String s1 = s;
        if(op != null) {
            if (s.charAt(0) == '-') {
                negative = true;
                s1 = s.substring(1);
            }
            int l = s1.length();
            for (int i = 0; i < l; i++) {
                char ch = s1.charAt(i);
                if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    num1 = Double.parseDouble(s.substring(0, i));
                    flag = false;
                    if ((l - i) > 1)
                    {
                        if (s.charAt(0) == '-')
                            i++;
                        num2 = Double.parseDouble(s.substring(i + 1));
                    }
                    break;
                }
            }
        }
        if(flag)
        {
            op = "";
            op_text.setText(op);
            num1 = Double.parseDouble(s);
        }

            if (negative && num1 > 0)
                num1 = -1 * num1;
            num1_text.setText(String.valueOf(num1));
            num2_text.setText(String.valueOf(num2));
    }

    static String delete_last_char(String s) {
        int l = s.length();
        if (l > 1) {
            s = s.substring(0, l - 1);
        } else {
            s = "0";
        }
        return s;
    }


    static boolean check_dot(String s)
    {
        int ind,l = s.length();
        if (op.equals(""))
        {
            ind = l;
            for(int i = 0;i < ind;i++)
            {
                if(s.charAt(i) == '.')
                    return false;
            }
        }
        else
        {
            ind = s.indexOf(op);
            for(int i = ind;i < l;i++)
            {
                if(s.charAt(i) == '.')
                    return false;
            }
        }
        return true;
    }

    static String compute_result(String s)
    {
        if(!op.equals("")) {
            double result = 0.0;
            switch (op.charAt(0)) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;

            }
            num1 = result;
            num2 = 0.0;
            op = "";

            num1_text.setText(String.valueOf(num1));
            num2_text.setText(String.valueOf(num2));
            op_text.setText(op);
            int res = (int)result;
            if(result == res)
                return String.valueOf(res);
            else
                return String.valueOf(result);
        }
        return s;
    }

    static void reset()
    {
        num1 = 0.0;
        num2 = 0.0;
        op = "";
        num1_text.setText(String.valueOf(num1));
        num2_text.setText(String.valueOf(num2));
        op_text.setText(op);
    }
}
