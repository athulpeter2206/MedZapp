package com.example.medzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname,passw;
    ClassForDB cdb = new ClassForDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = (EditText) findViewById(R.id.eUName);
        passw = (EditText) findViewById(R.id.ePassword);
        uname.setText("");
        passw.setText("");

    }

    public void onRegister(View v){
        Intent obj;
        obj = new Intent("act.regUser");
        startActivity(obj);
    }

    public void onLogin(View v){
        String uName = uname.getText().toString();
        String pass = passw.getText().toString();
        if(uName.equals("") || pass.equals("")){
            Toast.makeText(this,"Enter Username or Password",Toast.LENGTH_LONG).show();
        }else{

            String a[];
            System.out.println(uName);
            a = cdb.getUserDetails(uName);
            System.out.println(a);
            if(a[0] !=""){
                System.out.println(a[3]);
                System.out.println(a[4]);
                if(a[3].equals(pass) && a[4].equals("1")){
                    Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show();
                    System.out.println("User Login Success");
                    Intent obj;
                    obj = new Intent("act.usrHome");
                    obj.putExtra("id",a[0]);
                    obj.putExtra("name",a[1]);
                    obj.putExtra("uname",a[2]);
                    obj.putExtra("passw",a[3]);
                    startActivity(obj);
                }
                else if (a[3].equals(pass) && a[4].equals("0")) {
                    Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show();
                    System.out.println("Admin Login Success");
                }
                else{
                    Toast.makeText(this,"Invalid Password!",Toast.LENGTH_LONG).show();
                    passw.setText("");
                }
            }else{
                Toast.makeText(this,"Invalid Username!", Toast.LENGTH_LONG).show();
            }
        }
    }
}