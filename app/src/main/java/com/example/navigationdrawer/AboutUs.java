package com.example.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        //Open Drawer
        MainActivity.openDrawer(drawerLayout);

    }
    public void ClickLogo(View view){
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);

    }

    public void ClickHome(View view){
        //Redirect activity to Home
        MainActivity.redirectActivity(this,MainActivity.class);

    }

    public void ClickDashboard(View view){
        //Redirect activity to Dashboard
        MainActivity.redirectActivity(this,Dashboard.class);

    }
    public void ClickAboutUs(View view){
        //Recreate activity
        recreate();


    }
    public void ClickLogout(View view){
        //Redirect activity to Home
        MainActivity.logout(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}