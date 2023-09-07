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
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class DoctorDetailsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Doctor doc[] = new Doctor[5];
    ClassForDB cdb = new ClassForDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerDocDet);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_doc_app);

        Intent obj = getIntent();
        String docType = obj.getStringExtra("title");

        LoadDoc(docType);
    }

    public void LoadDoc(String docType){
        if(docType.compareTo("FamilyPhysician")==0){
            doc = cdb.getDoctorDetails(docType);
        }
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