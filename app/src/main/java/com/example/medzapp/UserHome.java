package com.example.medzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class UserHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    String idpassed,namepassed,unamepassed,passwPassed;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView edtWelcome;
    ClassForDB cdb = new ClassForDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        edtWelcome = (TextView) findViewById(R.id.txtWelcome);
        Bundle b = getIntent().getExtras();
        idpassed = b.getString("id");
        namepassed = b.getString("name");
        unamepassed = b.getString("uname");
        passwPassed = b.getString("passw");

        edtWelcome.setText("Welcome "+namepassed+"!");

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
    }


    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_home){
            onBackPressed();
        }else if(item.getItemId()==R.id.action_notification){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId()==R.id.action_logout) {
            startActivity(new Intent( UserHome.this, MainActivity.class));
            return true;
        }else if(item.getItemId()==R.id.nav_lab_test){
            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.nav_doc_app){
            startActivity(new Intent( UserHome.this, DoctorAppointment.class));
//            Toast.makeText(this,"Coming Soon !",Toast.LENGTH_SHORT).show();
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

    public void onLabTest(View view){
        Toast.makeText(this,"Lab Test",Toast.LENGTH_SHORT).show();
    }

    public void onFindDoctor(View view){
        startActivity(new Intent( UserHome.this, DoctorAppointment.class));
    }
}