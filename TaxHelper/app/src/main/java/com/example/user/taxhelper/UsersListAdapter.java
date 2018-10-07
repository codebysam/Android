package com.example.user.taxhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 8/21/2018.
 */

public class UsersListAdapter extends BaseAdapter {

    private Context row_context;
    private ArrayList<HashMap<String,String>> row_details;
    private static LayoutInflater inflater = null;
    private TextView userfullname,userusertype,userDOB,userGender,userPhnno,userPanno;

    public UsersListAdapter(Context newContext, ArrayList<HashMap<String, String>> details)
    {
        row_context = newContext;
        row_details = details;
        inflater = (LayoutInflater) row_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return row_details.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null)
        {
            view = inflater.inflate(R.layout.users_row_view,null);
        }
        userfullname = (TextView)view.findViewById(R.id.userrowFullname);
        userDOB = (TextView)view.findViewById(R.id.userrowDOB);
        userGender = (TextView)view.findViewById(R.id.userrowGender);
        userusertype = (TextView)view.findViewById(R.id.userrowUsertype);
        userPhnno = (TextView)view.findViewById(R.id.userrowPhnno);
        userPanno = (TextView)view.findViewById(R.id.userrowPanno);

        HashMap<String,String> curr_details = new HashMap<>();
        curr_details = row_details.get(position);
        userfullname.setText(curr_details.get("Fullname"));
        userDOB.setText(curr_details.get("DOB"));
        userPanno.setText(curr_details.get("Panno"));
        userPhnno.setText(curr_details.get("Phnno"));
        userGender.setText(curr_details.get("Gender"));
        userusertype.setText(curr_details.get("Usertype"));

        return view;
    }
}
