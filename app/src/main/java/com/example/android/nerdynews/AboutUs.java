package com.example.android.nerdynews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        NavigationView about_nav_view = findViewById(R.id.about_nav_view);
        DrawerLayout about_drawer = findViewById(R.id.about_drawer);
        about_nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.gmail:

                        break;
                    case R.id.github:
                        String github="https://github.com/Sagar0-0";
                        Intent githubIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(github));
                        startActivity(githubIntent);
                        break;
                    case R.id.twitter:
                        String twitter="https://twitter.com/sagar0_o";
                        Intent twitterIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(twitter));
                        startActivity(twitterIntent);
                        break;
                    case R.id.linkedin:
                        String linkedin="https://www.linkedin.com/in/sagar-malhotra-7021b0204/";
                        Intent linkedinIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(linkedin));
                        startActivity(linkedinIntent);
                        break;
                    case R.id.instagram:
                        String insta="https://www.instagram.com/_sagar_malhotra_/";
                        Intent instaIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(insta));
                        startActivity(instaIntent);
                        break;
                    case R.id.exit:
                        finish();
                        break;
                }

                return true;
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}