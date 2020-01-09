package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.Data.User;
import com.example.univerzijada2020.R;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        TextView tw = (TextView)findViewById(R.id.textView2);
        tw.setText("Dobrodosli " + User.currentUser.getUsername());

        final Button infoButton = findViewById(R.id.info);
        infoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, UserInfo.class);
                startActivity(intent);
            }
        });

        final Button passwordChangeButton = findViewById(R.id.passwordChange);
        passwordChangeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, PasswordChange.class);
                startActivity(intent);
            }
        });

        final Button accomodationButton = findViewById(R.id.accomodation);
        accomodationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Button gamesButton = findViewById(R.id.games);
        gamesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, Games.class);
                startActivity(intent);
            }
        });

        final Button touristButton = findViewById(R.id.tourist);
        touristButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Button requestButton = findViewById(R.id.request);
        requestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, Request.class);
                startActivity(intent);
            }
        });

        final Button logoutButton = findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
