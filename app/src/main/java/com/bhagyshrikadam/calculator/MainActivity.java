package com.bhagyshrikadam.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bhagyshrikadam.calculator.activities.CalcultorActivity;
import com.bhagyshrikadam.calculator.models.Userinfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    // creating variables for
    // EditText and buttons.
    private EditText UserEmailId,UserName;
    private Button sendDatabtn;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    Userinfo userInfo;
    SharedPreferences sp;

    String prevStarted = "yes";
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        } else {
            moveToSecondary();

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initializing our edittext and button
        UserEmailId = findViewById(R.id.etx_emailid);
        UserName = findViewById(R.id.etx_name);
        sendDatabtn = findViewById(R.id.btn_login);



        // initializing our object
        // class variable.
        userInfo = new Userinfo();


        // adding on click listener for our button.
        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = UserName.getText().toString();
                String email = UserEmailId.getText().toString();
                // below line is for checking weather the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(name) ) {
                    UserName.setError("Enter your name");
                    UserName.requestFocus();
                    return;
                }
                else if(TextUtils.isEmpty(email)) {
                    UserEmailId.setError("Enter your email id");
                    UserEmailId.requestFocus();
                    return;

                } else {
                    // else call the method to add
                    // data to our database.
                    String userID = name;
                    userInfo.setName(name);
                    userInfo.setEmailId(email);
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference();

                    DatabaseReference childDBR = databaseReference.child(userID);
                    childDBR.setValue(userInfo);
                    // after adding this data we are showing toast message.

                    Intent n = new Intent(MainActivity.this, CalcultorActivity.class);
                    startActivity(n);
                }
            }
        });
    }
    public void moveToSecondary(){
        // use an intent to travel from one activity to another.
        Intent intent = new Intent(MainActivity.this,CalcultorActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}