package com.example.medzapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;

public class DoctorDetailsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Doctor doc[] = new Doctor[5];

    TextView etDN1,etDN2,etDN3,etDN4,etAD1,etAD2,etAD3,etAD4;

    TextView welcomeText;
    ClassForDB cdb = new ClassForDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerDocDet);
        navigationView = findViewById(R.id.nav_view);
        etDN1 = (TextView) findViewById(R.id.etDName);
        etDN2 = (TextView) findViewById(R.id.etDName2);
        etDN3 = (TextView) findViewById(R.id.etDName3);
        etDN4 = (TextView) findViewById(R.id.etDName4);
        etAD1 = (TextView) findViewById(R.id.etAppointDate);
        etAD2 = (TextView) findViewById(R.id.etAppointDate2);
        etAD3 = (TextView) findViewById(R.id.etAppointDate3);
        etAD4 = (TextView) findViewById(R.id.etAppointDate4);
        welcomeText = findViewById(R.id.txtWelcome);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_doc_app);

        Intent obj = getIntent();

        String docType = obj.getStringExtra("title");
        welcomeText.setText(docType);
        Toast.makeText(this,docType,Toast.LENGTH_SHORT).show();

        LoadDoc(docType);
    }

    public void LoadDoc(String docType){
        LocalDate currentDate = LocalDate.now();
        LocalDate nextDate = currentDate.plusDays(1);
        if(docType.compareTo("Family Physician")==0) {
//            Toast.makeText(this, "Inside LoadDoc", Toast.LENGTH_SHORT).show();
            doc = cdb.getDoctorDetails(docType);
            System.out.println(doc[0].Doc_Id);
            etDN1.setText(doc[0].Doc_Name);
            etAD1.setText(nextDate.toString());
            etDN2.setText(doc[1].Doc_Name);
            etAD2.setText(nextDate.toString());
            etDN3.setText(doc[2].Doc_Name);
            etAD3.setText(nextDate.toString());
            etDN4.setText(doc[3].Doc_Name);
            etAD4.setText(nextDate.toString());
        }else if(docType.compareTo("Dietitian")==0){
//            Toast.makeText(this,"Inside LoadDoc",Toast.LENGTH_SHORT).show();
            doc = cdb.getDoctorDetails(docType);
            System.out.println(doc[0].Doc_Id);
            etDN1.setText(doc[0].Doc_Name);
            etAD1.setText(nextDate.toString());
            etDN2.setText(doc[1].Doc_Name);
            etAD2.setText(nextDate.toString());
            etDN3.setText(doc[2].Doc_Name);
            etAD3.setText(nextDate.toString());
            etDN4.setText(doc[3].Doc_Name);
            etAD4.setText(nextDate.toString());
        }else if(docType.compareTo("Dentist")==0){
//            Toast.makeText(this,"Inside LoadDoc",Toast.LENGTH_SHORT).show();
            doc = cdb.getDoctorDetails(docType);
            System.out.println(doc[0].Doc_Id);
            etDN1.setText(doc[0].Doc_Name);
            etAD1.setText(nextDate.toString());
            etDN2.setText(doc[1].Doc_Name);
            etAD2.setText(nextDate.toString());
            etDN3.setText(doc[2].Doc_Name);
            etAD3.setText(nextDate.toString());
            etDN4.setText(doc[3].Doc_Name);
            etAD4.setText(nextDate.toString());
        }
        else if(docType.compareTo("Surgeon")==0){
//            Toast.makeText(this,"Inside LoadDoc",Toast.LENGTH_SHORT).show();
            doc = cdb.getDoctorDetails(docType);
            System.out.println(doc[0].Doc_Id);
            etDN1.setText(doc[0].Doc_Name);
            etAD1.setText(nextDate.toString());
            etDN2.setText(doc[1].Doc_Name);
            etAD2.setText(nextDate.toString());
            etDN3.setText(doc[2].Doc_Name);
            etAD3.setText(nextDate.toString());
            etDN4.setText(doc[3].Doc_Name);
            etAD4.setText(nextDate.toString());
        }
        else if(docType.compareTo("Cardiologist")==0){
//            Toast.makeText(this,"Inside LoadDoc",Toast.LENGTH_SHORT).show();
            doc = cdb.getDoctorDetails(docType);
            System.out.println(doc[0].Doc_Id);
            etDN1.setText(doc[0].Doc_Name);
            etAD1.setText(nextDate.toString());
            etDN2.setText(doc[1].Doc_Name);
            etAD2.setText(nextDate.toString());
            etDN3.setText(doc[2].Doc_Name);
            etAD3.setText(nextDate.toString());
            etDN4.setText(doc[3].Doc_Name);
            etAD4.setText(nextDate.toString());
        }
        else if(docType.compareTo("Orthopedic")==0){
//            Toast.makeText(this,"Inside LoadDoc",Toast.LENGTH_SHORT).show();
            doc = cdb.getDoctorDetails(docType);
            System.out.println(doc[0].Doc_Id);
            etDN1.setText(doc[0].Doc_Name);
            etAD1.setText(nextDate.toString());
            etDN2.setText(doc[1].Doc_Name);
            etAD2.setText(nextDate.toString());
            etDN3.setText(doc[2].Doc_Name);
            etAD3.setText(nextDate.toString());
            etDN4.setText(doc[3].Doc_Name);
            etAD4.setText(nextDate.toString());
        }
    }

    public void onBackDocApp(View view){
        startActivity(new Intent(this, DoctorAppointment.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_home){
            startActivity(new Intent( DoctorDetailsActivity.this, UserHome.class));
            return true;
        }else if(item.getItemId()==R.id.action_notification){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId()==R.id.action_logout) {
            startActivity(new Intent( DoctorDetailsActivity.this, MainActivity.class));
            return true;
        }else if(item.getItemId()==R.id.nav_lab_test){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.nav_doc_app){
            startActivity(new Intent( DoctorDetailsActivity.this, DoctorAppointment.class));
            return true;
        }else if(item.getItemId()==R.id.nav_med){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.nav_health_articles){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

}