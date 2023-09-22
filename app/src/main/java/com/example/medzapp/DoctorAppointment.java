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

public class DoctorAppointment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_appointment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_doc_app);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_home){
            onBackPressed();
        }else if(item.getItemId()==R.id.action_notification){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId()==R.id.action_logout) {
            startActivity(new Intent( DoctorAppointment.this, MainActivity.class));
            return true;
        }else if(item.getItemId()==R.id.nav_lab_test){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.nav_doc_app){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
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

    public void onBack(View view){
        startActivity(new Intent(DoctorAppointment.this, UserHome.class));
    }

    public void onFamPhyClick(View v){
        Intent obj = new Intent(this, DoctorDetailsActivity.class);
        obj.putExtra("title","Family Physician");
        startActivity(obj);
    }
    public void onDieticianClick(View v){

    }
    public void onDentistClick(View v){

    }
    public void onSurgClick(View v){

    }
    public void onCardioClick(View v){

    }
    public void onOrthoClick(View v){

    }
}