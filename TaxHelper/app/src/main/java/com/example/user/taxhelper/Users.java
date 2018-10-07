package com.example.user.taxhelper;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Users extends AppCompatActivity {

    private ListView userslist;
    private UsersListAdapter detailsrow_adapter;
    String userUsernames[],userNames[],userDOBs[],userUsertypes[],userGenders[],userPhnnos[],userPannos[];
    TaxDatabaseHandler usersdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        usersdb = new TaxDatabaseHandler(Users.this);
        userslist = (ListView) findViewById(R.id.userListView);


        Cursor usersresult = usersdb.getallData(TaxDatabaseHandler.T2_PROFILE);
        int n = usersresult.getCount();
        userUsernames = new String[n];
        userNames = new String[n];
        userDOBs = new String[n];
        userUsertypes = new String[n];
        userGenders = new String[n];
        userPannos = new String[n];
        userPhnnos = new String[n];
        int l = 0;

        while (usersresult.moveToNext())
        {
            userUsernames[l] = usersresult.getString(0);
            userNames[l] = usersresult.getString(1);
            userUsertypes[l] = usersresult.getString(2);
            userGenders[l] = usersresult.getString(3);
            userPannos[l] = usersresult.getString(4);
            userPhnnos[l] = usersresult.getString(5);
            userDOBs[l] = usersresult.getString(6);
            l = l+1;
        }

        ArrayList<HashMap<String,String>> passingdetails = new ArrayList<>();
        for(int i = 0;i < l;i++)
        {
            HashMap<String,String> storedetails = new HashMap<>();
            storedetails.put("Fullname",userNames[i]);
            storedetails.put("Username",userUsernames[i]);
            storedetails.put("Usertype",userUsertypes[i]);
            storedetails.put("DOB",userDOBs[i]);
            storedetails.put("Gender",userGenders[i]);
            storedetails.put("Phnno",userPhnnos[i]);
            storedetails.put("Panno",userPannos[i]);
            passingdetails.add(storedetails);
        }

        detailsrow_adapter = new UsersListAdapter(Users.this,passingdetails);
        userslist.setAdapter(detailsrow_adapter);




    }
}
