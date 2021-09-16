package com.example.navigationdrawer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public  void  ClickMenu(View view){
        openDrawer(drawerLayout);

    }
    public static  void openDrawer(DrawerLayout drawerLayout){
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickLogo(View view){
        //Close drawer
        closeDrawer(drawerLayout);
    }
    public static void  closeDrawer(DrawerLayout drawerLayout){

        //close drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            // when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }
    public  void ClickDashboard(View view){
        //Redirect activity to dashboard
        redirectActivity(this,Dashboard.class);
    }
    public  void ClickAboutUs(View view){
        redirectActivity(this,AboutUs.class);
    }
    public  void ClickLogout(View view){
       //close Application
        logout(this);
    }

    public static void logout(final Activity activity){
        //Exit Dialog Box
            AlertDialog.Builder builder =new AlertDialog.Builder(activity);
            //set title
            builder.setTitle("LogOut");
            //set message
            builder.setMessage("Are you sure you want to Exit?")
                    // if you don't click yes or no in that dialog box but you click another area so it will prevent that
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //finish activity
                          activity.finishAffinity();
                          //Exit app
                            System.exit(0);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

           /* AlertDialog alertDialog = builder.create();
            alertDialog.show();*/
        //Show dialog
               builder.show();
        }


    public   static  void redirectActivity(Activity activity,Class aClass){
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //start Activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}