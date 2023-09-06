package com.example.medzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterUser extends AppCompatActivity {
    EditText name,email,mobile,uname,pass,confPass;
    ClassForDB cdb= new ClassForDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeruser);
        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.Email);
        mobile = (EditText) findViewById(R.id.Phno);
        uname = (EditText) findViewById(R.id.UName);
        pass = (EditText) findViewById(R.id.ePassword);
        confPass = (EditText) findViewById(R.id.eConfPassword);
        name.setText("");
        email.setText("");
        mobile.setText("");
        uname.setText("");
        pass.setText("");
        confPass.setText("");
    }

    public void onRegCancel(View view){
        startActivity(new Intent( RegisterUser.this, MainActivity.class));
    }

    public void onUserRegister(View view) throws InterruptedException {
        String s_name,s_email,s_mobile,s_uname,s_pass,s_confpass;
        s_name = name.getText().toString();
        s_email = email.getText().toString();
        s_mobile = mobile.getText().toString();
        s_uname = uname.getText().toString();
        s_pass = pass.getText().toString();
        s_confpass = confPass.getText().toString();

        if (s_name.length() != 0 && s_email.length() != 0 && s_mobile.length() != 0 && s_uname.length() != 0 && s_pass.length() != 0 && s_confpass.length() != 0) {
//            Toast.makeText(this, "Filled!", Toast.LENGTH_SHORT).show();
            int i = cdb.getUserName(s_name);
//            int i = 0;
            System.out.println(i);
            if(i == 1){
                Toast.makeText(this,"UserName Already Exists ! Please change !",Toast.LENGTH_LONG).show();
            }else {
                System.out.println("Inside Inner If");
                if (s_pass.equals(s_confpass)) {
                    User usr = new User();
                    usr.Name = s_name;
                    usr.Email = s_email;
                    usr.Phno = s_mobile;
                    usr.UName = s_uname;
                    usr.PassW = s_pass;
                    usr.UType = 1;

                    cdb.onUserRegister(usr);

                    name.setText("");
                    email.setText("");
                    mobile.setText("");
                    uname.setText("");
                    pass.setText("");
                    confPass.setText("");
                    Toast.makeText(this, "Used Added Successfully, Please login !", Toast.LENGTH_LONG).show();
                    Intent obj;
                    obj = new Intent("MAIN");
                    startActivity(obj);
                } else {
                    Toast.makeText(this, "Passwords Doesn't match!", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(this, "Fill the Mandatory Fields!", Toast.LENGTH_LONG).show();
        }

    }
}