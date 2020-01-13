package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.Data.Likes;
import com.example.univerzijada2020.Data.User;
import com.example.univerzijada2020.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User.initialiseUsers();
        Likes.initializeLikes();

        final Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText usernameField = (EditText)findViewById(R.id.username);
                String username = usernameField.getText().toString();

                EditText passwordField = (EditText)findViewById(R.id.password);
                String password = passwordField.getText().toString();

                if(username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(),"Greska: Niste popunili sva polja!",Toast.LENGTH_SHORT).show();
                }

                else{
                    int found = User.findUserAndCheckPassword(username, password);
                    if(found == 0){
                        Toast.makeText(getApplicationContext(),"Greska: Korisnik sa unetim korisnickim imenom ne postoji!",Toast.LENGTH_SHORT).show();
                    }
                    else if(found == 1){
                        Toast.makeText(getApplicationContext(),"Greska: Pogresna lozinka!",Toast.LENGTH_SHORT).show();
                    }
                    else if(found == 2){
                        Toast.makeText(getApplicationContext(),"Uspeh: Uspesno logovanje!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainPage.class);
                        startActivity(intent);
                    }
                }
            }
        });

        final Button registerButton = findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        
        
    }
}
