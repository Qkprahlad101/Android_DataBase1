package com.example.android.test_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button mSenddata;
    private EditText mvaluefield;
    private EditText mkeyvalue;

    private Button op;


    private Firebase mrootref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mrootref= new Firebase("https://testapplication-1e2bb.firebaseio.com/Users");   //reference link to firebase database
        mkeyvalue = (EditText)findViewById(R.id.keyvalue);
        mSenddata = (Button)findViewById(R.id.senddata);
        mvaluefield = (EditText)findViewById(R.id.valuefield);


        mSenddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = mvaluefield.getText().toString();
                String key = mkeyvalue.getText().toString();

                Firebase childref  = mrootref.child(key);
                childref.setValue(value);   //push function is use to add a new field with unique key
            }
        });

    }
}
